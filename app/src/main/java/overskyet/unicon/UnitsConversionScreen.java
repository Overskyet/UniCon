package overskyet.unicon;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitsConversionScreen extends AppCompatActivity {

    // Key values for saving preferences and conversion() method
    private String key1, key2;

    // Instance of SharedPreferences object for setting up spinner items
    private SharedPreferences mySettingsForSpinners;

    // Clipboard manager for copy and paste operations
    private ClipboardManager clipboard;

    // Widgets
    private EditText editTextInput, editTextOutput;
    private Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units_conversion_screen);

        // Keys and spinner items array initialization
        key1 = getIntent().getExtras().getString("stringExtra1");
        key2 = getIntent().getExtras().getString("stringExtra2");
        String[] spinnerItems = getIntent().getExtras().getStringArray("stringArrayExtra");

        // Set the title of activity
        this.setTitle(getIntent().getExtras().getString("stringExtra3"));

        // Clipboard manager initialization
        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // SharedPreferences instance initialization
        mySettingsForSpinners = this.getPreferences(Context.MODE_PRIVATE);

        // Widget initialization
        editTextInput = findViewById(R.id.input_converter);
        editTextOutput = findViewById(R.id.output_converter);

        // Disable input option for EditText views
        editTextInput.setKeyListener(null);
        editTextOutput.setKeyListener(null);

        // Spinners block initialization
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, spinnerItems);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        // Spinners listeners
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                checkDigits();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copy();
            }
        });
        copyButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                paste();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        spinner.setSelection(mySettingsForSpinners.getInt(key1, 0));
        spinner2.setSelection(mySettingsForSpinners.getInt(key2, 1));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mySettingsForSpinners.edit();
        editor.putInt(key1, spinner.getSelectedItemPosition());
        editor.putInt(key2, spinner2.getSelectedItemPosition());
        editor.apply();
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
        Pattern regEx = Pattern.compile("^-|\\.|-\\.$");
        Matcher match = regEx.matcher(inputText);

        if (match.matches() || inputText.isEmpty()) {
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
        String pasteData;
        try {
            if (clipboard.hasPrimaryClip()) {
                if (clipboard.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
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
        }
    }

    private void reverse() {
        int temp;
        int selected = spinner.getSelectedItemPosition();
        int selected2 = spinner2.getSelectedItemPosition();
        temp = selected;
        selected = selected2;
        selected2 = temp;
        spinner.setSelection(selected);
        spinner2.setSelection(selected2);
    }

    private void showInfoText(String infoMsg) {
        Toast.makeText(getApplicationContext(), infoMsg, Toast.LENGTH_LONG).show();
    }

    private void conversion() {
        String spinnerItemName = spinner.getSelectedItem().toString();
        String spinner2ItemName = spinner2.getSelectedItem().toString();
        double inputValue = Double.valueOf(editTextInput.getText().toString());
        double outputValue = 0.0;
        switch (key1) {
            case "overskyet.unicon.TIME_SPINNER_1":
                outputValue = TimeUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.FUEL_CONSUMPTION_SPINNER_1":
                outputValue = FuelConsumptionUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.PRESSURE_SPINNER_1":
                outputValue = PressureUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.ENERGY_SPINNER_1":
                outputValue = EnergyUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.TEMPERATURE_SPINNER_1":
                outputValue = TemperatureUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.LENGTH_SPINNER_1":
                outputValue = LengthUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.WEIGHT_SPINNER_1":
                outputValue = WeightUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.VOLUME_SPINNER_1":
                outputValue = VolumeUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.AREA_SPINNER_1":
                outputValue = AreaUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.ANGLE_SPINNER_1":
                outputValue = AngleUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            case "overskyet.unicon.SPEED_SPINNER_1":
                outputValue = SpeedUnitsCalculation.convert(inputValue, spinnerItemName, spinner2ItemName);
                break;
            default:
                break;
        }
        editTextOutput.setText(String.valueOf(outputValue));
    }
}