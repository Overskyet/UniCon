package overskyet.unicon;

public final class CalculationMethods {

    private static double output;
    private static double input;
    private static String itemName1, itemName2;

    public static double convert(double inputValue, String spinnerItemName, String spinner2ItemName, String key1) {

        input = inputValue;
        itemName1 = spinnerItemName.toLowerCase();
        itemName2 = spinner2ItemName.toLowerCase();

        switch (key1) {
            case HomeScreenActivity.KEY_1_TIME_CONVERSION:
                calculateTime();
                break;
            case HomeScreenActivity.KEY_1_FUEL_CONSUMPTION_CONVERSION:
                calculateFuelConsumption();
                break;
            case HomeScreenActivity.KEY_1_PRESSURE_CONVERSION:
                calculatePressure();
                break;
            case HomeScreenActivity.KEY_1_ENERGY_CONVERSION:
                calculateEnergy();
                break;
            case HomeScreenActivity.KEY_1_TEMPERATURE_CONVERSION:
                calculateTemperature();
                break;
            case HomeScreenActivity.KEY_1_LENGTH_CONVERSION:
                calculateLength();
                break;
            case HomeScreenActivity.KEY_1_WEIGHT_CONVERSION:
                calculateWeight();
                break;
            case HomeScreenActivity.KEY_1_VOLUME_CONVERSION:
                calculateVolume();
                break;
            case HomeScreenActivity.KEY_1_AREA_CONVERSION:
                calculateArea();
                break;
            case HomeScreenActivity.KEY_1_ANGLE_CONVERSION:
                calculateAngle();
                break;
            case HomeScreenActivity.KEY_1_SPEED_CONVERSION:
                calculateSpeed();
                break;
            default: return 0.0;
        }
        return output;
    }

