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

public class ConversionActivity extends AppCompatActivity {

    private static final String SPINNER_1_PREFERENCE_KEY = "overskyet.unicon.spinner1SelectedItem",
            SPINNER_2_PREFERENCE_KEY = "overskyet.unicon.spinner2SelectedItem",
            FIRST_LAUNCH = "overskyet.unicon.FIRST_LAUNCH_CHECK";

    private SharedPreferences mySettingsForSpinners;
    private SharedPreferences firstLaunch;
    private ClipboardManager clipboard;

    // Widgets
    private EditText editTextInput, editTextOutput;
    private Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        this.setTitle("");

        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        firstLaunch = this.getPreferences(Context.MODE_PRIVATE);
        mySettingsForSpinners = this.getPreferences(Context.MODE_PRIVATE);

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.angle_block,R.layout.spinner_item);
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

        editTextInput = findViewById(R.id.input_converter);
        editTextOutput = findViewById(R.id.output_converter);

        // disable input for EditText view
        editTextInput.setKeyListener(null);
        editTextOutput.setKeyListener(null);

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

        if (firstLaunch.getBoolean(FIRST_LAUNCH, true)) {

            spinner.setSelection(0);
            spinner2.setSelection(1);

            firstLaunch.edit().putBoolean(FIRST_LAUNCH, false).apply();

        } else {

            spinner.setSelection(mySettingsForSpinners.getInt(SPINNER_1_PREFERENCE_KEY, 0));
            spinner2.setSelection(mySettingsForSpinners.getInt(SPINNER_2_PREFERENCE_KEY, 1));

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
        checkAmountOfDigits();
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

        double inputValue = Double.valueOf(editTextInput.getText().toString());
        String spinnerItemName = spinner.getSelectedItem().toString();
        String spinner2ItemName = spinner2.getSelectedItem().toString();

        double output = AngleMethods.convert(inputValue, spinnerItemName, spinner2ItemName);
        editTextOutput.setText(String.valueOf(output));

    }

}