package overskyet.unicon.ui.fragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import overskyet.unicon.ui.HomeScreenActivity;
import overskyet.unicon.R;
import overskyet.unicon.databinding.FragmentHomeScreenBinding;
import overskyet.unicon.utils.Animation;

public class HomeScreenFragment extends Fragment {

    private FragmentHomeScreenBinding mBinding;

    private Bundle mBundle;

    private Toolbar mToolbar;

    public HomeScreenFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentHomeScreenBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        mBinding.setHomeScreen(this);

        initToolbar(v);
    }

    private void initToolbar(View view) {
        NavController navController = Navigation.findNavController(view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        mToolbar = (Toolbar) mBinding.toolbarFragmentHomeScreen;
        mToolbar.inflateMenu(R.menu.home_screen_toolbar_menu);
        mToolbar.setLogo(R.drawable.ic_home_screen_toolbar_icon);
        mToolbar.setOnMenuItemClickListener(item ->
                NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(requireView())) ||
                super.onOptionsItemSelected(item));

        NavigationUI.setupWithNavController(mToolbar, navController, appBarConfiguration);
    }

    public void onPressButton(View view) {
        switch (view.getId()) {
            case R.id.button_currency:
                @SuppressLint("ObjectAnimatorBinding")
                ObjectAnimator animWidth = ObjectAnimator.ofInt(view, "width", view.getWidth() + Animation.getScreenWidth());
                animWidth.addUpdateListener(animation -> {
                    view.getLayoutParams().width = (Integer) animation.getAnimatedValue();
                    view.requestLayout();
                });
                animWidth.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mBundle = initBundle(null,
                                HomeScreenActivity.KEY_1_CURRENCY_CONVERSION,
                                HomeScreenActivity.KEY_2_CURRENCY_CONVERSION,
                                R.drawable.ic_currency_white);
                        navigateToCurrencyExchangeFragment(view);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                animatorSet.play(animWidth);
                animatorSet.start();
                break;
            case R.id.button_time:
                mBundle = initBundle(getResources().getStringArray(R.array.time_block),
                        HomeScreenActivity.KEY_1_TIME_CONVERSION,
                        HomeScreenActivity.KEY_2_TIME_CONVERSION,
                        R.drawable.ic_time_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_fuel_consumption:
                mBundle = initBundle(getResources().getStringArray(R.array.fuel_consumption_block),
                        HomeScreenActivity.KEY_1_FUEL_CONSUMPTION_CONVERSION,
                        HomeScreenActivity.KEY_2_FUEL_CONSUMPTION_CONVERSION,
                        R.drawable.ic_fuel_consumption_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_pressure:
                mBundle = initBundle(getResources().getStringArray(R.array.pressure_block),
                        HomeScreenActivity.KEY_1_PRESSURE_CONVERSION,
                        HomeScreenActivity.KEY_2_PRESSURE_CONVERSION,
                        R.drawable.ic_pressure_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_energy:
                mBundle = initBundle(getResources().getStringArray(R.array.energy_block),
                        HomeScreenActivity.KEY_1_ENERGY_CONVERSION,
                        HomeScreenActivity.KEY_2_ENERGY_CONVERSION,
                        R.drawable.ic_energy_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_temperature:
                mBundle = initBundle(getResources().getStringArray(R.array.temperature_block),
                        HomeScreenActivity.KEY_1_TEMPERATURE_CONVERSION,
                        HomeScreenActivity.KEY_2_TEMPERATURE_CONVERSION,
                        R.drawable.ic_temperature_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_length:
                mBundle = initBundle(getResources().getStringArray(R.array.length_block),
                        HomeScreenActivity.KEY_1_LENGTH_CONVERSION,
                        HomeScreenActivity.KEY_2_LENGTH_CONVERSION,
                        R.drawable.ic_length_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_weight:
                mBundle = initBundle(getResources().getStringArray(R.array.weight_block),
                        HomeScreenActivity.KEY_1_WEIGHT_CONVERSION,
                        HomeScreenActivity.KEY_2_WEIGHT_CONVERSION,
                        R.drawable.ic_weight_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_volume:
                mBundle = initBundle(getResources().getStringArray(R.array.volume_block),
                        HomeScreenActivity.KEY_1_VOLUME_CONVERSION,
                        HomeScreenActivity.KEY_2_VOLUME_CONVERSION,
                        R.drawable.ic_volume_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_area:
                mBundle = initBundle(getResources().getStringArray(R.array.area_block),
                        HomeScreenActivity.KEY_1_AREA_CONVERSION,
                        HomeScreenActivity.KEY_2_AREA_CONVERSION,
                        R.drawable.ic_area_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_angle:
                mBundle = initBundle(getResources().getStringArray(R.array.angle_block),
                        HomeScreenActivity.KEY_1_ANGLE_CONVERSION,
                        HomeScreenActivity.KEY_2_ANGLE_CONVERSION,
                        R.drawable.ic_angle_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_speed:
                mBundle = initBundle(getResources().getStringArray(R.array.speed_block),
                        HomeScreenActivity.KEY_1_SPEED_CONVERSION,
                        HomeScreenActivity.KEY_2_SPEED_CONVERSION,
                        R.drawable.ic_speed_white);
                navigateToUnitsConversionFragment(view);
                break;
            default:
                break;
        }

        // TODO Make toolbar fade in and fade out
        mToolbar.getMenu().clear();
        mToolbar.setLogo(null);
    }

    private void navigateToUnitsConversionFragment(View view) {
        Navigation.findNavController(view).navigate(R.id.action_homeScreenFragment_to_unitsConversionFragment, mBundle);
    }

    private void navigateToCurrencyExchangeFragment(View view) {
        Navigation.findNavController(view).navigate(R.id.action_homeScreenFragment_to_currencyExchangeFragment, mBundle);
    }

    private Bundle initBundle(@Nullable String[] spinnerItems, String key1, String key2, int toolbarImage) {
        Bundle bundle = new Bundle();
        bundle.putInt("toolbarImage", toolbarImage);
        bundle.putString("key1", key1);
        bundle.putString("key2", key2);
        bundle.putStringArray("spinnerItemsArray", spinnerItems);
        return bundle;
    }
}
