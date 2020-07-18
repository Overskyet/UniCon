package overskyet.unicon.ui.fragments.currency;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import overskyet.unicon.Constants;
import overskyet.unicon.R;
import overskyet.unicon.databinding.FragmentCurrencyExchangeBinding;
import overskyet.unicon.utils.CurrencyConverter;
import overskyet.unicon.ui.activity.HomeScreenActivity;
import overskyet.unicon.utils.MapSerializationAndDeserialization;
import overskyet.unicon.utils.NetworkConnection;
import overskyet.unicon.utils.view.TopSheetBehavior;

public class CurrencyExchangeFragment extends Fragment {

    private FragmentCurrencyExchangeBinding binding;

    private CurrencyExchangeViewModel viewModel;

    private String key1, key2;

    private String lastUpdateTime;
    private Map<String, Double> rates;

    // Clipboard manager for copy and paste operations
    private ClipboardManager clipboard;

    // Widgets
    private ConstraintLayout topSheetContainer;
    private TextView lastUpdateTimeData;
    private EditText editTextInput, editTextOutput;
    private Spinner spinnerFrom, spinnerTo;

    private final CurrencyConverter currencyConverter = CurrencyConverter.getInstance();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCurrencyExchangeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {

        initViewModelAndDataBinding();

        initUsingSafeArgs(getSafeArgs());

        initWidgets();

        showTopSheet();

        initCopyButton();

        initClipboard();

        disableEditText();

        initSpinners();

        setupSpinnerListeners();

        initUi();

        loadData();
    }

    @Override
    public void onResume() {
        spinnerFrom.setSelection(HomeScreenActivity.getSharedPreferences().getInt(key1, 0));
        spinnerTo.setSelection(HomeScreenActivity.getSharedPreferences().getInt(key2, 1));
        super.onResume();
    }

    @Override
    public void onPause() {
        HomeScreenActivity.getSharedPreferences().edit()
                .remove(key1)
                .remove(key2)
                .remove(Constants.EXCHANGE_RATES_LAST_UPDATE_TIME)
                .remove(Constants.EXCHANGE_RATES_SERIALIZED_MAP)
                .putInt(key1, spinnerFrom.getSelectedItemPosition())
                .putInt(key2, spinnerTo.getSelectedItemPosition())
                .putString(Constants.EXCHANGE_RATES_LAST_UPDATE_TIME, lastUpdateTime)
                .putString(Constants.EXCHANGE_RATES_SERIALIZED_MAP, MapSerializationAndDeserialization.serializeMap(rates))
                .apply();
        super.onPause();
    }

    private void initUi() {
        lastUpdateTime = HomeScreenActivity.getSharedPreferences().getString(Constants.EXCHANGE_RATES_LAST_UPDATE_TIME, getString(R.string.last_update_time_error));
        rates = MapSerializationAndDeserialization.deserializeMap(HomeScreenActivity.getSharedPreferences().getString(Constants.EXCHANGE_RATES_SERIALIZED_MAP, null));
        lastUpdateTimeData.setText(lastUpdateTime);
    }

    private void setupViewModelObservers() {
        viewModel.getLastUpdateTime().observe(getViewLifecycleOwner(), lastUpdateTime -> {
            this.lastUpdateTime = lastUpdateTime;
            lastUpdateTimeData.setText(lastUpdateTime);
        });
        viewModel.getMapOfRates().observe(getViewLifecycleOwner(), mapOfRates -> {
            this.rates = mapOfRates;
        });
    }

    private void loadData() {
        if (NetworkConnection.hasInternetConnection(requireContext())) {
            viewModel.initUi();
            setupViewModelObservers();
        } else {
            //TODO Add new TextView "internetConnectionError" to lastUpdateTime container
        }
    }

    private void reloadData() {
        // TODO Add reopen of TopSheetDialog
        viewModel.setNotInitialized(true);
        loadData();
    }

    private void initViewModelAndDataBinding() {
        viewModel = new ViewModelProvider(this).get(CurrencyExchangeViewModel.class);
        binding.setCurrencyExchange(this);
    }

    @NonNull
    private CurrencyExchangeFragmentArgs getSafeArgs() {
        return CurrencyExchangeFragmentArgs.fromBundle(requireArguments());
    }

    private void initUsingSafeArgs(@NonNull CurrencyExchangeFragmentArgs args) {

        // Initialize fragment toolbar
        initToolbar(args.getToolbarImageId());

        // Keys initialization
        key1 = args.getKey1();
        key2 = args.getKey2();

    }

    private void initWidgets() {
        topSheetContainer = binding.includeTopSheetContainer.findViewById(R.id.topSheet_constraintLayout);
        lastUpdateTimeData = binding.includeTopSheetContainer.findViewById(R.id.last_update_time_date);
        editTextInput = binding.currencyExchangeInput;
        editTextOutput = binding.currencyExchangeOutput;
        spinnerFrom = binding.currencyExchangeSpinnerFrom;
        spinnerTo = binding.currencyExchangeSpinnerTo;
    }

    private void showTopSheet() {
        TopSheetBehavior.from(topSheetContainer).setState(TopSheetBehavior.STATE_EXPANDED);
    }