    private static void calculateAngle() {
        switch (itemName1) {
            case "gradian": {
                switch (itemName2) {
                    case "gradian":
                        output = input;
                        break;
                    case "degree":
                        output = input * 180 / 200;
                        break;
                    case "arcminute":
                        output = input * 54;
                        break;
                    case "radian":
                        output = input * Math.PI / 200;
                        break;
                    case "milliradian":
                        output = input * (1000 * Math.PI) / 200;
                        break;
                    case "arcsecond":
                        output = input * 3240;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "degree": {
                switch (itemName2) {
                    case "degree":
                        output = input;
                        break;
                    case "gradian":
                        output = input * 200 / 180;
                        break;
                    case "arcminute":
                        output = input * 60;
                        break;
                    case "radian":
                        output = input * Math.PI / 180;
                        break;
                    case "milliradian":
                        output = input * (1000 * Math.PI) / 180;
                        break;
                    case "arcsecond":
                        output = input * 3600;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "arcminute": {
                switch (itemName2) {
                    case "arcminute":
                        output = input;
                        break;
                    case "gradian":
                        output = input / 54;
                        break;
                    case "degree":
                        output = input / 60;
                        break;
                    case "radian":
                        output = input * Math.PI / (60 * 180);
                        break;
                    case "milliradian":
                        output = input * (1000 * Math.PI) / (60 * 180);
                        break;
                    case "arcsecond":
                        output = input * 60;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "radian": {
                switch (itemName2) {
                    case "radian":
                        output = input;
                        break;
                    case "gradian":
                        output = input * 200 / Math.PI;
                        break;
                    case "degree":
                        output = input * 180 / Math.PI;
                        break;
                    case "arcminute":
                        output = input * (60 * 180) / Math.PI;
                        break;
                    case "milliradian":
                        output = input * 1000;
                        break;
                    case "arcsecond":
                        output = input * (3600 * 180) / Math.PI;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "milliradian": {
                switch (itemName2) {
                    case "milliradian":
                        output = input;
                        break;
                    case "gradian":
                        output = input * 200 / (1000 * Math.PI);
                        break;
                    case "degree":
                        output = input * 180 / (1000 * Math.PI);
                        break;
                    case "arcminute":
                        output = input * (60 * 180) / (1000 * Math.PI);
                        break;
                    case "radian":
                        output = input / 1000;
                        break;
                    case "arcsecond":
                        output = input * (3600 * 180) / (1000 * Math.PI);
                        break;
                    default:
                        break;
                }
                break;
            }
            case "arcsecond": {
                switch (itemName2) {
                    case "arcsecond":
                        output = input;
                        break;
                    case "gradian":
                        output = input / 3240;
                        break;
                    case "degree":
                        output = input / 3600;
                        break;
                    case "arcminute":
                        output = input / 60;
                        break;
                    case "radian":
                        output = input * Math.PI / (180 * 3600);
                        break;
                    case "milliradian":
                        output = input * (1000 * Math.PI) / (180 * 3600);
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateArea() {
        switch (itemName1) {
            case "square kilometer": {
                switch (itemName2) {
                    case "square kilometer":
                        output = input;
                        break;
                    case "square meter":
                        output = input * 1e+6;
                        break;
                    case "square mile":
                        output = input / 2.59;
                        break;
                    case "square yard":
                        output = input * 1.196e+6;
                        break;
                    case "square foot":
                        output = input * 1.076e+7;
                        break;
                    case "square inch":
                        output = input * 1.55e+9;
                        break;
                    case "hectare":
                        output = input * 100;
                        break;
                    case "acre":
                        output = input * 247.105;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "square meter": {
                switch (itemName2) {
                    case "square meter":
                        output = input;
                        break;
                    case "square kilometer":
                        output = input / 1e+6;
                        break;
                    case "square mile":
                        output = input / 2.59e+6;
                        break;
                    case "square yard":
                        output = input * 1.196;
                        break;
                    case "square foot":
                        output = input * 10.764;
                        break;
                    case "square inch":
                        output = input * 1550.003;
                        break;
                    case "hectare":
                        output = input / 10000;
                        break;
                    case "acre":
                        output = input / 4046.856;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "square mile": {
                switch (itemName2) {
                    case "square mile":
                        output = input;
                        break;
                    case "square kilometer":
                        output = input * 2.59;
                        break;
                    case "square meter":
                        output = input * 2.59e+6;
                        break;
                    case "square yard":
                        output = input * 3.098e+6;
                        break;
                    case "square foot":
                        output = input * 2.788e+7;
                        break;
                    case "square inch":
                        output = input * 4.014e+9;
                        break;
                    case "hectare":
                        output = input * 258.999;
                        break;
                    case "acre":
                        output = input * 640;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "square yard": {
                switch (itemName2) {
                    case "square yard":
                        output = input;
                        break;
                    case "square kilometer":
                        output = input / 1.196e+6;
                        break;
                    case "square meter":
                        output = input / 1.196;
                        break;
                    case "square mile":
                        output = input / 3.098e+6;
                        break;
                    case "square foot":
                        output = input * 9;
                        break;
                    case "square inch":
                        output = input * 1296;
                        break;
                    case "hectare":
                        output = input / 11959.9;
                        break;
                    case "acre":
                        output = input / 4840;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "square foot": {
                switch (itemName2) {
                    case "square foot":
                        output = input;
                        break;
                    case "square kilometer":
                        output = input / 1.076e+7;
                        break;
                    case "square meter":
                        output = input / 10.764;
                        break;
                    case "square mile":
                        output = input / 2.788e+7;
                        break;
                    case "square yard":
                        output = input / 9;
                        break;
                    case "square inch":
                        output = input * 144;
                        break;
                    case "hectare":
                        output = input / 107639.104;
                        break;
                    case "acre":
                        output = input / 43560;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "square inch": {
                switch (itemName2) {
                    case "square inch":
                        output = input;
                        break;
                    case "square kilometer":
                        output = input / 1.55e+9;
                        break;
                    case "square meter":
                        output = input / 1550.003;
                        break;
                    case "square mile":
                        output = input / 4.014e+9;
                        break;
                    case "square yard":
                        output = input / 1296;
                        break;
                    case "square foot":
                        output = input / 144;
                        break;
                    case "hectare":
                        output = input / 1.55e+7;
                        break;
                    case "acre":
                        output = input / 6.273e+6;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "hectare": {
                switch (itemName2) {
                    case "hectare":
                        output = input;
                        break;
                    case "square kilometer":
                        output = input / 100;
                        break;
                    case "square meter":
                        output = input * 10000;
                        break;
                    case "square mile":
                        output = input / 258.999;
                        break;
                    case "square yard":
                        output = input * 11959.9;
                        break;
                    case "square foot":
                        output = input * 107639.104;
                        break;
                    case "square inch":
                        output = input * 1.55e+7;
                        break;
                    case "acre":
                        output = input * 2.471;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "acre": {
                switch (itemName2) {
                    case "acre":
                        output = input;
                        break;
                    case "square kilometer":
                        output = input / 247.105;
                        break;
                    case "square meter":
                        output = input * 4046.856;
                        break;
                    case "square mile":
                        output = input / 640;
                        break;
                    case "square yard":
                        output = input * 4840;
                        break;
                    case "square foot":
                        output = input * 43560;
                        break;
                    case "square inch":
                        output = input * 6.273e+6;
                        break;
                    case "hectare":
                        output = input / 2.471;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateEnergy() {
        switch (itemName1) {
            case "joule": {
                switch (itemName2) {
                    case "joule":
                        output = input;
                        break;
                    case "kilojoule":
                        output = input / 1000;
                        break;
                    case "calorie":
                        output = input / 4.184;
                        break;
                    case "kilocalorie":
                        output = input / 4184;
                        break;
                    case "watt hour":
                        output = input / 3600;
                        break;
                    case "kilowatt hour":
                        output = input / 3.6e+6;
                        break;
                    case "electron-volt":
                        output = input * 6.242e+18;
                        break;
                    case "british thermal unit":
                        output = input / 1055.056;
                        break;
                    case "therm":
                        output = input / 1.055e+8;
                        break;
                    case "foot pound":
                        output = input / 1.356;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "kilojoule": {
                switch (itemName2) {
                    case "kilojoule":
                        output = input;
                        break;
                    case "joule":
                        output = input * 1000;
                        break;
                    case "calorie":
                        output = input * 239.006;
                        break;
                    case "kilocalorie":
                        output = input / 4.184;
                        break;
                    case "watt hour":
                        output = input / 3.6;
                        break;
                    case "kilowatt hour":
                        output = input / 3600;
                        break;
                    case "electron-volt":
                        output = input * 6.242e+21;
                        break;
                    case "british thermal unit":
                        output = input / 1.055;
                        break;
                    case "therm":
                        output = input / 105480.4;
                        break;
                    case "foot pound":
                        output = input * 737.562;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "calorie": {
                switch (itemName2) {
                    case "calorie":
                        output = input;
                        break;
                    case "joule":
                        output = input * 4.184;
                        break;
                    case "kilojoule":
                        output = input / 239.006;
                        break;
                    case "kilocalorie":
                        output = input / 1000;
                        break;
                    case "watt hour":
                        output = input / 860.421;
                        break;
                    case "kilowatt hour":
                        output = input / 860420.65;
                        break;
                    case "electron-volt":
                        output = input * 2.611e+19;
                        break;
                    case "british thermal unit":
                        output = input / 252.164;
                        break;
                    case "therm":
                        output = input / 2.521e+7;
                        break;
                    case "foot pound":
                        output = input * 3.086;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "kilocalorie": {
                switch (itemName2) {
                    case "kilocalorie":
                        output = input;
                        break;
                    case "joule":
                        output = input * 4184;
                        break;
                    case "kilojoule":
                        output = input * 4.184;
                        break;
                    case "calorie":
                        output = input * 1000;
                        break;
                    case "watt hour":
                        output = input * 1.162;
                        break;
                    case "kilowatt hour":
                        output = input / 860.421;
                        break;
                    case "electron-volt":
                        output = input * 2.611e+22;
                        break;
                    case "british thermal unit":
                        output = input * 3.966;
                        break;
                    case "therm":
                        output = input / 25210.421;
                        break;
                    case "foot pound":
                        output = input * 3085.96;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "watt hour": {
                switch (itemName2) {
                    case "watt hour":
                        output = input;
                        break;
                    case "joule":
                        output = input * 3600;
                        break;
                    case "kilojoule":
                        output = input * 3.6;
                        break;
                    case "calorie":
                        output = input * 860.421;
                        break;
                    case "kilocalorie":
                        output = input / 1.162;
                        break;
                    case "kilowatt hour":
                        output = input / 1000;
                        break;
                    case "electron-volt":
                        output = input * 2.247e+22;
                        break;
                    case "british thermal unit":
                        output = input * 3.412;
                        break;
                    case "therm":
                        output = input / 29300.111;
                        break;
                    case "foot pound":
                        output = input * 2655.224;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "kilowatt hour": {
                switch (itemName2) {
                    case "kilowatt hour":
                        output = input;
                        break;
                    case "joule":
                        output = input * 3.6e+6;
                        break;
                    case "kilojoule":
                        output = input * 3600;
                        break;
                    case "calorie":
                        output = input * 860420.65;
                        break;
                    case "kilocalorie":
                        output = input * 860.421;
                        break;
                    case "watt hour":
                        output = input * 1000;
                        break;
                    case "electron-volt":
                        output = input * 2.247e+25;
                        break;
                    case "british thermal unit":
                        output = input * 3412.142;
                        break;
                    case "therm":
                        output = input / 29.3;
                        break;
                    case "foot pound":
                        output = input * 2.655e+6;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "electron-volt": {
                switch (itemName2) {
                    case "electron-volt":
                        output = input;
                        break;
                    case "joule":
                        output = input / 6.242e+18;
                        break;
                    case "kilojoule":
                        output = input / 6.242e+21;
                        break;
                    case "calorie":
                        output = input / 2.611e+19;
                        break;
                    case "kilocalorie":
                        output = input / 2.611e+22;
                        break;
                    case "watt hour":
                        output = input / 2.247e+22;
                        break;
                    case "kilowatt hour":
                        output = input / 2.247e+25;
                        break;
                    case "british thermal unit":
                        output = input / 6.585e+21;
                        break;
                    case "therm":
                        output = input / 6.584e+26;
                        break;
                    case "foot pound":
                        output = input / 8.462e+18;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "british thermal unit": {
                switch (itemName2) {
                    case "british thermal unit":
                        output = input;
                        break;
                    case "joule":
                        output = input * 1055.056;
                        break;
                    case "kilojoule":
                        output = input * 1.055;
                        break;
                    case "calorie":
                        output = input * 252.164;
                        break;
                    case "kilocalorie":
                        output = input / 3.966;
                        break;
                    case "watt hour":
                        output = input / 3.412;
                        break;
                    case "kilowatt hour":
                        output = input / 3412.142;
                        break;
                    case "electron-volt":
                        output = input * 6.585e+21;
                        break;
                    case "therm":
                        output = input / 99976.129;
                        break;
                    case "foot pound":
                        output = input * 778.169;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "therm": {
                switch (itemName2) {
                    case "therm":
                        output = input;
                        break;
                    case "joule":
                        output = input * 1.055e+8;
                        break;
                    case "kilojoule":
                        output = input * 105480.4;
                        break;
                    case "calorie":
                        output = input * 2.521e+7;
                        break;
                    case "kilocalorie":
                        output = input * 25210.421;
                        break;
                    case "watt hour":
                        output = input * 29300.111;
                        break;
                    case "kilowatt hour":
                        output = input * 29.3;
                        break;
                    case "electron-volt":
                        output = input * 6.584e+26;
                        break;
                    case "british thermal unit":
                        output = input * 99976.129;
                        break;
                    case "foot pound":
                        output = input * 7.78e+7;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "foot pound": {
                switch (itemName2) {
                    case "foot pound":
                        output = input;
                        break;
                    case "joule":
                        output = input * 1.356;
                        break;
                    case "kilojoule":
                        output = input / 737.562;
                        break;
                    case "calorie":
                        output = input / 3.086;
                        break;
                    case "kilocalorie":
                        output = input / 3085.96;
                        break;
                    case "watt hour":
                        output = input / 2655.224;
                        break;
                    case "kilowatt hour":
                        output = input / 2.655e+6;
                        break;
                    case "electron-volt":
                        output = input * 8.462e+18;
                        break;
                    case "british thermal unit":
                        output = input / 778.169;
                        break;
                    case "therm":
                        output = input / 7.78e+7;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateFuelConsumption() {
        switch (itemName1) {
            case "miles per gallon (us)": {
                switch (itemName2) {
                    case "miles per gallon (us)":
                        output = input;
                        break;
                    case "miles per gallon (uk)":
                        output = input * 1.201;
                        break;
                    case "kilometers per liter":
                        output = input / 2.352;
                        break;
                    case "liters per 100 kilometers":
                        output = 235.215 / input;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "miles per gallon (uk)": {
                switch (itemName2) {
                    case "miles per gallon (uk)":
                        output = input;
                        break;
                    case "miles per gallon (us)":
                        output = input / 1.201;
                        break;
                    case "kilometers per liter":
                        output = input / 2.825;
                        break;
                    case "liters per 100 kilometers":
                        output = 282.481 / input;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "kilometers per liter": {
                switch (itemName2) {
                    case "kilometers per liter":
                        output = input;
                        break;
                    case "miles per gallon (us)":
                        output = input * 2.352;
                        break;
                    case "miles per gallon (uk)":
                        output = input * 2.825;
                        break;
                    case "liters per 100 kilometers":
                        output = 100 / input;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "liters per 100 kilometers": {
                switch (itemName2) {
                    case "liters per 100 kilometers":
                        output = input;
                        break;
                    case "miles per gallon (us)":
                        output = 235.215 / input;
                        break;
                    case "miles per gallon (uk)":
                        output = 282.481 / input;
                        break;
                    case "kilometers per liter":
                        output = 100 / input;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateLength() {
        switch (itemName1) {
            case "kilometer": {
                switch (itemName2) {
                    case "kilometer":
                        output = input;
                        break;
                    case "meter":
                        output = input * 1000;
                        break;
                    case "centimeter":
                        output = input * 100000;
                        break;
                    case "millimeter":
                        output = input * 1e+6;
                        break;
                    case "micrometer":
                        output = input * 1e+9;
                        break;
                    case "nanometer":
                        output = input * 1e+12;
                        break;
                    case "mile":
                        output = input / 1.609;
                        break;
                    case "yard":
                        output = input * 1093.613;
                        break;
                    case "foot":
                        output = input * 3280.84;
                        break;
                    case "inch":
                        output = input * 39370.079;
                        break;
                    case "nautical mile":
                        output = input / 1.852;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "meter": {
                switch (itemName2) {
                    case "meter":
                        output = input;
                        break;
                    case "kilometer":
                        output = input / 1000;
                        break;
                    case "centimeter":
                        output = input * 100;
                        break;
                    case "millimeter":
                        output = input * 1000;
                        break;
                    case "micrometer":
                        output = input * 1e+6;
                        break;
                    case "nanometer":
                        output = input * 1e+9;
                        break;
                    case "mile":
                        output = input / 1609.344;
                        break;
                    case "yard":
                        output = input * 1.094;
                        break;
                    case "foot":
                        output = input * 3.281;
                        break;
                    case "inch":
                        output = input * 39.37;
                        break;
                    case "nautical mile":
                        output = input / 1852;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "centimeter": {
                switch (itemName2) {
                    case "centimeter":
                        output = input;
                        break;
                    case "kilometer":
                        output = input / 100000;
                        break;
                    case "meter":
                        output = input / 100;
                        break;
                    case "millimeter":
                        output = input * 10;
                        break;
                    case "micrometer":
                        output = input * 10000;
                        break;
                    case "nanometer":
                        output = input * 1e+7;
                        break;
                    case "mile":
                        output = input / 160934.4;
                        break;
                    case "yard":
                        output = input / 91.44;
                        break;
                    case "foot":
                        output = input / 30.48;
                        break;
                    case "inch":
                        output = input / 2.54;
                        break;
                    case "nautical mile":
                        output = input / 185200;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "millimeter": {
                switch (itemName2) {
                    case "millimeter":
                        output = input;
                        break;
                    case "kilometer":
                        output = input / 1e+6;
                        break;
                    case "meter":
                        output = input / 1000;
                        break;
                    case "centimeter":
                        output = input / 10;
                        break;
                    case "micrometer":
                        output = input * 1000;
                        break;
                    case "nanometer":
                        output = input * 1e+6;
                        break;
                    case "mile":
                        output = input / 1.609e+6;
                        break;
                    case "yard":
                        output = input / 914.4;
                        break;
                    case "foot":
                        output = input / 304.8;
                        break;
                    case "inch":
                        output = input / 25.4;
                        break;
                    case "nautical mile":
                        output = input / 1.852e+6;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "micrometer": {
                switch (itemName2) {
                    case "micrometer":
                        output = input;
                        break;
                    case "kilometer":
                        output = input / 1e+9;
                        break;
                    case "meter":
                        output = input / 1e+6;
                        break;
                    case "centimeter":
                        output = input / 10000;
                        break;
                    case "millimeter":
                        output = input / 1000;
                        break;
                    case "nanometer":
                        output = input * 1000;
                        break;
                    case "mile":
                        output = input / 1.609e+9;
                        break;
                    case "yard":
                        output = input / 914400;
                        break;
                    case "foot":
                        output = input / 304800;
                        break;
                    case "inch":
                        output = input / 25400;
                        break;
                    case "nautical mile":
                        output = input / 1.852e+9;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "nanometer": {
                switch (itemName2) {
                    case "nanometer":
                        output = input;
                        break;
                    case "kilometer":
                        output = input / 1e+12;
                        break;
                    case "meter":
                        output = input / 1e+9;
                        break;
                    case "centimeter":
                        output = input / 1e+7;
                        break;
                    case "millimeter":
                        output = input / 1e+6;
                        break;
                    case "micrometer":
                        output = input / 1000;
                        break;
                    case "mile":
                        output = input / 1.609e+12;
                        break;
                    case "yard":
                        output = input / 9.144e+8;
                        break;
                    case "foot":
                        output = input / 3.048e+8;
                        break;
                    case "inch":
                        output = input / 2.54e+7;
                        break;
                    case "nautical mile":
                        output = input / 1.852e+12;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "mile": {
                switch (itemName2) {
                    case "mile":
                        output = input;
                        break;
                    case "kilometer":
                        output = input * 1.609;
                        break;
                    case "meter":
                        output = input * 1609.344;
                        break;
                    case "centimeter":
                        output = input * 160934.4;
                        break;
                    case "millimeter":
                        output = input * 1.609e+6;
                        break;
                    case "micrometer":
                        output = input * 1.609e+9;
                        break;
                    case "nanometer":
                        output = input * 1.609e+12;
                        break;
                    case "yard":
                        output = input * 1760;
                        break;
                    case "foot":
                        output = input * 5280;
                        break;
                    case "inch":
                        output = input * 63360;
                        break;
                    case "nautical mile":
                        output = input / 1.151;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "yard": {
                switch (itemName2) {
                    case "yard":
                        output = input;
                        break;
                    case "kilometer":
                        output = input / 1093.613;
                        break;
                    case "meter":
                        output = input / 1.094;
                        break;
                    case "centimeter":
                        output = input * 91.44;
                        break;
                    case "millimeter":
                        output = input * 914.4;
                        break;
                    case "micrometer":
                        output = input * 914400;
                        break;
                    case "nanometer":
                        output = input * 9.144e+8;
                        break;
                    case "mile":
                        output = input / 1760;
                        break;
                    case "foot":
                        output = input * 3;
                        break;
                    case "inch":
                        output = input * 36;
                        break;
                    case "nautical mile":
                        output = input / 2025.372;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "foot": {
                switch (itemName2) {
                    case "foot":
                        output = input;
                        break;
                    case "kilometer":
                        output = input / 3280.84;
                        break;
                    case "meter":
                        output = input / 3.281;
                        break;
                    case "centimeter":
                        output = input * 30.48;
                        break;
                    case "millimeter":
                        output = input * 304.8;
                        break;
                    case "micrometer":
                        output = input * 304800;
                        break;
                    case "nanometer":
                        output = input * 3.048e+8;
                        break;
                    case "mile":
                        output = input / 5280;
                        break;
                    case "yard":
                        output = input / 3;
                        break;
                    case "inch":
                        output = input * 12;
                        break;
                    case "nautical mile":
                        output = input / 6076.115;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "inch": {
                switch (itemName2) {
                    case "inch":
                        output = input;
                        break;
                    case "kilometer":
                        output = input / 39370.079;
                        break;
                    case "meter":
                        output = input / 39.37;
                        break;
                    case "centimeter":
                        output = input * 2.54;
                        break;
                    case "millimeter":
                        output = input * 25.4;
                        break;
                    case "micrometer":
                        output = input * 25400;
                        break;
                    case "nanometer":
                        output = input * 2.54e+7;
                        break;
                    case "mile":
                        output = input / 63360;
                        break;
                    case "yard":
                        output = input / 36;
                        break;
                    case "foot":
                        output = input / 12;
                        break;
                    case "nautical mile":
                        output = input / 72913.386;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "nautical mile": {
                switch (itemName2) {
                    case "nautical mile":
                        output = input;
                        break;
                    case "kilometer":
                        output = input * 1.852;
                        break;
                    case "meter":
                        output = input * 1852;
                        break;
                    case "centimeter":
                        output = input * 185200;
                        break;
                    case "millimeter":
                        output = input * 1.852e+6;
                        break;
                    case "micrometer":
                        output = input * 1.852e+9;
                        break;
                    case "nanometer":
                        output = input * 1.852e+12;
                        break;
                    case "mile":
                        output = input * 1.151;
                        break;
                    case "yard":
                        output = input * 2025.372;
                        break;
                    case "foot":
                        output = input * 6076.115;
                        break;
                    case "inch":
                        output = input * 72913.386;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculatePressure() {
        switch (itemName1) {
            case "standard atmosphere": {
                switch (itemName2) {
                    case "standard atmosphere":
                        output = input;
                        break;
                    case "bar":
                        output = input * 1.013;
                        break;
                    case "pascal":
                        output = input * 101325;
                        break;
                    case "torr":
                        output = input * 760;
                        break;
                    case "pound per square inch (psi)":
                        output = input * 14.696;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "bar": {
                switch (itemName2) {
                    case "bar":
                        output = input;
                        break;
                    case "standard atmosphere":
                        output = input / 1.013;
                        break;
                    case "pascal":
                        output = input * 100000;
                        break;
                    case "torr":
                        output = input * 750.062;
                        break;
                    case "pound per square inch (psi)":
                        output = input * 14.504;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "pascal": {
                switch (itemName2) {
                    case "pascal":
                        output = input;
                        break;
                    case "standard atmosphere":
                        output = input / 101325;
                        break;
                    case "bar":
                        output = input / 100000;
                        break;
                    case "torr":
                        output = input / 133.322;
                        break;
                    case "pound per square inch (psi)":
                        output = input / 6894.757;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "torr": {
                switch (itemName2) {
                    case "torr":
                        output = input;
                        break;
                    case "standard atmosphere":
                        output = input / 760;
                        break;
                    case "bar":
                        output = input / 750.062;
                        break;
                    case "pascal":
                        output = input * 133.322;
                        break;
                    case "pound per square inch (psi)":
                        output = input / 51.715;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "pound per square inch (psi)": {
                switch (itemName2) {
                    case "pound per square inch (psi)":
                        output = input;
                        break;
                    case "standard atmosphere":
                        output = input / 14.696;
                        break;
                    case "bar":
                        output = input / 14.504;
                        break;
                    case "pascal":
                        output = input / 6894.757;
                        break;
                    case "torr":
                        output = input * 51.715;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateSpeed() {
        switch (itemName1) {
            case "kilometer per hour (km/h)": {
                switch (itemName2) {
                    case "kilometer per hour (km/h)":
                        output = input;
                        break;
                    case "mile per hour (mi/h)":
                        output = input / 1.609;
                        break;
                    case "meter per second (m/s)":
                        output = input / 3.6;
                        break;
                    case "foot per second (ft/s)":
                        output = input / 1.097;
                        break;
                    case "knot (kt)":
                        output = input / 1.852;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "mile per hour (mi/h)": {
                switch (itemName2) {
                    case "mile per hour (mi/h)":
                        output = input;
                        break;
                    case "kilometer per hour (km/h)":
                        output = input * 1.609;
                        break;
                    case "meter per second (m/s)":
                        output = input / 2.237;
                        break;
                    case "foot per second (ft/s)":
                        output = input * 1.467;
                        break;
                    case "knot (kt)":
                        output = input / 1.151;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "meter per second (m/s))": {
                switch (itemName2) {
                    case "meter per second (m/s)":
                        output = input;
                        break;
                    case "kilometer per hour (km/h)":
                        output = input * 3.6;
                        break;
                    case "mile per hour (mi/h)":
                        output = input * 2.237;
                        break;
                    case "foot per second (ft/s)":
                        output = input * 3.281;
                        break;
                    case "knot (kt)":
                        output = input * 1.944;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "foot per second (ft/s)": {
                switch (itemName2) {
                    case "foot per second (ft/s)":
                        output = input;
                        break;
                    case "kilometer per hour (km/h)":
                        output = input * 1.097;
                        break;
                    case "mile per hour (mi/h)":
                        output = input / 1.467;
                        break;
                    case "meter per second (m/s)":
                        output = input / 3.281;
                        break;
                    case "knot (kt)":
                        output = input / 1.688;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "knot (kt)": {
                switch (itemName2) {
                    case "knot (kt)":
                        output = input;
                        break;
                    case "kilometer per hour (km/h)":
                        output = input * 1.852;
                        break;
                    case "mile per hour (mi/h)":
                        output = input * 1.151;
                        break;
                    case "meter per second (m/s)":
                        output = input / 1.944;
                        break;
                    case "foot per second (ft/s)":
                        output = input * 1.688;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateTemperature() {
        switch (itemName1) {
            case "celsius": {
                switch (itemName2) {
                    case "celsius":
                        output = input;
                        break;
                    case "fahrenheit":
                        output = (input * (9.0 / 5.0)) + 32.0;
                        break;
                    case "kelvin":
                        output = input + 273.15;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "fahrenheit": {
                switch (itemName2) {
                    case "fahrenheit":
                        output = input;
                        break;
                    case "celsius":
                        output = (input - 32.0) * (5.0 / 9.0);
                        break;
                    case "kelvin":
                        output = ((input - 32.0) * (5.0 / 9.0)) + 273.15;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "kelvin": {
                switch (itemName2) {
                    case "kelvin":
                        output = input;
                        break;
                    case "celsius":
                        output = input - 273.15;
                        break;
                    case "fahrenheit":
                        output = (input - 273.15) * (9.0 / 5.0) + 32;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateTime() {
        switch (itemName1) {
            case "nanosecond": {
                switch (itemName2) {
                    case "nanosecond":
                        output = input;
                        break;
                    case "microsecond":
                        output = input / 1000;
                        break;
                    case "millisecond":
                        output = input / 1e+6;
                        break;
                    case "second":
                        output = input / 1e+9;
                        break;
                    case "minute":
                        output = input / 6e+10;
                        break;
                    case "hour":
                        output = input / 3.6e+12;
                        break;
                    case "day":
                        output = input / 8.64e+13;
                        break;
                    case "week":
                        output = input / 6.048e+14;
                        break;
                    case "month":
                        output = input / 2.628e+15;
                        break;
                    case "year":
                        output = input / 3.154e+16;
                        break;
                    case "decade":
                        output = input / 3.154e+17;
                        break;
                    case "century":
                        output = input / 3.154e+18;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "microsecond": {
                switch (itemName2) {
                    case "microsecond":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 1000;
                        break;
                    case "millisecond":
                        output = input / 1000;
                        break;
                    case "second":
                        output = input / 1e+6;
                        break;
                    case "minute":
                        output = input / 6e+7;
                        break;
                    case "hour":
                        output = input / 3.6e+9;
                        break;
                    case "day":
                        output = input / 8.64e+10;
                        break;
                    case "week":
                        output = input / 6.048e+11;
                        break;
                    case "month":
                        output = input / 2.628e+12;
                        break;
                    case "year":
                        output = input / 3.154e+13;
                        break;
                    case "decade":
                        output = input / 3.154e+14;
                        break;
                    case "century":
                        output = input / 3.154e+15;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "millisecond": {
                switch (itemName2) {
                    case "millisecond":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 1e+6;
                        break;
                    case "microsecond":
                        output = input * 1000;
                        break;
                    case "second":
                        output = input / 1000;
                        break;
                    case "minute":
                        output = input / 60000;
                        break;
                    case "hour":
                        output = input / 3.6e+6;
                        break;
                    case "day":
                        output = input / 8.64e+7;
                        break;
                    case "week":
                        output = input / 6.048e+8;
                        break;
                    case "month":
                        output = input / 2.628e+9;
                        break;
                    case "year":
                        output = input / 3.154e+10;
                        break;
                    case "decade":
                        output = input / 3.154e+11;
                        break;
                    case "century":
                        output = input / 3.154e+12;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "second": {
                switch (itemName2) {
                    case "second":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 1e+9;
                        break;
                    case "microsecond":
                        output = input * 1e+6;
                        break;
                    case "millisecond":
                        output = input * 1000;
                        break;
                    case "minute":
                        output = input / 60;
                        break;
                    case "hour":
                        output = input / 3600;
                        break;
                    case "day":
                        output = input / 86400;
                        break;
                    case "week":
                        output = input / 604800;
                        break;
                    case "month":
                        output = input / 2.628e+6;
                        break;
                    case "year":
                        output = input / 3.154e+7;
                        break;
                    case "decade":
                        output = input / 3.154e+8;
                        break;
                    case "century":
                        output = input / 3.154e+9;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "minute": {
                switch (itemName2) {
                    case "minute":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 6e+10;
                        break;
                    case "microsecond":
                        output = input * 6e+7;
                        break;
                    case "millisecond":
                        output = input * 60000;
                        break;
                    case "second":
                        output = input * 60;
                        break;
                    case "hour":
                        output = input / 60;
                        break;
                    case "day":
                        output = input / 1440;
                        break;
                    case "week":
                        output = input / 10080;
                        break;
                    case "month":
                        output = input / 43800.048;
                        break;
                    case "year":
                        output = input / 525600;
                        break;
                    case "decade":
                        output = input / 5.256e+6;
                        break;
                    case "century":
                        output = input / 5.256e+7;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "hour": {
                switch (itemName2) {
                    case "hour":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 3.6e+12;
                        break;
                    case "microsecond":
                        output = input * 3.6e+9;
                        break;
                    case "millisecond":
                        output = input * 3.6e+6;
                        break;
                    case "second":
                        output = input * 3600;
                        break;
                    case "minute":
                        output = input * 60;
                        break;
                    case "day":
                        output = input / 24;
                        break;
                    case "week":
                        output = input / 168;
                        break;
                    case "month":
                        output = input / 730.001;
                        break;
                    case "year":
                        output = input / 8760;
                        break;
                    case "decade":
                        output = input / 87600;
                        break;
                    case "century":
                        output = input / 876000;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "day": {
                switch (itemName2) {
                    case "day":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 8.64e+13;
                        break;
                    case "microsecond":
                        output = input * 8.64e+10;
                        break;
                    case "millisecond":
                        output = input * 8.64e+7;
                        break;
                    case "second":
                        output = input * 86400;
                        break;
                    case "minute":
                        output = input * 1440;
                        break;
                    case "hour":
                        output = input * 24;
                        break;
                    case "week":
                        output = input / 7;
                        break;
                    case "month":
                        output = input / 30.417;
                        break;
                    case "year":
                        output = input / 365;
                        break;
                    case "decade":
                        output = input / 3650;
                        break;
                    case "century":
                        output = input / 36500;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "week": {
                switch (itemName2) {
                    case "week":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 6.048e+14;
                        break;
                    case "microsecond":
                        output = input * 6.048e+11;
                        break;
                    case "millisecond":
                        output = input * 6.048e+8;
                        break;
                    case "second":
                        output = input * 604800;
                        break;
                    case "minute":
                        output = input * 10080;
                        break;
                    case "hour":
                        output = input * 168;
                        break;
                    case "day":
                        output = input * 7;
                        break;
                    case "month":
                        output = input / 4.345;
                        break;
                    case "year":
                        output = input / 52.143;
                        break;
                    case "decade":
                        output = input / 521.429;
                        break;
                    case "century":
                        output = input / 5214.286;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "month": {
                switch (itemName2) {
                    case "month":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 2.628e+15;
                        break;
                    case "microsecond":
                        output = input * 2.628e+12;
                        break;
                    case "millisecond":
                        output = input * 2.628e+9;
                        break;
                    case "second":
                        output = input * 2.628e+6;
                        break;
                    case "minute":
                        output = input * 43800.048;
                        break;
                    case "hour":
                        output = input * 730.001;
                        break;
                    case "day":
                        output = input * 30.417;
                        break;
                    case "week":
                        output = input * 4.345;
                        break;
                    case "year":
                        output = input / 12;
                        break;
                    case "decade":
                        output = input / 120;
                        break;
                    case "century":
                        output = input / 1200.0;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "year": {
                switch (itemName2) {
                    case "year":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 3.154e+16;
                        break;
                    case "microsecond":
                        output = input * 3.154e+13;
                        break;
                    case "millisecond":
                        output = input * 3.154e+10;
                        break;
                    case "second":
                        output = input * 3.154e+7;
                        break;
                    case "minute":
                        output = input * 525600;
                        break;
                    case "hour":
                        output = input * 8760;
                        break;
                    case "day":
                        output = input * 365;
                        break;
                    case "week":
                        output = input * 52.143;
                        break;
                    case "month":
                        output = input * 12;
                        break;
                    case "decade":
                        output = input / 10;
                        break;
                    case "century":
                        output = input / 100;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "decade": {
                switch (itemName2) {
                    case "decade":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 3.154e+17;
                        break;
                    case "microsecond":
                        output = input * 3.154e+14;
                        break;
                    case "millisecond":
                        output = input * 3.154e+11;
                        break;
                    case "second":
                        output = input * 3.154e+8;
                        break;
                    case "minute":
                        output = input * 5.256e+6;
                        break;
                    case "hour":
                        output = input * 87600;
                        break;
                    case "day":
                        output = input * 3650;
                        break;
                    case "week":
                        output = input * 521.429;
                        break;
                    case "month":
                        output = input * 120;
                        break;
                    case "year":
                        output = input * 10;
                        break;
                    case "century":
                        output = input / 10;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "century": {
                switch (itemName2) {
                    case "century":
                        output = input;
                        break;
                    case "nanosecond":
                        output = input * 3.154e+18;
                        break;
                    case "microsecond":
                        output = input * 3.154e+15;
                        break;
                    case "millisecond":
                        output = input * 3.154e+12;
                        break;
                    case "second":
                        output = input * 3.154e+9;
                        break;
                    case "minute":
                        output = input * 5.256e+7;
                        break;
                    case "hour":
                        output = input * 876000;
                        break;
                    case "day":
                        output = input * 36500;
                        break;
                    case "week":
                        output = input * 5214.286;
                        break;
                    case "month":
                        output = input * 1200.0;
                        break;
                    case "year":
                        output = input * 100;
                        break;
                    case "decade":
                        output = input * 10;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateVolume() {
        switch (itemName1) {
            case "liter": {
                switch (itemName2) {
                    case "liter":
                        output = input;
                        break;
                    case "milliliter":
                        output = input * 1000;
                        break;
                    case "gallon (us)":
                        output = input / 3.785;
                        break;
                    case "gallon (uk)":
                        output = input / 4.546;
                        break;
                    case "cubic meter":
                        output = input / 1000;
                        break;
                    case "cubic foot":
                        output = input / 28.317;
                        break;
                    case "cubic inch":
                        output = input * 61.024;
                        break;
                    case "fluid ounce (us)":
                        output = input * 33.814;
                        break;
                    case "fluid ounce (uk)":
                        output = input * 35.195;
                        break;
                    case "liquid pint (us)":
                        output = input * 2.113;
                        break;
                    case "imperial pint (uk)":
                        output = input * 1.76;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "milliliter": {
                switch (itemName2) {
                    case "milliliter":
                        output = input;
                        break;
                    case "liter":
                        output = input / 1000;
                        break;
                    case "gallon (us)":
                        output = input / 3785.412;
                        break;
                    case "gallon (uk)":
                        output = input / 4546.09;
                        break;
                    case "cubic meter":
                        output = input / 1e+6;
                        break;
                    case "cubic foot":
                        output = input / 28316.847;
                        break;
                    case "cubic inch":
                        output = input / 16.387;
                        break;
                    case "fluid ounce (us)":
                        output = input / 29.574;
                        break;
                    case "fluid ounce (uk)":
                        output = input / 28.413;
                        break;
                    case "liquid pint (us)":
                        output = input / 473.176;
                        break;
                    case "imperial pint (uk)":
                        output = input / 568.261;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "gallon (us)": {
                switch (itemName2) {
                    case "gallon (us)":
                        output = input;
                        break;
                    case "liter":
                        output = input * 3.785;
                        break;
                    case "milliliter":
                        output = input * 3785.412;
                        break;
                    case "gallon (uk)":
                        output = input / 1.201;
                        break;
                    case "cubic meter":
                        output = input / 264.172;
                        break;
                    case "cubic foot":
                        output = input / 7.481;
                        break;
                    case "cubic inch":
                        output = input * 231;
                        break;
                    case "fluid ounce (us)":
                        output = input * 128;
                        break;
                    case "fluid ounce (uk)":
                        output = input * 133.228;
                        break;
                    case "liquid pint (us)":
                        output = input * 8;
                        break;
                    case "imperial pint (uk)":
                        output = input * 6.661;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "gallon (uk)": {
                switch (itemName2) {
                    case "gallon (uk)":
                        output = input;
                        break;
                    case "liter":
                        output = input * 4.546;
                        break;
                    case "milliliter":
                        output = input * 4546.09;
                        break;
                    case "gallon (us)":
                        output = input * 1.201;
                        break;
                    case "cubic meter":
                        output = input / 219.969;
                        break;
                    case "cubic foot":
                        output = input / 6.229;
                        break;
                    case "cubic inch":
                        output = input * 277.419;
                        break;
                    case "fluid ounce (us)":
                        output = input * 153.722;
                        break;
                    case "fluid ounce (uk)":
                        output = input * 160;
                        break;
                    case "liquid pint (us)":
                        output = input * 9.608;
                        break;
                    case "imperial pint (uk)":
                        output = input * 8;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "cubic meter": {
                switch (itemName2) {
                    case "cubic meter":
                        output = input;
                        break;
                    case "liter":
                        output = input * 1000;
                        break;
                    case "milliliter":
                        output = input * 1e+6;
                        break;
                    case "gallon (us)":
                        output = input * 264.172;
                        break;
                    case "gallon (uk)":
                        output = input * 219.969;
                        break;
                    case "cubic foot":
                        output = input * 35.315;
                        break;
                    case "cubic inch":
                        output = input * 61023.744;
                        break;
                    case "fluid ounce (us)":
                        output = input * 33814.023;
                        break;
                    case "fluid ounce (uk)":
                        output = input * 35195.08;
                        break;
                    case "liquid pint (us)":
                        output = input * 2113.376;
                        break;
                    case "imperial pint (uk)":
                        output = input * 1759.754;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "cubic foot": {
                switch (itemName2) {
                    case "cubic foot":
                        output = input;
                        break;
                    case "liter":
                        output = input * 28.317;
                        break;
                    case "milliliter":
                        output = input * 28316.847;
                        break;
                    case "gallon (us)":
                        output = input * 7.481;
                        break;
                    case "gallon (uk)":
                        output = input * 6.229;
                        break;
                    case "cubic meter":
                        output = input / 35.315;
                        break;
                    case "cubic inch":
                        output = input * 1728;
                        break;
                    case "fluid ounce (us)":
                        output = input * 957.506;
                        break;
                    case "fluid ounce (uk)":
                        output = input * 996.614;
                        break;
                    case "liquid pint (us)":
                        output = input * 59.844;
                        break;
                    case "imperial pint (uk)":
                        output = input * 49.831;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "cubic inch": {
                switch (itemName2) {
                    case "cubic inch":
                        output = input;
                        break;
                    case "liter":
                        output = input / 61.024;
                        break;
                    case "milliliter":
                        output = input * 16.387;
                        break;
                    case "gallon (us)":
                        output = input / 231;
                        break;
                    case "gallon (uk)":
                        output = input / 277.419;
                        break;
                    case "cubic meter":
                        output = input / 61023.744;
                        break;
                    case "cubic foot":
                        output = input / 1728;
                        break;
                    case "fluid ounce (us)":
                        output = input / 1.805;
                        break;
                    case "fluid ounce (uk)":
                        output = input / 1.734;
                        break;
                    case "liquid pint (us)":
                        output = input / 28.875;
                        break;
                    case "imperial pint (uk)":
                        output = input / 34.677;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "fluid ounce (us)": {
                switch (itemName2) {
                    case "fluid ounce (us)":
                        output = input;
                        break;
                    case "liter":
                        output = input / 33.814;
                        break;
                    case "milliliter":
                        output = input * 29.574;
                        break;
                    case "gallon (us)":
                        output = input / 128;
                        break;
                    case "gallon (uk)":
                        output = input / 153.722;
                        break;
                    case "cubic meter":
                        output = input / 33814.023;
                        break;
                    case "cubic foot":
                        output = input / 957.506;
                        break;
                    case "cubic inch":
                        output = input * 1.805;
                        break;
                    case "fluid ounce (uk)":
                        output = input * 1.041;
                        break;
                    case "liquid pint (us)":
                        output = input / 16;
                        break;
                    case "imperial pint (uk)":
                        output = input / 19.215;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "fluid ounce (uk)": {
                switch (itemName2) {
                    case "fluid ounce (uk)":
                        output = input;
                        break;
                    case "liter":
                        output = input / 35.195;
                        break;
                    case "milliliter":
                        output = input * 28.413;
                        break;
                    case "gallon (us)":
                        output = input / 133.228;
                        break;
                    case "gallon (uk)":
                        output = input / 160;
                        break;
                    case "cubic meter":
                        output = input / 35195.08;
                        break;
                    case "cubic foot":
                        output = input / 996.614;
                        break;
                    case "cubic inch":
                        output = input * 1.734;
                        break;
                    case "fluid ounce (us)":
                        output = input / 1.041;
                        break;
                    case "liquid pint (us)":
                        output = input / 16.653;
                        break;
                    case "imperial pint (uk)":
                        output = input / 20;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "liquid pint (us)": {
                switch (itemName2) {
                    case "liquid pint (us)":
                        output = input;
                        break;
                    case "liter":
                        output = input / 2.113;
                        break;
                    case "milliliter":
                        output = input * 473.176;
                        break;
                    case "gallon (us)":
                        output = input / 8;
                        break;
                    case "gallon (uk)":
                        output = input / 9.608;
                        break;
                    case "cubic meter":
                        output = input / 2113.376;
                        break;
                    case "cubic foot":
                        output = input / 59.844;
                        break;
                    case "cubic inch":
                        output = input * 28.875;
                        break;
                    case "fluid ounce (us)":
                        output = input * 16;
                        break;
                    case "fluid ounce (uk)":
                        output = input * 16.653;
                        break;
                    case "imperial pint (uk)":
                        output = input / 1.201;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "imperial pint (uk)": {
                switch (itemName2) {
                    case "imperial pint (uk)":
                        output = input;
                        break;
                    case "liter":
                        output = input / 1.76;
                        break;
                    case "milliliter":
                        output = input * 568.261;
                        break;
                    case "gallon (us)":
                        output = input / 6.661;
                        break;
                    case "gallon (uk)":
                        output = input / 8;
                        break;
                    case "cubic meter":
                        output = input / 1759.754;
                        break;
                    case "cubic foot":
                        output = input / 49.831;
                        break;
                    case "cubic inch":
                        output = input * 34.677;
                        break;
                    case "fluid ounce (us)":
                        output = input * 19.215;
                        break;
                    case "fluid ounce (uk)":
                        output = input * 20;
                        break;
                    case "liquid pint (us)":
                        output = input * 1.201;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }

    private static void calculateWeight() {
        switch (itemName1) {
            case "tonne": {
                switch (itemName2) {
                    case "tonne":
                        output = input;
                        break;
                    case "kilogram":
                        output = input * 1000;
                        break;
                    case "gram":
                        output = input * 1e+6;
                        break;
                    case "milligram":
                        output = input * 1e+9;
                        break;
                    case "microgram":
                        output = input * 1e+12;
                        break;
                    case "long ton (uk)":
                        output = input / 1.016;
                        break;
                    case "short ton (us)":
                        output = input * 1.102;
                        break;
                    case "stone":
                        output = input * 157.473;
                        break;
                    case "pound":
                        output = input * 2204.623;
                        break;
                    case "ounce":
                        output = input * 35273.962;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "kilogram": {
                switch (itemName2) {
                    case "kilogram":
                        output = input;
                        break;
                    case "tonne":
                        output = input / 1000;
                        break;
                    case "gram":
                        output = input * 1000;
                        break;
                    case "milligram":
                        output = input * 1e+6;
                        break;
                    case "microgram":
                        output = input * 1e+9;
                        break;
                    case "long ton (uk)":
                        output = input / 1016.047;
                        break;
                    case "short ton (us)":
                        output = input / 907.185;
                        break;
                    case "stone":
                        output = input / 6.35;
                        break;
                    case "pound":
                        output = input * 2.205;
                        break;
                    case "ounce":
                        output = input * 35.274;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "gram": {
                switch (itemName2) {
                    case "gram":
                        output = input;
                        break;
                    case "tonne":
                        output = input / 1e+6;
                        break;
                    case "kilogram":
                        output = input / 1000;
                        break;
                    case "milligram":
                        output = input * 1000;
                        break;
                    case "microgram":
                        output = input * 1e+6;
                        break;
                    case "long ton (uk)":
                        output = input / 1.016e+6;
                        break;
                    case "short ton (us)":
                        output = input / 907184.74;
                        break;
                    case "stone":
                        output = input / 6350.293;
                        break;
                    case "pound":
                        output = input / 453.592;
                        break;
                    case "ounce":
                        output = input / 28.35;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "milligram": {
                switch (itemName2) {
                    case "milligram":
                        output = input;
                        break;
                    case "tonne":
                        output = input / 1e+9;
                        break;
                    case "kilogram":
                        output = input / 1e+6;
                        break;
                    case "gram":
                        output = input / 1000;
                        break;
                    case "microgram":
                        output = input * 1000;
                        break;
                    case "long ton (uk)":
                        output = input / 1.016e+9;
                        break;
                    case "short ton (us)":
                        output = input / 9.072e+8;
                        break;
                    case "stone":
                        output = input / 6.35e+6;
                        break;
                    case "pound":
                        output = input / 453592.37;
                        break;
                    case "ounce":
                        output = input / 28349.523;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "microgram": {
                switch (itemName2) {
                    case "microgram":
                        output = input;
                        break;
                    case "tonne":
                        output = input / 1e+12;
                        break;
                    case "kilogram":
                        output = input / 1e+9;
                        break;
                    case "gram":
                        output = input / 1e+6;
                        break;
                    case "milligram":
                        output = input / 1000;
                        break;
                    case "long ton (uk)":
                        output = input / 1.016e+12;
                        break;
                    case "short ton (us)":
                        output = input / 9.072e+11;
                        break;
                    case "stone":
                        output = input / 6.35e+9;
                        break;
                    case "pound":
                        output = input / 4.536e+8;
                        break;
                    case "ounce":
                        output = input / 2.835e+7;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "long ton (uk)": {
                switch (itemName2) {
                    case "long ton (uk)":
                        output = input;
                        break;
                    case "tonne":
                        output = input * 1.016;
                        break;
                    case "kilogram":
                        output = input * 1016.047;
                        break;
                    case "gram":
                        output = input * 1.016e+6;
                        break;
                    case "milligram":
                        output = input * 1.016e+9;
                        break;
                    case "microgram":
                        output = input * 1.016e+12;
                        break;
                    case "short ton (us)":
                        output = input * 1.12;
                        break;
                    case "stone":
                        output = input * 160;
                        break;
                    case "pound":
                        output = input * 2240;
                        break;
                    case "ounce":
                        output = input * 35840;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "short ton (us)": {
                switch (itemName2) {
                    case "short ton (us)":
                        output = input;
                        break;
                    case "tonne":
                        output = input / 1.102;
                        break;
                    case "kilogram":
                        output = input * 907.185;
                        break;
                    case "gram":
                        output = input * 907184.74;
                        break;
                    case "milligram":
                        output = input * 9.072e+8;
                        break;
                    case "microgram":
                        output = input * 9.072e+11;
                        break;
                    case "long ton (uk)":
                        output = input / 1.12;
                        break;
                    case "stone":
                        output = input * 142.857;
                        break;
                    case "pound":
                        output = input * 2000;
                        break;
                    case "ounce":
                        output = input * 32000;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "stone": {
                switch (itemName2) {
                    case "stone":
                        output = input;
                        break;
                    case "tonne":
                        output = input / 157.473;
                        break;
                    case "kilogram":
                        output = input * 6.35;
                        break;
                    case "gram":
                        output = input * 6350.293;
                        break;
                    case "milligram":
                        output = input * 6.35e+6;
                        break;
                    case "microgram":
                        output = input * 6.35e+9;
                        break;
                    case "long ton (uk)":
                        output = input / 160;
                        break;
                    case "short ton (us)":
                        output = input / 142.857;
                        break;
                    case "pound":
                        output = input * 14;
                        break;
                    case "ounce":
                        output = input * 224;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "pound": {
                switch (itemName2) {
                    case "pound":
                        output = input;
                        break;
                    case "tonne":
                        output = input / 2204.623;
                        break;
                    case "kilogram":
                        output = input / 2.205;
                        break;
                    case "gram":
                        output = input * 453.592;
                        break;
                    case "milligram":
                        output = input * 453592.37;
                        break;
                    case "microgram":
                        output = input * 4.536e+8;
                        break;
                    case "long ton (uk)":
                        output = input / 2240;
                        break;
                    case "short ton (us)":
                        output = input / 2000;
                        break;
                    case "stone":
                        output = input / 14;
                        break;
                    case "ounce":
                        output = input * 16;
                        break;
                    default:
                        break;
                }
                break;
            }
            case "ounce": {
                switch (itemName2) {
                    case "ounce":
                        output = input;
                        break;
                    case "tonne":
                        output = input / 35273.962;
                        break;
                    case "kilogram":
                        output = input / 35.274;
                        break;
                    case "gram":
                        output = input * 28.35;
                        break;
                    case "milligram":
                        output = input * 28349.523;
                        break;
                    case "microgram":
                        output = input * 2.835e+7;
                        break;
                    case "long ton (uk)":
                        output = input / 35840;
                        break;
                    case "short ton (us)":
                        output = input / 32000;
                        break;
                    case "stone":
                        output = input / 224;
                        break;
                    case "pound":
                        output = input / 16;
                        break;
                    default:
                        break;
                }
                break;
            }
            default:
                break;
        }
    }
}
