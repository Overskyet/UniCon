package overskyet.unicon;

import android.content.ClipData;
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

public class WeightActivity extends AppCompatActivity {

    private static final String SPINNER_1_PREFERENCE_KEY = "overskyet.unicon.spinner1SelectedItem",
            SPINNER_2_PREFERENCE_KEY = "overskyet.unicon.spinner2SelectedItem",
            FIRST_LAUNCH = "overskyet.unicon.firstLaunchCheck";
    private SharedPreferences mySettingsForSpinners;
    private SharedPreferences firstLaunch;
    private EditText editTextInput, editTextOutput;
    Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        firstLaunch = this.getPreferences(Context.MODE_PRIVATE);
        mySettingsForSpinners = this.getPreferences(Context.MODE_PRIVATE);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weight_block,R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                digitsCheck();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                digitsCheck();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        editTextInput = (EditText) findViewById(R.id.input_converter);
        editTextOutput = (EditText) findViewById(R.id.output_converter);

        // disable input for EditText view
        editTextInput.setKeyListener(null);
        editTextOutput.setKeyListener(null);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (firstLaunch.getBoolean(FIRST_LAUNCH, true)) {

            spinner.setSelection(1);
            spinner2.setSelection(8);

            firstLaunch.edit().putBoolean(FIRST_LAUNCH, false).apply();

        } else {

            spinner.setSelection(mySettingsForSpinners.getInt(SPINNER_1_PREFERENCE_KEY, 1));
            spinner2.setSelection(mySettingsForSpinners.getInt(SPINNER_2_PREFERENCE_KEY, 8));

        }

    }

    @Override
    protected void onPause(){
        super.onPause();

        SharedPreferences.Editor editor = mySettingsForSpinners.edit();
        editor.putInt(SPINNER_1_PREFERENCE_KEY, spinner.getSelectedItemPosition());
        editor.putInt(SPINNER_2_PREFERENCE_KEY, spinner2.getSelectedItemPosition());
        editor.apply();
    }

    public void onClickDigitsBtn(View v) {

        Button btn = (Button) v;
        editTextInput.setText(editTextInput.getText().append(btn.getText()));
        digitsAmountCheck();
        conversion();

    }

    public void onClickFuncBtn(View v) {

        switch (v.getId()) {

            // Dot block
            case R.id.button_dot:
                dotCheck();
                break;

            // Delete and Clear block
            case R.id.button_delete:
                fieldIsEmptyCheck();
                digitsCheck();
                break;
            case R.id.button_clear:
                editTextInput.getText().clear();
                editTextOutput.getText().clear();
                break;

            // Sign block
            case R.id.button_sign:
                signCheck();
                digitsCheck();
                break;

            // Copy block
            case R.id.button_copy:
                copy();
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

    private void dotCheck() {

        String text = editTextInput.getText().toString();
        if (text.contains(".")) {
            editTextInput.setText(editTextInput.getText());
        } else {
            editTextInput.setText(editTextInput.getText().append('.'));
        }

    }

    private void fieldIsEmptyCheck() {

        String text = editTextInput.getText().toString();
        if (text.isEmpty()) {
            editTextInput.setText(editTextInput.getText());
        } else {
            editTextInput.setText(text.substring(0, text.length() - 1));
        }

    }

    private void signCheck() {

        String text = editTextInput.getText().toString();
        if (text.contains("-")) {
            editTextInput.setText(editTextInput.getText().delete(0, 1));
        } else {
            editTextInput.setText(editTextInput.getText().insert(0, "-"));
        }

    }

    private void digitsCheck() {

        String inputText = editTextInput.getText().toString();
        Pattern regEx = Pattern.compile("^-|\\.|-\\.$");
        Matcher match = regEx.matcher(inputText);

        if (match.matches() || inputText.isEmpty()) {
            editTextOutput.getText().clear();
        } else {
            conversion();
        }

    }

    private void digitsAmountCheck() {

        String textInput = editTextInput.getText().toString();

        if (textInput.length() > 30) {
            editTextInput.setText(textInput.substring(0, textInput.length() - 1));
        }

    }

    private void copy() {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Output", editTextOutput.getText());
        clipboard.setPrimaryClip(clip);

        CharSequence text = "Copied";
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

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

    private void conversion() {

        double inputValue = Double.valueOf(editTextInput.getText().toString());
        String spinnerItemName = spinner.getSelectedItem().toString();
        String spinner2ItemName = spinner2.getSelectedItem().toString();

        double output = WeightMethods.convert(inputValue, spinnerItemName, spinner2ItemName);
        editTextOutput.setText(String.valueOf(output));

    }

}
