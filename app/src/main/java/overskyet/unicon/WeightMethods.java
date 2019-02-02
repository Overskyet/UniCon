package overskyet.unicon;

final class WeightMethods {

    static double convert(double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "tonne": {

                switch (itemName2) {

                    case "tonne":
                        output = inputValue;
                        break;

                    case "kilogram":
                        output = inputValue * 1000;
                        break;

                    case "gram":
                        output = inputValue * 1e+6;
                        break;

                    case "milligram":
                        output = inputValue * 1e+9;
                        break;

                    case "microgram":
                        output = inputValue * 1e+12;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 1.016;
                        break;

                    case "short ton (us)":
                        output = inputValue * 1.102;
                        break;

                    case "stone":
                        output = inputValue * 157.473;
                        break;

                    case "pound":
                        output = inputValue * 2204.623;
                        break;

                    case "ounce":
                        output = inputValue * 35273.962;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "kilogram": {

                switch (itemName2) {

                    case "kilogram":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue / 1000;
                        break;

                    case "gram":
                        output = inputValue * 1000;
                        break;

                    case "milligram":
                        output = inputValue * 1e+6;
                        break;

                    case "microgram":
                        output = inputValue * 1e+9;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 1016.047;
                        break;

                    case "short ton (us)":
                        output = inputValue / 907.185;
                        break;

                    case "stone":
                        output = inputValue / 6.35;
                        break;

                    case "pound":
                        output = inputValue * 2.205;
                        break;

                    case "ounce":
                        output = inputValue * 35.274;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "gram": {

                switch (itemName2) {

                    case "gram":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue / 1e+6;
                        break;

                    case "kilogram":
                        output = inputValue / 1000;
                        break;


                    case "milligram":
                        output = inputValue * 1000;
                        break;

                    case "microgram":
                        output = inputValue * 1e+6;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 1.016e+6;
                        break;

                    case "short ton (us)":
                        output = inputValue / 907184.74;
                        break;

                    case "stone":
                        output = inputValue / 6350.293;
                        break;

                    case "pound":
                        output = inputValue / 453.592;
                        break;

                    case "ounce":
                        output = inputValue / 28.35;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "milligram": {

                switch (itemName2) {

                    case "milligram":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue / 1e+9;
                        break;

                    case "kilogram":
                        output = inputValue / 1e+6;
                        break;

                    case "gram":
                        output = inputValue / 1000;
                        break;

                    case "microgram":
                        output = inputValue * 1000;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 1.016e+9;
                        break;

                    case "short ton (us)":
                        output = inputValue / 9.072e+8;
                        break;

                    case "stone":
                        output = inputValue / 6.35e+6;
                        break;

                    case "pound":
                        output = inputValue / 453592.37;
                        break;

                    case "ounce":
                        output = inputValue / 28349.523;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "microgram": {

                switch (itemName2) {

                    case "microgram":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue / 1e+12;
                        break;

                    case "kilogram":
                        output = inputValue / 1e+9;
                        break;

                    case "gram":
                        output = inputValue / 1e+6;
                        break;

                    case "milligram":
                        output = inputValue / 1000;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 1.016e+12;
                        break;

                    case "short ton (us)":
                        output = inputValue / 9.072e+11;
                        break;

                    case "stone":
                        output = inputValue / 6.35e+9;
                        break;

                    case "pound":
                        output = inputValue / 4.536e+8;
                        break;

                    case "ounce":
                        output = inputValue / 2.835e+7;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "long ton (uk)": {

                switch (itemName2) {

                    case "long ton (uk)":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue * 1.016;
                        break;

                    case "kilogram":
                        output = inputValue * 1016.047;
                        break;

                    case "gram":
                        output = inputValue * 1.016e+6;
                        break;

                    case "milligram":
                        output = inputValue * 1.016e+9;
                        break;

                    case "microgram":
                        output = inputValue * 1.016e+12;
                        break;

                    case "short ton (us)":
                        output = inputValue * 1.12;
                        break;

                    case "stone":
                        output = inputValue * 160;
                        break;

                    case "pound":
                        output = inputValue * 2240;
                        break;

                    case "ounce":
                        output = inputValue * 35840;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "short ton (us)": {

                switch (itemName2) {

                    case "short ton (us)":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue / 1.102;
                        break;

                    case "kilogram":
                        output = inputValue * 907.185;
                        break;

                    case "gram":
                        output = inputValue * 907184.74;
                        break;

                    case "milligram":
                        output = inputValue * 9.072e+8;
                        break;

                    case "microgram":
                        output = inputValue * 9.072e+11;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 1.12;
                        break;

                    case "stone":
                        output = inputValue * 142.857;
                        break;

                    case "pound":
                        output = inputValue * 2000;
                        break;

                    case "ounce":
                        output = inputValue * 32000;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "stone": {

                switch (itemName2) {

                    case "stone":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue / 157.473;
                        break;

                    case "kilogram":
                        output = inputValue * 6.35;
                        break;

                    case "gram":
                        output = inputValue * 6350.293;
                        break;

                    case "milligram":
                        output = inputValue * 6.35e+6;
                        break;

                    case "microgram":
                        output = inputValue * 6.35e+9;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 160;
                        break;

                    case "short ton (us)":
                        output = inputValue / 142.857;
                        break;

                    case "pound":
                        output = inputValue * 14;
                        break;

                    case "ounce":
                        output = inputValue * 224;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "pound": {

                switch (itemName2) {

                    case "pound":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue / 2204.623;
                        break;

                    case "kilogram":
                        output = inputValue / 2.205;
                        break;

                    case "gram":
                        output = inputValue * 453.592;
                        break;

                    case "milligram":
                        output = inputValue * 453592.37;
                        break;

                    case "microgram":
                        output = inputValue * 4.536e+8;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 2240;
                        break;

                    case "short ton (us)":
                        output = inputValue / 2000;
                        break;

                    case "stone":
                        output = inputValue / 14;
                        break;

                    case "ounce":
                        output = inputValue * 16;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "ounce": {

                switch (itemName2) {

                    case "ounce":
                        output = inputValue;
                        break;

                    case "tonne":
                        output = inputValue / 35273.962;
                        break;

                    case "kilogram":
                        output = inputValue / 35.274;
                        break;

                    case "gram":
                        output = inputValue * 28.35;
                        break;

                    case "milligram":
                        output = inputValue * 28349.523;
                        break;

                    case "microgram":
                        output = inputValue * 2.835e+7;
                        break;

                    case "long ton (uk)":
                        output = inputValue / 35840;
                        break;

                    case "short ton (us)":
                        output = inputValue / 32000;
                        break;

                    case "stone":
                        output = inputValue / 224;
                        break;

                    case "pound":
                        output = inputValue / 16;
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
