package overskyet.unicon.ui.fragments;


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

import overskyet.unicon.ui.HomeScreenActivity;
import overskyet.unicon.R;
import overskyet.unicon.databinding.FragmentHomeScreenBinding;

public class HomeScreenFragment extends Fragment
{

    private FragmentHomeScreenBinding binding;

    private Bundle bundle;

    public HomeScreenFragment() { }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState)
    {
        binding = FragmentHomeScreenBinding.inflate(
                inflater,
                container,
                false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(
            @NonNull View v,
            @Nullable Bundle savedInstanceState)
    {
        binding.setHomeScreen(this);

        initToolbar();
    }

    private void initToolbar()
    {
        Toolbar toolbar = (Toolbar) binding.toolbarFragmentHomeScreen;

        NavController navController = Navigation.findNavController(toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph())
                .build();

        toolbar.inflateMenu(R.menu.home_screen_toolbar_menu);
        toolbar.setLogo(R.drawable.ic_home_screen_toolbar_icon);
        toolbar.setOnMenuItemClickListener(item ->
                NavigationUI.onNavDestinationSelected(
                        item,
                        Navigation.findNavController(requireView()))
                        || super.onOptionsItemSelected(item));

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    public void onPressButton(View view) {
        switch (view.getId()) {
            case R.id.button_currency:
                bundle = initBundle(
                        null,
                        HomeScreenActivity.KEY_1_CURRENCY_CONVERSION,
                        HomeScreenActivity.KEY_2_CURRENCY_CONVERSION,
                        R.drawable.ic_currency_white);
                navigateToCurrencyExchangeFragment(view);
                break;
            case R.id.button_time:
                bundle = initBundle(
                        getResources().getStringArray(R.array.time_block),
                        HomeScreenActivity.KEY_1_TIME_CONVERSION,
                        HomeScreenActivity.KEY_2_TIME_CONVERSION,
                        R.drawable.ic_time_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_fuel_consumption:
                bundle = initBundle(
                        getResources().getStringArray(R.array.fuel_consumption_block),
                        HomeScreenActivity.KEY_1_FUEL_CONSUMPTION_CONVERSION,
                        HomeScreenActivity.KEY_2_FUEL_CONSUMPTION_CONVERSION,
                        R.drawable.ic_fuel_consumption_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_pressure:
                bundle = initBundle(
                        getResources().getStringArray(R.array.pressure_block),
                        HomeScreenActivity.KEY_1_PRESSURE_CONVERSION,
                        HomeScreenActivity.KEY_2_PRESSURE_CONVERSION,
                        R.drawable.ic_pressure_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_energy:
                bundle = initBundle(
                        getResources().getStringArray(R.array.energy_block),
                        HomeScreenActivity.KEY_1_ENERGY_CONVERSION,
                        HomeScreenActivity.KEY_2_ENERGY_CONVERSION,
                        R.drawable.ic_energy_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_temperature:
                bundle = initBundle(
                        getResources().getStringArray(R.array.temperature_block),
                        HomeScreenActivity.KEY_1_TEMPERATURE_CONVERSION,
                        HomeScreenActivity.KEY_2_TEMPERATURE_CONVERSION,
                        R.drawable.ic_temperature_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_length:
                bundle = initBundle(
                        getResources().getStringArray(R.array.length_block),
                        HomeScreenActivity.KEY_1_LENGTH_CONVERSION,
                        HomeScreenActivity.KEY_2_LENGTH_CONVERSION,
                        R.drawable.ic_length_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_weight:
                bundle = initBundle(
                        getResources().getStringArray(R.array.weight_block),
                        HomeScreenActivity.KEY_1_WEIGHT_CONVERSION,
                        HomeScreenActivity.KEY_2_WEIGHT_CONVERSION,
                        R.drawable.ic_weight_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_volume:
                bundle = initBundle(
                        getResources().getStringArray(R.array.volume_block),
                        HomeScreenActivity.KEY_1_VOLUME_CONVERSION,
                        HomeScreenActivity.KEY_2_VOLUME_CONVERSION,
                        R.drawable.ic_volume_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_area:
                bundle = initBundle(
                        getResources().getStringArray(R.array.area_block),
                        HomeScreenActivity.KEY_1_AREA_CONVERSION,
                        HomeScreenActivity.KEY_2_AREA_CONVERSION,
                        R.drawable.ic_area_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_angle:
                bundle = initBundle(
                        getResources().getStringArray(R.array.angle_block),
                        HomeScreenActivity.KEY_1_ANGLE_CONVERSION,
                        HomeScreenActivity.KEY_2_ANGLE_CONVERSION,
                        R.drawable.ic_angle_white);
                navigateToUnitsConversionFragment(view);
                break;
            case R.id.button_speed:
                bundle = initBundle(
                        getResources().getStringArray(R.array.speed_block),
                        HomeScreenActivity.KEY_1_SPEED_CONVERSION,
                        HomeScreenActivity.KEY_2_SPEED_CONVERSION,
                        R.drawable.ic_speed_white);
                navigateToUnitsConversionFragment(view);
                break;
            default:
                break;
        }
    }

    private void navigateToUnitsConversionFragment(View view) {
        Navigation.findNavController(view).navigate(
                R.id.action_homeScreenFragment_to_unitsConversionFragment,
                bundle);
    }

    private void navigateToCurrencyExchangeFragment(View view) {
        Navigation.findNavController(view).navigate(
                R.id.action_homeScreenFragment_to_currencyExchangeFragment,
                bundle);
    }

    private Bundle initBundle(
            @Nullable String[] spinnerItems,
            String key1, String key2,
            int toolbarImage) {
        Bundle bundle = new Bundle();
        bundle.putInt("toolbarImage", toolbarImage);
        bundle.putString("key1", key1);
        bundle.putString("key2", key2);
        bundle.putStringArray("spinnerItemsArray", spinnerItems);
        return bundle;
    }
}
