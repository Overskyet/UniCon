package overskyet.unicon;

final class VolumeUnitsCalculation {

    static double convert(double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "liter": {

                switch (itemName2) {

                    case "liter":
                        output = inputValue;
                        break;

                    case "milliliter":
                        output = inputValue * 1000;
                        break;

                    case "gallon (us)":
                        output = inputValue / 3.785;
                        break;

                    case "gallon (uk)":
                        output = inputValue / 4.546;
                        break;

                    case "cubic meter":
                        output = inputValue / 1000;
                        break;

                    case "cubic foot":
                        output = inputValue / 28.317;
                        break;

                    case "cubic inch":
                        output = inputValue * 61.024;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue * 33.814;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue * 35.195;
                        break;

                    case "liquid pint (us)":
                        output = inputValue * 2.113;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue * 1.76;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "milliliter": {

                switch (itemName2) {

                    case "milliliter":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue / 1000;
                        break;

                    case "gallon (us)":
                        output = inputValue / 3785.412;
                        break;

                    case "gallon (uk)":
                        output = inputValue / 4546.09;
                        break;

                    case "cubic meter":
                        output = inputValue / 1e+6;
                        break;

                    case "cubic foot":
                        output = inputValue / 28316.847;
                        break;

                    case "cubic inch":
                        output = inputValue / 16.387;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue / 29.574;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue / 28.413;
                        break;

                    case "liquid pint (us)":
                        output = inputValue / 473.176;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue / 568.261;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "gallon (us)": {

                switch (itemName2) {

                    case "gallon (us)":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue * 3.785;
                        break;

                    case "milliliter":
                        output = inputValue * 3785.412;
                        break;

                    case "gallon (uk)":
                        output = inputValue / 1.201;
                        break;

                    case "cubic meter":
                        output = inputValue / 264.172;
                        break;

                    case "cubic foot":
                        output = inputValue / 7.481;
                        break;

                    case "cubic inch":
                        output = inputValue * 231;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue * 128;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue * 133.228;
                        break;

                    case "liquid pint (us)":
                        output = inputValue * 8;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue * 6.661;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "gallon (uk)": {

                switch (itemName2) {

                    case "gallon (uk)":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue * 4.546;
                        break;

                    case "milliliter":
                        output = inputValue * 4546.09;
                        break;

                    case "gallon (us)":
                        output = inputValue * 1.201;
                        break;

                    case "cubic meter":
                        output = inputValue / 219.969;
                        break;

                    case "cubic foot":
                        output = inputValue / 6.229;
                        break;

                    case "cubic inch":
                        output = inputValue * 277.419;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue * 153.722;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue * 160;
                        break;

                    case "liquid pint (us)":
                        output = inputValue * 9.608;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue * 8;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "cubic meter": {

                switch (itemName2) {

                    case "cubic meter":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue * 1000;
                        break;

                    case "milliliter":
                        output = inputValue * 1e+6;
                        break;

                    case "gallon (us)":
                        output = inputValue * 264.172;
                        break;

                    case "gallon (uk)":
                        output = inputValue * 219.969;
                        break;

                    case "cubic foot":
                        output = inputValue * 35.315;
                        break;

                    case "cubic inch":
                        output = inputValue * 61023.744;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue * 33814.023;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue * 35195.08;
                        break;

                    case "liquid pint (us)":
                        output = inputValue * 2113.376;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue * 1759.754;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "cubic foot": {

                switch (itemName2) {

                    case "cubic foot":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue * 28.317;
                        break;

                    case "milliliter":
                        output = inputValue * 28316.847;
                        break;

                    case "gallon (us)":
                        output = inputValue * 7.481;
                        break;

                    case "gallon (uk)":
                        output = inputValue * 6.229;
                        break;

                    case "cubic meter":
                        output = inputValue / 35.315;
                        break;

                    case "cubic inch":
                        output = inputValue * 1728;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue * 957.506;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue * 996.614;
                        break;

                    case "liquid pint (us)":
                        output = inputValue * 59.844;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue * 49.831;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "cubic inch": {

                switch (itemName2) {

                    case "cubic inch":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue / 61.024;
                        break;

                    case "milliliter":
                        output = inputValue * 16.387;
                        break;

                    case "gallon (us)":
                        output = inputValue / 231;
                        break;

                    case "gallon (uk)":
                        output = inputValue / 277.419;
                        break;

                    case "cubic meter":
                        output = inputValue / 61023.744;
                        break;

                    case "cubic foot":
                        output = inputValue / 1728;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue / 1.805;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue / 1.734;
                        break;

                    case "liquid pint (us)":
                        output = inputValue / 28.875;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue / 34.677;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "fluid ounce (us)": {

                switch (itemName2) {

                    case "fluid ounce (us)":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue / 33.814;
                        break;

                    case "milliliter":
                        output = inputValue * 29.574;
                        break;

                    case "gallon (us)":
                        output = inputValue / 128;
                        break;

                    case "gallon (uk)":
                        output = inputValue / 153.722;
                        break;

                    case "cubic meter":
                        output = inputValue / 33814.023;
                        break;

                    case "cubic foot":
                        output = inputValue / 957.506;
                        break;

                    case "cubic inch":
                        output = inputValue * 1.805;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue * 1.041;
                        break;

                    case "liquid pint (us)":
                        output = inputValue / 16;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue / 19.215;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "fluid ounce (uk)": {

                switch (itemName2) {

                    case "fluid ounce (uk)":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue / 35.195;
                        break;

                    case "milliliter":
                        output = inputValue * 28.413;
                        break;

                    case "gallon (us)":
                        output = inputValue / 133.228;
                        break;

                    case "gallon (uk)":
                        output = inputValue / 160;
                        break;

                    case "cubic meter":
                        output = inputValue / 35195.08;
                        break;

                    case "cubic foot":
                        output = inputValue / 996.614;
                        break;

                    case "cubic inch":
                        output = inputValue * 1.734;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue / 1.041;
                        break;

                    case "liquid pint (us)":
                        output = inputValue / 16.653;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue / 20;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "liquid pint (us)": {

                switch (itemName2) {

                    case "liquid pint (us)":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue / 2.113;
                        break;

                    case "milliliter":
                        output = inputValue * 473.176;
                        break;

                    case "gallon (us)":
                        output = inputValue / 8;
                        break;

                    case "gallon (uk)":
                        output = inputValue / 9.608;
                        break;

                    case "cubic meter":
                        output = inputValue / 2113.376;
                        break;

                    case "cubic foot":
                        output = inputValue / 59.844;
                        break;

                    case "cubic inch":
                        output = inputValue * 28.875;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue * 16;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue * 16.653;
                        break;

                    case "imperial pint (uk)":
                        output = inputValue / 1.201;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "imperial pint (uk)": {

                switch (itemName2) {

                    case "imperial pint (uk)":
                        output = inputValue;
                        break;

                    case "liter":
                        output = inputValue / 1.76;
                        break;

                    case "milliliter":
                        output = inputValue * 568.261;
                        break;

                    case "gallon (us)":
                        output = inputValue / 6.661;
                        break;

                    case "gallon (uk)":
                        output = inputValue / 8;
                        break;

                    case "cubic meter":
                        output = inputValue / 1759.754;
                        break;

                    case "cubic foot":
                        output = inputValue / 49.831;
                        break;

                    case "cubic inch":
                        output = inputValue * 34.677;
                        break;

                    case "fluid ounce (us)":
                        output = inputValue * 19.215;
                        break;

                    case "fluid ounce (uk)":
                        output = inputValue * 20;
                        break;

                    case "liquid pint (us)":
                        output = inputValue * 1.201;
                        break;

                    default:
                        break;

                }
                break;
            }

            default:
                break;

        }

        return output;

    }

}
