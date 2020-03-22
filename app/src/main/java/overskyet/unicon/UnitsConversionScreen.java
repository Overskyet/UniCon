package overskyet.unicon;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitsConversionScreen extends AppCompatActivity {

    private static final String TAG = UnitsConversionScreen.class.getSimpleName();

    // Key values for saving preferences and conversion() method
    private String mKey1, mKey2;

    // Instance of SharedPreferences object for setting up spinners items
    private SharedPreferences mSpinnersSettings;

    // Clipboard manager for copy and paste operations
    private ClipboardManager mClipboard;

    // Widgets
    private EditText mEditTextInput, mEditTextOutput;
    private Spinner mSpinnerFrom, mSpinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units_conversion_screen);

        // Action bar initialization
        initToolbar(getIntent().getExtras().getInt("intExtra", 0));

        // Keys and spinners items array initialization
        mKey1 = getIntent().getExtras().getString("stringExtra1");
        mKey2 = getIntent().getExtras().getString("stringExtra2");
        String[] spinnerItems = getIntent().getExtras().getStringArray("stringArrayExtra");

        // Clipboard manager initialization
        mClipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // SharedPreferences instance initialization
        mSpinnersSettings = this.getPreferences(Context.MODE_PRIVATE);

        // Widget initialization
        mEditTextInput = findViewById(R.id.input_converter);
        mEditTextOutput = findViewById(R.id.output_converter);

        // Disable input option for EditText views
        mEditTextInput.setKeyListener(null);
        mEditTextOutput.setKeyListener(null);

        // Spinners block initialization
        mSpinnerFrom = findViewById(R.id.units_conversion_spinnerFrom);
        mSpinnerTo = findViewById(R.id.units_conversion_spinnerTo);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, spinnerItems);
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
        final Button copyButton = findViewById(R.id.button_copy);
        copyButton.setOnClickListener(v -> copy());
        copyButton.setOnLongClickListener(v -> {
            paste();
            return true;
        });
    }

    @Override
    protected void onResume() {
        mSpinnerFrom.setSelection(mSpinnersSettings.getInt(mKey1, 0));
        mSpinnerTo.setSelection(mSpinnersSettings.getInt(mKey2, 1));
        super.onResume();
    }

    @Override
    protected void onPause() {
        mSpinnersSettings.edit()
                .remove(mKey1)
                .remove(mKey2)
                .putInt(mKey1, mSpinnerFrom.getSelectedItemPosition())
                .putInt(mKey2, mSpinnerTo.getSelectedItemPosition())
                .apply();
        super.onPause();
    }

    private void initToolbar(int icon) {
        Toolbar toolbar = findViewById(R.id.units_conversion_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setNavigationOnClickListener(v -> finish());
        ImageView toolbarImage = findViewById(R.id.units_conversion_toolbar_image);
        toolbarImage.setImageResource(icon);
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
                if (mClipboard.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    ClipData.Item item = mClipboard.getPrimaryClip().getItemAt(0);
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
        Toast.makeText(getApplicationContext(), infoMsg, Toast.LENGTH_LONG).show();
    }

    private void conversion() {
        String spinnerItemFrom = mSpinnerFrom.getSelectedItem().toString();
        String spinnerItemTo = mSpinnerTo.getSelectedItem().toString();
        double inputValue = Double.parseDouble(mEditTextInput.getText().toString());
        double outputValue = CalculationMethods.convert(inputValue, spinnerItemFrom, spinnerItemTo, mKey1);
        mEditTextOutput.setText(String.valueOf(outputValue));
    }
}