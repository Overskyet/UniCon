package overskyet.unicon;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    MyPageAdapter pageAdapter;
    RedHomeScreenBlockFragment redBlockFragment;
    BlueHomeScreenBlockFragment blueBlockFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        redBlockFragment = new RedHomeScreenBlockFragment();
        blueBlockFragment = new BlueHomeScreenBlockFragment();

        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(pageAdapter);

    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(redBlockFragment);
        fragments.add(blueBlockFragment);
        return fragments;
    }

}
