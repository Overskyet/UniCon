package overskyet.unicon.ui.fragments.homescreen;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import overskyet.unicon.R;
import overskyet.unicon.databinding.FragmentHomeScreenBinding;
import overskyet.unicon.ui.HomeScreenActivity;

public class HomeScreenFragment extends Fragment
{

    private FragmentHomeScreenBinding binding;

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
                navigateToCurrencyExchangeFragment(
                        R.drawable.ic_currency_white,
                        HomeScreenActivity.KEY_1_CURRENCY_CONVERSION,
                        HomeScreenActivity.KEY_2_CURRENCY_CONVERSION,
                        null);
                break;
            case R.id.button_time:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_time_white,
                        HomeScreenActivity.KEY_1_TIME_CONVERSION,
                        HomeScreenActivity.KEY_2_TIME_CONVERSION,
                        getResources().getStringArray(R.array.time_block));
                break;
            case R.id.button_fuel_consumption:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_fuel_consumption_white,
                        HomeScreenActivity.KEY_1_FUEL_CONSUMPTION_CONVERSION,
                        HomeScreenActivity.KEY_2_FUEL_CONSUMPTION_CONVERSION,
                        getResources().getStringArray(R.array.fuel_consumption_block));
                break;
            case R.id.button_pressure:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_pressure_white,
                        HomeScreenActivity.KEY_1_PRESSURE_CONVERSION,
                        HomeScreenActivity.KEY_2_PRESSURE_CONVERSION,
                        getResources().getStringArray(R.array.pressure_block));
                break;
            case R.id.button_energy:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_energy_white,
                        HomeScreenActivity.KEY_1_ENERGY_CONVERSION,
                        HomeScreenActivity.KEY_2_ENERGY_CONVERSION,
                        getResources().getStringArray(R.array.energy_block));
                break;
            case R.id.button_temperature:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_temperature_white,
                        HomeScreenActivity.KEY_1_TEMPERATURE_CONVERSION,
                        HomeScreenActivity.KEY_2_TEMPERATURE_CONVERSION,
                        getResources().getStringArray(R.array.temperature_block));
                break;
            case R.id.button_length:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_length_white,
                        HomeScreenActivity.KEY_1_LENGTH_CONVERSION,
                        HomeScreenActivity.KEY_2_LENGTH_CONVERSION,
                        getResources().getStringArray(R.array.length_block));
                break;
            case R.id.button_weight:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_weight_white,
                        HomeScreenActivity.KEY_1_WEIGHT_CONVERSION,
                        HomeScreenActivity.KEY_2_WEIGHT_CONVERSION,
                        getResources().getStringArray(R.array.weight_block));
                break;
            case R.id.button_volume:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_volume_white,
                        HomeScreenActivity.KEY_1_VOLUME_CONVERSION,
                        HomeScreenActivity.KEY_2_VOLUME_CONVERSION,
                        getResources().getStringArray(R.array.volume_block));
                break;
            case R.id.button_area:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_area_white,
                        HomeScreenActivity.KEY_1_AREA_CONVERSION,
                        HomeScreenActivity.KEY_2_AREA_CONVERSION,
                        getResources().getStringArray(R.array.area_block));
                break;
            case R.id.button_angle:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_angle_white,
                        HomeScreenActivity.KEY_1_ANGLE_CONVERSION,
                        HomeScreenActivity.KEY_2_ANGLE_CONVERSION,
                        getResources().getStringArray(R.array.angle_block));
                break;
            case R.id.button_speed:
                navigateToUnitsConversionFragment(
                        R.drawable.ic_speed_white,
                        HomeScreenActivity.KEY_1_SPEED_CONVERSION,
                        HomeScreenActivity.KEY_2_SPEED_CONVERSION,
                        getResources().getStringArray(R.array.speed_block));
                break;
            default:
                break;
        }
    }

    private void navigateToUnitsConversionFragment(int toolbarImageId, String key1, String key2, String[] spinnerItemsArray) {
        Navigation.findNavController(binding.getRoot()).navigate(
                HomeScreenFragmentDirections.actionHomeScreenFragmentToUnitsConversionFragment(
                        toolbarImageId,
                        key1,
                        key2,
                        spinnerItemsArray));
    }

    private void navigateToCurrencyExchangeFragment(int toolbarImageId, String key1, String key2, String[] spinnerItemsArray) {
        Navigation.findNavController(binding.getRoot()).navigate(
                HomeScreenFragmentDirections.actionHomeScreenFragmentToCurrencyExchangeFragment(
                        toolbarImageId,
                        key1,
                        key2,
                        spinnerItemsArray));
    }
}
