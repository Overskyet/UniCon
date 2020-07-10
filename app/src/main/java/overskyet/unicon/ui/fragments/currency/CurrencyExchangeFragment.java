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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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
import overskyet.unicon.ratesconversion.CurrencyConverter;
import overskyet.unicon.ui.activity.HomeScreenActivity;
import overskyet.unicon.utils.MapSerializationAndDeserialization;

public class CurrencyExchangeFragment extends Fragment {

    private FragmentCurrencyExchangeBinding binding;

    private CurrencyExchangeViewModel viewModel;

    private String key1, key2;

    //    // Instance of SharedPreferences object for setting up spinners items
//    private SharedPreferences currencyExchangeFragmentSharedPref;
    private String lastUpdateTime;
    private Map<String, Double> rates;

    // Clipboard manager for copy and paste operations
    private ClipboardManager clipboard;

    // Widgets
    private LinearLayout updateTimeContainer;
    private ScrollView scrollView;
    private TextView lastUpdateTimeContainer;
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

        loadData();

        initCopyButton();

//        // SharedPreferences instance initialization
//        currencyExchangeFragmentSharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE);

        // Clipboard manager initialization
        clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        // Disable input for EditText views
        editTextInput.setKeyListener(null);
        editTextOutput.setKeyListener(null);

        // Spinners block initialization
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.spinner_item, getResources().getStringArray(R.array.currencies));
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        // Spinners listeners
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

        // TODO What am I supposed to do with this Last Update Time block!?
        final ImageButton showKeyboardButton = binding.currencyExchangeImageButtonShowKeyboard;
        showKeyboardButton.setOnClickListener(view -> showKeyboard());
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

    private void loadData() {
        lastUpdateTime = HomeScreenActivity.getSharedPreferences().getString(Constants.EXCHANGE_RATES_LAST_UPDATE_TIME, getString(R.string.last_update_time_error));
        rates = MapSerializationAndDeserialization.deserializeMap(HomeScreenActivity.getSharedPreferences().getString(Constants.EXCHANGE_RATES_SERIALIZED_MAP, null));
        lastUpdateTimeContainer.setText(lastUpdateTime);

        viewModel.initUi();

        viewModel.getLastUpdateTime().observe(getViewLifecycleOwner(), lastUpdateTime -> {
            lastUpdateTimeContainer.setText(lastUpdateTime);
        });
        viewModel.getMapOfRates().observe(getViewLifecycleOwner(), mapOfRates -> {
            rates = mapOfRates;
        });
    }

    private void initViewModelAndDataBinding() {
        viewModel = new ViewModelProvider(this).get(CurrencyExchangeViewModel.class);
        binding.setCurrencyExchange(this);
        binding.setCurrencyExchangeViewModel(viewModel);
    }

    private CurrencyExchangeFragmentArgs getSafeArgs() {
        return CurrencyExchangeFragmentArgs.fromBundle(requireArguments());
    }

    private void initUsingSafeArgs(CurrencyExchangeFragmentArgs args) {

        // Initialize fragment toolbar
        initToolbar(args.getToolbarImageId());

        // Keys initialization
        key1 = args.getKey1();
        key2 = args.getKey2();

    }

    private void initWidgets() {
        updateTimeContainer = binding.currencyExchangeTimeOfUpdateBlock;
        scrollView = binding.currencyExchangeScrollView;
        lastUpdateTimeContainer = binding.currencyExchangeUpdateTimeTextView;
        editTextInput = binding.currencyExchangeInput;
        editTextOutput = binding.currencyExchangeOutput;
        spinnerFrom = binding.currencyExchangeSpinnerFrom;
        spinnerTo = binding.currencyExchangeSpinnerTo;
    }

    private void initCopyButton() {
        final Button copyButton = binding.buttonCopy;
        copyButton.setOnClickListener(view -> copy());
        copyButton.setOnLongClickListener(view -> {
            paste();
            return true;
        });
    }

    private void initToolbar(int icon) {
        Toolbar toolbar = (Toolbar) binding.toolbarFragmentCurrencyExchange;

        NavController navController = Navigation.findNavController(toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        ImageView toolbarImage = toolbar.findViewById(R.id.image_app_toolbar);
        toolbarImage.setImageResource(icon);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void showKeyboard() {
        updateTimeContainer.setVisibility(View.GONE);
        lastUpdateTimeContainer.setVisibility(View.GONE);
        scrollView.setVisibility(View.VISIBLE);
    }

    public void onClickDigitButtons(View v) {
        Button btn = (Button) v;
        editTextInput.setText(editTextInput.getText().append(btn.getText()));
        checkAmountOfDigits();
        convert();
    }

    public void onClickFunctionButtons(View v) {
        switch (v.getId()) {
            // Dot block
            case R.id.button_dot:
                setDotSign();
                break;
            // Delete and Clear block
            case R.id.button_delete:
                checkEmptyInputField();
                checkDigits();
                break;
            case R.id.button_clear:
                editTextInput.getText().clear();
                editTextOutput.getText().clear();
                break;
            //TODO Handle refresh action
            // Refresh block
            case R.id.button_refresh:
                startRefresh();
                break;
            // Reverse block
            case R.id.button_reverse:
                reverse();
                break;
            // Default block
            default:
                break;
        }
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

    //TODO Handle refresh action
    private void startRefresh() {

    }

    private void checkDigits() {
        String inputText = editTextInput.getText().toString();
        //Matcher matcher = Pattern.compile("^-|\\.|-\\.$").matcher(inputText);
        Matcher matcher = Pattern.compile(getResources().getString(R.string.digits_regexp)).matcher(inputText);
        if (matcher.matches() || inputText.isEmpty()) {
            editTextOutput.getText().clear();
        } else {
            convert();
        }
    }

    private void checkAmountOfDigits() {
        String textInput = editTextInput.getText().toString();
        //Matcher matcher = Pattern.compile("^[0-9\\-.]{0,30}(\\.\\d{3})$").matcher(textInput);
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
