package overskyet.unicon;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class CurrencyExchangeScreen extends AppCompatActivity {

    String key1, key2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange_screen);

        initActionBar(getIntent().getExtras().getInt("intExtra", 0));
    }

    private void initActionBar(int icon) {
        Toolbar toolbar = findViewById(R.id.currency_exchange_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (icon != 0) {
                actionBar.setIcon(icon);
                actionBar.setTitle("");
                return;
            }
            actionBar.setTitle(getIntent().getExtras().getString("stringExtra3"));
        }
    }
}
