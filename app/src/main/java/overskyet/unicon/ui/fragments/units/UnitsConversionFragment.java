package overskyet.unicon.ui.fragments.units;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import overskyet.unicon.R;
import overskyet.unicon.databinding.FragmentUnitsConversionBinding;
import overskyet.unicon.ui.activity.HomeScreenActivity;
import overskyet.unicon.ui.fragments.currency.CurrencyExchangeFragmentArgs;
import overskyet.unicon.utils.UnitsConverter;

public class UnitsConversionFragment extends Fragment {

    // Data Binding variable
    private FragmentUnitsConversionBinding binding;

    // Key values for saving preferences and conversion() method
    private String key1, key2;
    private String[] spinnerItems;

    // Clipboard manager for copy and paste operations
    private ClipboardManager clipboard;

    // Widgets
    private EditText editTextInput, editTextOutput;
    private Spinner spinnerFrom, spinnerTo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        binding = FragmentUnitsConversionBinding.inflate(
                inflater,
                container,
                false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View v,
                              @Nullable Bundle savedInstanceState)
    {

        binding.setUnitsConversion(this);

        initUsingSafeArgs(getSafeArgs());

        initWidgets();

        initCopyButton();

        // Clipboard manager initialization
        clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        // Disable input option for EditText views
        editTextInput.setKeyListener(null);
        editTextOutput.setKeyListener(null);

        // Spinners block initialization
        spinnerFrom = binding.unitsConversionSpinnerFrom;
        spinnerTo = binding.unitsConversionSpinnerTo;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.spinner_item, spinnerItems);
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
                .putInt(key1, spinnerFrom.getSelectedItemPosition())
                .putInt(key2, spinnerTo.getSelectedItemPosition())
                .apply();
        super.onPause();
    }

    private UnitsConversionFragmentArgs getSafeArgs() {
        return UnitsConversionFragmentArgs.fromBundle(requireArguments());
    }

    private void initUsingSafeArgs(UnitsConversionFragmentArgs args) {
        initToolbar(args.getToolbarImageId());

        key1 = args.getKey1();
        key2 = args.getKey2();
        spinnerItems = args.getSpinnerItemsArray();
    }

    private void initWidgets() {
        editTextInput = binding.inputConverter;
        editTextOutput = binding.outputConverter;
    }

    private void initToolbar(int icon) {
        Toolbar toolbar = (Toolbar) binding.toolbarFragmentUnitsConversion;

        NavController navController = Navigation.findNavController(toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        ImageView toolbarImage = toolbar.findViewById(R.id.image_app_toolbar);
        toolbarImage.setImageResource(icon);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    public void onClickDigitButtons(View v) {
        Button btn = (Button) v;
        editTextInput.setText(editTextInput.getText().append(btn.getText()));
        checkAmountOfDigits();
        convert();
    }

    public void onClickFunctionButtons(View v) {
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
            case R.id.button_sign:
                setMinusSign();
                checkDigits();
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
        button.setOnClickListener( view -> copy());
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

    private void setMinusSign() {
        String text = editTextInput.getText().toString();
        if (text.contains("-")) {
            editTextInput.setText(editTextInput.getText().delete(0, 1));
        } else {
            editTextInput.setText(editTextInput.getText().insert(0, "-"));
        }
    }

    private void checkDigits() {
        String inputText = editTextInput.getText().toString();
        //Pattern regEx = Pattern.compile("^-|\\.|-\\.$");
        Matcher matcher = Pattern.compile(getResources().getString(R.string.digits_regexp)).matcher(inputText);
        if (matcher.matches() || inputText.isEmpty()) {
            editTextOutput.getText().clear();
        } else {
            convert();
        }
    }

    private void checkAmountOfDigits() {
        String textInput = editTextInput.getText().toString();
        if (textInput.length() > 30) {
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
        String pasteData = "";
        try {
            if (clipboard.hasPrimaryClip()) {
                if (Objects.requireNonNull(clipboard.getPrimaryClipDescription()).hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    ClipData.Item item = Objects.requireNonNull(clipboard.getPrimaryClip()).getItemAt(0);
                    pasteData = item.getText().toString();
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
        final String spinnerItemFrom = spinnerFrom.getSelectedItem().toString();
        final String spinnerItemTo = spinnerTo.getSelectedItem().toString();
        final double inputValue = Double.parseDouble(editTextInput.getText().toString());
        final double outputValue = UnitsConverter.convert(inputValue, spinnerItemFrom, spinnerItemTo, key1);
        editTextOutput.setText(String.valueOf(outputValue));
    }
}