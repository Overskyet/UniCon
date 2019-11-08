package overskyet.unicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class CurrencyExchangeScreen extends AppCompatActivity {

    String key1, key2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange_screen);

        initToolbar(getIntent().getExtras().getInt("intExtra", 0));
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
}
