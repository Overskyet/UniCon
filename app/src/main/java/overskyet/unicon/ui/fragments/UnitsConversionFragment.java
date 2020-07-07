package overskyet.unicon.ui.fragments;

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

import overskyet.unicon.unitsconversion.CalculationMethods;
import overskyet.unicon.R;
import overskyet.unicon.databinding.FragmentUnitsConversionBinding;

public class UnitsConversionFragment extends Fragment {

    // Data Binding variable
    private FragmentUnitsConversionBinding binding;

    // Key values for saving preferences and conversion() method
    private String key1, key2;

    // Instance of SharedPreferences object for setting up spinners items
    private SharedPreferences spinnersPosition;

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

        // Getting arguments from bundle
        UnitsConversionFragmentArgs args = UnitsConversionFragmentArgs.fromBundle(requireArguments());

        // Initialize fragment toolbar
        initToolbar(args.getToolbarImageId());

        // Keys and spinner items array initialization
        key1 = args.getKey1();
        key2 = args.getKey2();
        String[] spinnerItems = args.getSpinnerItemsArray();

        // Clipboard manager initialization
        clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        // SharedPreferences instance initialization
        spinnersPosition = requireActivity().getPreferences(Context.MODE_PRIVATE);

        // Widget initialization
        editTextInput = binding.inputConverter;
        editTextOutput = binding.outputConverter;

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

        final Button copyButton = binding.buttonCopy;
        copyButton.setOnClickListener(view -> copy());
        copyButton.setOnLongClickListener(view -> {
            paste();
            return true;
        });
    }

    @Override
    public void onResume() {
        spinnerFrom.setSelection(spinnersPosition.getInt(key1, 0));
        spinnerTo.setSelection(spinnersPosition.getInt(key2, 1));
        super.onResume();
    }

    @Override
    public void onPause() {
        spinnersPosition.edit()
                .remove(key1)
                .remove(key2)
                .putInt(key1, spinnerFrom.getSelectedItemPosition())
                .putInt(key2, spinnerTo.getSelectedItemPosition())
                .apply();
        super.onPause();
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
        conversion();
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
            // Sign block
            case R.id.button_sign:
                setMinusSign();
                checkDigits();
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
            conversion();
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
                    conversion();
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

    private void conversion() {
        String spinnerItemFrom = spinnerFrom.getSelectedItem().toString();
        String spinnerItemTo = spinnerTo.getSelectedItem().toString();
        double inputValue = Double.parseDouble(editTextInput.getText().toString());
        double outputValue = CalculationMethods.convert(inputValue, spinnerItemFrom, spinnerItemTo, key1);
        editTextOutput.setText(String.valueOf(outputValue));
    }
}