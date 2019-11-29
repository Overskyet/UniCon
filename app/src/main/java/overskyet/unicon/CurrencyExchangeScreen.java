package overskyet.unicon;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import overskyet.unicon.exchangerates.CurrencyConverter;

public class CurrencyExchangeScreen extends AppCompatActivity {

    private static final String TAG = CurrencyExchangeScreen.class.getSimpleName();

    private CurrencyConverter currencyConverter;

    private String key1, key2;

    // Instance of SharedPreferences object for setting up spinnerFrom items
    private SharedPreferences mySettingsForSpinners;

    // Clipboard manager for copy and paste operations
    private ClipboardManager clipboard;

    // Widgets
    private EditText editTextInput, editTextOutput;
    private Spinner spinnerFrom, spinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange_screen);

        // Action bar initialization
        initToolbar(getIntent().getExtras().getInt("intExtra", 0));

        // Keys and spinnerFrom items array initialization
        key1 = getIntent().getExtras().getString("stringExtra1");
        key2 = getIntent().getExtras().getString("stringExtra2");
        String[] spinnerItems = getIntent().getExtras().getStringArray("stringArrayExtra");

        // Init CurrencyConverter object
        currencyConverter = new CurrencyConverter(CurrencyExchangeScreen.this);

        // Clipboard manager initialization
        clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // SharedPreferences instance initialization
        mySettingsForSpinners = this.getPreferences(Context.MODE_PRIVATE);

        // Widget initialization
        editTextInput = findViewById(R.id.currency_exchange_input);
        editTextOutput = findViewById(R.id.currency_exchange_output);

        // Disable input option for EditText views
        editTextInput.setKeyListener(null);
        editTextOutput.setKeyListener(null);

        // Spinners block initialization
        spinnerFrom = findViewById(R.id.currency_exchange_spinnerFrom);
        spinnerTo = findViewById(R.id.currency_exchange_spinnerTo);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, getCurrencies());
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
        spinnerFrom.setSelection(mySettingsForSpinners.getInt(key1, 0));
        spinnerTo.setSelection(mySettingsForSpinners.getInt(key2, 1));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mySettingsForSpinners.edit();
        editor.remove(key1).apply();
        editor.remove(key2).apply();
        editor.putInt(key1, spinnerFrom.getSelectedItemPosition());
        editor.putInt(key2, spinnerTo.getSelectedItemPosition());
        editor.apply();
    }

    private void initToolbar(int icon) {
        Toolbar toolbar = findViewById(R.id.currency_exchange_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageView toolbarImage = findViewById(R.id.currency_exchange_toolbar_image);
        toolbarImage.setImageResource(icon);
    }

    private List<String> getCurrencies() {
        List<String> currencies = new ArrayList<>();
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(HomeScreen.KEY_NAME_OF_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        if (preferences != null) {
            try {
                String jsonListString = preferences.getString(HomeScreen.KEY_LIST_OF_CURRENCIES, new JSONArray().toString());
                JSONArray jsonListArray = new JSONArray(jsonListString);
                if (!jsonListArray.isNull(0)) {
                    for (int i = 0; i < jsonListArray.length(); i++) {
                        currencies.add(jsonListArray.getString(i));
                    }
                }
            } catch (JSONException e) {
                Log.e(TAG, "getCurrencies: ", e);
            }
        }
        return currencies;
    }

    public void onClickDigitButtons(View v) {
        Button btn = (Button) v;
        editTextInput.setText(editTextInput.getText().append(btn.getText()));
        checkAmountOfDigits();
        startConvert();
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
            startConvert();
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
                    startConvert();
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
        int temp;
        int selected = spinnerFrom.getSelectedItemPosition();
        int selected2 = spinnerTo.getSelectedItemPosition();
        temp = selected;
        selected = selected2;
        selected2 = temp;
        spinnerFrom.setSelection(selected);
        spinnerTo.setSelection(selected2);
    }

    private void showInfoText(String infoMsg) {
        Toast.makeText(getApplicationContext(), infoMsg, Toast.LENGTH_LONG).show();
    }

    // TODO Handle output
    private void startConvert() {
        String spinnerItemNameFrom = spinnerFrom.getSelectedItem().toString();
        String spinnerItemNameTo = spinnerTo.getSelectedItem().toString();
        BigDecimal amount = new BigDecimal(editTextInput.getText().toString());
        // Use values from spinners and input field
        BigDecimal bigDecimalOutput = currencyConverter.convert(spinnerItemNameFrom, spinnerItemNameTo, amount);
        // Init output field
        String output = bigDecimalOutput.toString();
        editTextOutput.setText(output);
    }
}
