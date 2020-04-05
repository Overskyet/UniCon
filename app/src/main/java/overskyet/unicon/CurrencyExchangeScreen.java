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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import overskyet.unicon.exchangerates.CurrencyConverter;

public class CurrencyExchangeScreen extends AppCompatActivity {

    private static final String TAG = CurrencyExchangeScreen.class.getSimpleName();

    private CurrencyConverter mCurrencyConverter;

    private String mKey1, mKey2;

    // Instance of SharedPreferences object for setting up spinners items
    private SharedPreferences mSpinnersSettings;

    // Clipboard manager for copy and paste operations
    private ClipboardManager mClipboard;

    // Widgets
    private LinearLayout mUpdateTimeBlock;
    private ScrollView mScrollView;
    private TextView mUpdateTime;
    private EditText mEditTextInput, mEditTextOutput;
    private Spinner mSpinnerFrom, mSpinnerTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange_screen);

        // Action bar initialization
        initToolbar(getIntent().getExtras().getInt("intExtra", 0));

        // Keys and spinners items array initialization
        mKey1 = getIntent().getExtras().getString("stringExtra1");
        mKey2 = getIntent().getExtras().getString("stringExtra2");
        String[] spinnerItems = getIntent().getExtras().getStringArray("stringArrayExtra");

        // Init CurrencyConverter object
        mCurrencyConverter = new CurrencyConverter();

        // Clipboard manager initialization
        mClipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        // SharedPreferences instance initialization
        mSpinnersSettings = this.getPreferences(Context.MODE_PRIVATE);

        // Widget initialization
        mUpdateTimeBlock = findViewById(R.id.currency_exchange_time_of_update_block);
        mScrollView = findViewById(R.id.currency_exchange_scroll_view);
        mUpdateTime = findViewById(R.id.currency_exchange_update_time_text_view);
        mEditTextInput = findViewById(R.id.currency_exchange_input);
        mEditTextOutput = findViewById(R.id.currency_exchange_output);

        // Invoke SharedPreferences method to get last update time and write it to updateTime TextView
        getLastUpdateTime();

        // Disable input option for EditText views
        mEditTextInput.setKeyListener(null);
        mEditTextOutput.setKeyListener(null);

        // Spinners block initialization
        mSpinnerFrom = findViewById(R.id.currency_exchange_spinnerFrom);
        mSpinnerTo = findViewById(R.id.currency_exchange_spinnerTo);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, getResources().getStringArray(R.array.currencies));
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

        // Show keyboard button initialization and listener with anonymous method
        final ImageButton showKeyboardButton = findViewById(R.id.currency_exchange_image_button_show_keyboard);
        showKeyboardButton.setOnClickListener(v -> showKeyboard());
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
        Toolbar toolbar = findViewById(R.id.currency_exchange_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setNavigationOnClickListener(v -> finish());
        ImageView toolbarImage = findViewById(R.id.currency_exchange_toolbar_image);
        toolbarImage.setImageResource(icon);
    }

    private void getLastUpdateTime() {
        SharedPreferences preferences = this.getSharedPreferences(HomeScreen.KEY_EXCHANGE_RATES_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        if (preferences != null) {
            String time = preferences.getString(HomeScreen.KEY_ECB_TIME_OF_UPDATE, "No data available");
            mUpdateTime.setText(time);
        }
    }

    private void showKeyboard() {
        mUpdateTimeBlock.setVisibility(View.GONE);
        mUpdateTime.setVisibility(View.GONE);
        mScrollView.setVisibility(View.VISIBLE);
    }

    public void onClickDigitButtons(View v) {
        Button btn = (Button) v;
        mEditTextInput.setText(mEditTextInput.getText().append(btn.getText()));
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
        //Matcher matcher = Pattern.compile("^-|\\.|-\\.$").matcher(inputText);
        Matcher matcher = Pattern.compile(getResources().getString(R.string.digits_regexp)).matcher(inputText);
        if (matcher.matches() || inputText.isEmpty()) {
            mEditTextOutput.getText().clear();
        } else {
            startConvert();
        }
    }

    private void checkAmountOfDigits() {
        String textInput = mEditTextInput.getText().toString();
        //Matcher matcher = Pattern.compile("^[0-9\\-.]{0,30}(\\.\\d{3})$").matcher(textInput);
        Matcher matcher = Pattern.compile(getResources().getString(R.string.max_amount_of_chars_regexp)).matcher(textInput);
        if (textInput.length() > 30 || matcher.matches()) {
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
        try {
            if (mClipboard.hasPrimaryClip()) {
                if (mClipboard.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    ClipData.Item item = mClipboard.getPrimaryClip().getItemAt(0);
                    String pasteData = item.getText().toString();
                    mEditTextInput.setText(pasteData);
                    checkAmountOfDigitsForPasteValue();
                    startConvert();
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

    private void startConvert() {
        String spinnerItemFrom = mSpinnerFrom.getSelectedItem().toString().substring(0, 3);
        String spinnerItemTo = mSpinnerTo.getSelectedItem().toString().substring(0, 3);
        BigDecimal amount = new BigDecimal(mEditTextInput.getText().toString());
        // Use values from spinners and input field
        BigDecimal bigDecimalOutput = mCurrencyConverter.convert(spinnerItemFrom, spinnerItemTo, amount);
        // Init output field
        String output = bigDecimalOutput == null ? "0.0" : bigDecimalOutput.toString();
        mEditTextOutput.setText(output);
    }
}
