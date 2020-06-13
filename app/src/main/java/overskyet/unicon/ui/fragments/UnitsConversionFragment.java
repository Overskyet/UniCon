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
    private FragmentUnitsConversionBinding mBinding;

    private static final String TAG = UnitsConversionFragment.class.getSimpleName();

    // Key values for saving preferences and conversion() method
    private String mKey1, mKey2;

    // Instance of SharedPreferences object for setting up spinners items
    private SharedPreferences mSpinnersSettings;

    // Clipboard manager for copy and paste operations
    private ClipboardManager mClipboard;

    // Widgets
    private EditText mEditTextInput, mEditTextOutput;
    private Spinner mSpinnerFrom, mSpinnerTo;

    public UnitsConversionFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentUnitsConversionBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {

        mBinding.setUnitsConversion(this);

        // Initialize toolbar for the fragment
        initToolbar(getArguments().getInt("toolbarImage", R.drawable.ic_home_screen_toolbar_icon));

        // Keys and spinners items array initialization
        mKey1 = getArguments().getString("key1");
        mKey2 = getArguments().getString("key2");
        String[] spinnerItems = getArguments().getStringArray("spinnerItemsArray");

        // Clipboard manager initialization
        mClipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        // SharedPreferences instance initialization
        mSpinnersSettings = requireActivity().getPreferences(Context.MODE_PRIVATE);

        // Widget initialization
        mEditTextInput = mBinding.inputConverter;
        mEditTextOutput = mBinding.outputConverter;

        // Disable input option for EditText views
        mEditTextInput.setKeyListener(null);
        mEditTextOutput.setKeyListener(null);

        // Spinners block initialization
        mSpinnerFrom = mBinding.unitsConversionSpinnerFrom;
        mSpinnerTo = mBinding.unitsConversionSpinnerTo;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), R.layout.spinner_item, spinnerItems);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        mSpinnerFrom.setAdapter(adapter);
        mSpinnerTo.setAdapter(adapter);

        // Spinners listeners
        mSpinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkDigits();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mSpinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkDigits();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Copy button initialization and listeners
        final Button copyButton = mBinding.buttonCopy;
        copyButton.setOnClickListener(view -> copy());
        copyButton.setOnLongClickListener(view -> {
            paste();
            return true;
        });
    }

    @Override
    public void onResume() {
        mSpinnerFrom.setSelection(mSpinnersSettings.getInt(mKey1, 0));
        mSpinnerTo.setSelection(mSpinnersSettings.getInt(mKey2, 1));
        super.onResume();
    }

    @Override
    public void onPause() {
        mSpinnersSettings.edit()
                .remove(mKey1)
                .remove(mKey2)
                .putInt(mKey1, mSpinnerFrom.getSelectedItemPosition())
                .putInt(mKey2, mSpinnerTo.getSelectedItemPosition())
                .apply();
        super.onPause();
    }

    private void initToolbar(int icon) {
        Toolbar toolbar = (Toolbar) mBinding.toolbarFragmentUnitsConversion;

        NavController navController = Navigation.findNavController(toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        ImageView toolbarImage = toolbar.findViewById(R.id.image_app_toolbar);
        toolbarImage.setImageResource(icon);

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    public void onClickDigitButtons(View v) {
        Button btn = (Button) v;
        mEditTextInput.setText(mEditTextInput.getText().append(btn.getText()));
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
                mEditTextInput.getText().clear();
                mEditTextOutput.getText().clear();
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
        String text = mEditTextInput.getText().toString();
        if (text.contains(".")) {
            mEditTextInput.setText(mEditTextInput.getText());
        } else {
            mEditTextInput.setText(mEditTextInput.getText().append('.'));
        }
    }

    private void checkEmptyInputField() {
        String text = mEditTextInput.getText().toString();
        if (text.isEmpty()) {
            mEditTextInput.setText(mEditTextInput.getText());
        } else {
            mEditTextInput.setText(text.substring(0, text.length() - 1));
        }
    }

    private void setMinusSign() {
        String text = mEditTextInput.getText().toString();
        if (text.contains("-")) {
            mEditTextInput.setText(mEditTextInput.getText().delete(0, 1));
        } else {
            mEditTextInput.setText(mEditTextInput.getText().insert(0, "-"));
        }
    }

    private void checkDigits() {
        String inputText = mEditTextInput.getText().toString();
        //Pattern regEx = Pattern.compile("^-|\\.|-\\.$");
        Matcher matcher = Pattern.compile(getResources().getString(R.string.digits_regexp)).matcher(inputText);
        if (matcher.matches() || inputText.isEmpty()) {
            mEditTextOutput.getText().clear();
        } else {
            conversion();
        }
    }

    private void checkAmountOfDigits() {
        String textInput = mEditTextInput.getText().toString();
        if (textInput.length() > 30) {
            mEditTextInput.setText(textInput.substring(0, textInput.length() - 1));
        }
    }

    private void checkAmountOfDigitsForPasteValue() {
        String textInput = mEditTextInput.getText().toString();
        if (textInput.length() > 30) {
            String str = getResources().getString(R.string.max_length_of_pasted_value_exceeded_notification);
            mEditTextInput.setText(textInput.substring(0, 30));
            showInfoText(str);
        }
    }

    private void copy() {
        ClipData clip = ClipData.newPlainText("Output", mEditTextOutput.getText());
        mClipboard.setPrimaryClip(clip);
        String str = getResources().getString(R.string.copy_notification);
        showInfoText(str);
    }

    private void paste() {
        String pasteData = "";
        try {
            if (mClipboard.hasPrimaryClip()) {
                if (Objects.requireNonNull(mClipboard.getPrimaryClipDescription()).hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    ClipData.Item item = Objects.requireNonNull(mClipboard.getPrimaryClip()).getItemAt(0);
                    pasteData = item.getText().toString();
                    mEditTextInput.setText(pasteData);
                    checkAmountOfDigitsForPasteValue();
                    conversion();
                }
            }
        } catch (NumberFormatException e) {
            String str = getResources().getString(R.string.incorrect_paste_value_notification);
            showInfoText(str);
            mEditTextInput.getText().clear();
            mEditTextOutput.getText().clear();
        }
    }

    private void reverse() {
        int selectedFrom = mSpinnerFrom.getSelectedItemPosition();
        int selectedTo = mSpinnerTo.getSelectedItemPosition();
        mSpinnerFrom.setSelection(selectedTo);
        mSpinnerTo.setSelection(selectedFrom);
    }

    private void showInfoText(String infoMsg) {
        Toast.makeText(requireActivity(), infoMsg, Toast.LENGTH_LONG).show();
    }

    private void conversion() {
        String spinnerItemFrom = mSpinnerFrom.getSelectedItem().toString();
        String spinnerItemTo = mSpinnerTo.getSelectedItem().toString();
        double inputValue = Double.parseDouble(mEditTextInput.getText().toString());
        double outputValue = CalculationMethods.convert(inputValue, spinnerItemFrom, spinnerItemTo, mKey1);
        mEditTextOutput.setText(String.valueOf(outputValue));
    }
}