    private void initToolbar(int icon) {
        Toolbar toolbar = (Toolbar) binding.toolbarFragmentCurrencyExchange;

        NavController navController = Navigation.findNavController(toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        ImageView toolbarImage = toolbar.findViewById(R.id.image_app_toolbar);
        toolbarImage.setImageResource(icon);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void setupSpinnerListeners() {
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkDigits();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkDigits();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void initSpinners() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.spinner_item, getResources().getStringArray(R.array.currencies));
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);
    }

    private void disableEditText() {
        editTextInput.setKeyListener(null);
        editTextOutput.setKeyListener(null);
    }

    private void initClipboard() {
        clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void onClickDigitButtons(View v) {
        Button btn = (Button) v;
        editTextInput.setText(editTextInput.getText().append(btn.getText()));
        checkAmountOfDigits();
        convert();
    }

    public void onClickFunctionButtons(@NonNull View v) {
        switch (v.getId()) {
            case R.id.button_dot:
                setDotSign();
                break;
            case R.id.button_delete:
                checkEmptyInputField();
                checkDigits();
                break;
            case R.id.button_clear:
                clear();
                break;
            case R.id.button_refresh:
                reloadData();
                break;
            case R.id.button_reverse:
                reverse();
                break;
            default:
                break;
        }
    }

    private void initCopyButton() {
        Button button = binding.buttonCopy;
        button.setOnClickListener(view -> copy());
        button.setOnLongClickListener(view -> {
            paste();
            return true;
        });
    }

    private void setDotSign() {
        String text = editTextInput.getText().toString();
        if (text.contains(".")) {
            editTextInput.setText(editTextInput.getText());
        } else {
            editTextInput.setText(editTextInput.getText().append('.'));
        }
    }

    private void checkEmptyInputField() {
        String text = editTextInput.getText().toString();
        if (text.isEmpty()) {
            editTextInput.setText(editTextInput.getText());
        } else {
            editTextInput.setText(text.substring(0, text.length() - 1));
        }
    }

    private void checkDigits() {
        String inputText = editTextInput.getText().toString();
        Matcher matcher = Pattern.compile(getResources().getString(R.string.digits_regexp)).matcher(inputText);
        if (matcher.matches() || inputText.isEmpty()) {
            editTextOutput.getText().clear();
        } else {
            convert();
        }
    }

    private void checkAmountOfDigits() {
        String textInput = editTextInput.getText().toString();
        Matcher matcher = Pattern.compile(getResources().getString(R.string.max_amount_of_chars_regexp)).matcher(textInput);
        if (textInput.length() > 30 || matcher.matches()) {
            editTextInput.setText(textInput.substring(0, textInput.length() - 1));
        }
    }

    private void checkAmountOfDigitsForPasteValue() {
        String textInput = editTextInput.getText().toString();
        if (textInput.length() > 30) {
            String str = getResources().getString(R.string.max_length_of_pasted_value_exceeded_notification);
            editTextInput.setText(textInput.substring(0, 30));
            showInfoText(str);
        }
    }

    private void clear() {
        editTextInput.getText().clear();
        editTextOutput.getText().clear();
    }

    private void copy() {
        ClipData clip = ClipData.newPlainText("Output", editTextOutput.getText());
        clipboard.setPrimaryClip(clip);
        String str = getResources().getString(R.string.copy_notification);
        showInfoText(str);
    }

    private void paste() {
        try {
            if (clipboard.hasPrimaryClip()) {
                if (Objects.requireNonNull(clipboard.getPrimaryClipDescription()).hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    ClipData.Item item = Objects.requireNonNull(clipboard.getPrimaryClip()).getItemAt(0);
                    String pasteData = item.getText().toString();
                    editTextInput.setText(pasteData);
                    checkAmountOfDigitsForPasteValue();
                    convert();
                }
            }
        } catch (NumberFormatException e) {
            String str = getResources().getString(R.string.incorrect_paste_value_notification);
            showInfoText(str);
            editTextInput.getText().clear();
            editTextOutput.getText().clear();
        }
    }

    private void reverse() {
        int selectedFrom = spinnerFrom.getSelectedItemPosition();
        int selectedTo = spinnerTo.getSelectedItemPosition();
        spinnerFrom.setSelection(selectedTo);
        spinnerTo.setSelection(selectedFrom);
    }

    private void showInfoText(String infoMsg) {
        Toast.makeText(requireActivity(), infoMsg, Toast.LENGTH_LONG).show();
    }

    private void convert() {
        final String spinnerItemFrom = spinnerFrom.getSelectedItem().toString().substring(0, 3);
        final String spinnerItemTo = spinnerTo.getSelectedItem().toString().substring(0, 3);

        final BigDecimal amount = new BigDecimal(editTextInput.getText().toString());
        // Use values from spinners and input field
        final BigDecimal bigDecimalOutput = currencyConverter.convert(spinnerItemFrom, spinnerItemTo, amount, rates);
        // Init output field
        final String output = bigDecimalOutput == null ? getString(R.string.exchange_rates_load_error) : bigDecimalOutput.toString();
        editTextOutput.setText(output);
    }
}
