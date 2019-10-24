package overskyet.unicon;

final class AreaUnitsCalculation {

    static double convert(double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "square kilometer": {

                switch (itemName2) {

                    case "square kilometer":
                        output = inputValue;
                        break;

                    case "square meter":
                        output = inputValue * 1e+6;
                        break;

                    case "square mile":
                        output = inputValue / 2.59;
                        break;

                    case "square yard":
                        output = inputValue * 1.196e+6;
                        break;

                    case "square foot":
                        output = inputValue * 1.076e+7;
                        break;

                    case "square inch":
                        output = inputValue * 1.55e+9;
                        break;

                    case "hectare":
                        output = inputValue * 100;
                        break;

                    case "acre":
                        output = inputValue * 247.105;
                        break;

                    default:
                        break;

                }
                break;
            }
            case "square meter": {

                switch (itemName2) {

                    case "square meter":
                        output = inputValue;
                        break;

                    case "square kilometer":
                        output = inputValue / 1e+6;
                        break;

                    case "square mile":
                        output = inputValue / 2.59e+6;
                        break;

                    case "square yard":
                        output = inputValue * 1.196;
                        break;

                    case "square foot":
                        output = inputValue * 10.764;
                        break;

                    case "square inch":
                        output = inputValue * 1550.003;
                        break;

                    case "hectare":
                        output = inputValue / 10000;
                        break;

                    case "acre":
                        output = inputValue / 4046.856;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "square mile": {

                switch (itemName2) {

                    case "square mile":
                        output = inputValue;
                        break;

                    case "square kilometer":
                        output = inputValue * 2.59;
                        break;

                    case "square meter":
                        output = inputValue * 2.59e+6;
                        break;

                    case "square yard":
                        output = inputValue * 3.098e+6;
                        break;

                    case "square foot":
                        output = inputValue * 2.788e+7;
                        break;

                    case "square inch":
                        output = inputValue * 4.014e+9;
                        break;

                    case "hectare":
                        output = inputValue * 258.999;
                        break;

                    case "acre":
                        output = inputValue * 640;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "square yard": {

                switch (itemName2) {

                    case "square yard":
                        output = inputValue;
                        break;

                    case "square kilometer":
                        output = inputValue / 1.196e+6;
                        break;

                    case "square meter":
                        output = inputValue / 1.196;
                        break;

                    case "square mile":
                        output = inputValue / 3.098e+6;
                        break;

                    case "square foot":
                        output = inputValue * 9;
                        break;

                    case "square inch":
                        output = inputValue * 1296;
                        break;

                    case "hectare":
                        output = inputValue / 11959.9;
                        break;

                    case "acre":
                        output = inputValue / 4840;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "square foot": {

                switch (itemName2) {

                    case "square foot":
                        output = inputValue;
                        break;

                    case "square kilometer":
                        output = inputValue / 1.076e+7;
                        break;

                    case "square meter":
                        output = inputValue / 10.764;
                        break;

                    case "square mile":
                        output = inputValue / 2.788e+7;
                        break;

                    case "square yard":
                        output = inputValue / 9;
                        break;

                    case "square inch":
                        output = inputValue * 144;
                        break;

                    case "hectare":
                        output = inputValue / 107639.104;
                        break;

                    case "acre":
                        output = inputValue / 43560;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "square inch": {

                switch (itemName2) {

                    case "square inch":
                        output = inputValue;
                        break;

                    case "square kilometer":
                        output = inputValue / 1.55e+9;
                        break;

                    case "square meter":
                        output = inputValue / 1550.003;
                        break;

                    case "square mile":
                        output = inputValue / 4.014e+9;
                        break;

                    case "square yard":
                        output = inputValue / 1296;
                        break;

                    case "square foot":
                        output = inputValue / 144;
                        break;

                    case "hectare":
                        output = inputValue / 1.55e+7;
                        break;

                    case "acre":
                        output = inputValue / 6.273e+6;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "hectare": {

                switch (itemName2) {

                    case "hectare":
                        output = inputValue;
                        break;

                    case "square kilometer":
                        output = inputValue / 100;
                        break;

                    case "square meter":
                        output = inputValue * 10000;
                        break;

                    case "square mile":
                        output = inputValue / 258.999;
                        break;

                    case "square yard":
                        output = inputValue * 11959.9;
                        break;

                    case "square foot":
                        output = inputValue * 107639.104;
                        break;

                    case "square inch":
                        output = inputValue * 1.55e+7;
                        break;

                    case "acre":
                        output = inputValue * 2.471;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "acre": {

                switch (itemName2) {

                    case "acre":
                        output = inputValue;
                        break;

                    case "square kilometer":
                        output = inputValue / 247.105;
                        break;

                    case "square meter":
                        output = inputValue * 4046.856;
                        break;

                    case "square mile":
                        output = inputValue / 640;
                        break;

                    case "square yard":
                        output = inputValue * 4840;
                        break;

                    case "square foot":
                        output = inputValue * 43560;
                        break;

                    case "square inch":
                        output = inputValue * 6.273e+6;
                        break;

                    case "hectare":
                        output = inputValue / 2.471;
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
