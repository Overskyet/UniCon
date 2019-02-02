package overskyet.unicon;

final class EnergyMethods {
    static double convert (double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "joule": {

                switch (itemName2) {

                    case "joule":
                        output = inputValue;
                        break;

                    case "kilojoule":
                        output = inputValue / 1000;
                        break;

                    case "calorie":
                        output = inputValue / 4.184;
                        break;

                    case "kilocalorie":
                        output = inputValue / 4184;
                        break;

                    case "watt hour":
                        output = inputValue / 3600;
                        break;

                    case "kilowatt hour":
                        output = inputValue / 3.6e+6;
                        break;

                    case "electron-volt":
                        output = inputValue * 6.242e+18;
                        break;

                    case "british thermal unit":
                        output = inputValue / 1055.056;
                        break;

                    case "therm":
                        output = inputValue / 1.055e+8;
                        break;

                    case "foot pound":
                        output = inputValue / 1.356;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "kilojoule": {

                switch (itemName2) {

                    case "kilojoule":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue * 1000;
                        break;

                    case "calorie":
                        output = inputValue * 239.006;
                        break;

                    case "kilocalorie":
                        output = inputValue / 4.184;
                        break;

                    case "watt hour":
                        output = inputValue / 3.6;
                        break;

                    case "kilowatt hour":
                        output = inputValue / 3600;
                        break;

                    case "electron-volt":
                        output = inputValue * 6.242e+21;
                        break;

                    case "british thermal unit":
                        output = inputValue / 1.055;
                        break;

                    case "therm":
                        output = inputValue / 105480.4;
                        break;

                    case "foot pound":
                        output = inputValue * 737.562;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "calorie": {

                switch (itemName2) {

                    case "calorie":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue * 4.184;
                        break;

                    case "kilojoule":
                        output = inputValue / 239.006;
                        break;

                    case "kilocalorie":
                        output = inputValue / 1000;
                        break;

                    case "watt hour":
                        output = inputValue / 860.421;
                        break;

                    case "kilowatt hour":
                        output = inputValue / 860420.65;
                        break;

                    case "electron-volt":
                        output = inputValue * 2.611e+19;
                        break;

                    case "british thermal unit":
                        output = inputValue / 252.164;
                        break;

                    case "therm":
                        output = inputValue / 2.521e+7;
                        break;

                    case "foot pound":
                        output = inputValue * 3.086;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "kilocalorie": {

                switch (itemName2) {

                    case "kilocalorie":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue * 4184;
                        break;

                    case "kilojoule":
                        output = inputValue * 4.184;
                        break;

                    case "calorie":
                        output = inputValue * 1000;
                        break;

                    case "watt hour":
                        output = inputValue * 1.162;
                        break;

                    case "kilowatt hour":
                        output = inputValue / 860.421;
                        break;

                    case "electron-volt":
                        output = inputValue * 2.611e+22;
                        break;

                    case "british thermal unit":
                        output = inputValue * 3.966;
                        break;

                    case "therm":
                        output = inputValue / 25210.421;
                        break;

                    case "foot pound":
                        output = inputValue * 3085.96;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "watt hour": {

                switch (itemName2) {

                    case "watt hour":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue * 3600;
                        break;

                    case "kilojoule":
                        output = inputValue * 3.6;
                        break;

                    case "calorie":
                        output = inputValue * 860.421;
                        break;

                    case "kilocalorie":
                        output = inputValue / 1.162;
                        break;

                    case "kilowatt hour":
                        output = inputValue / 1000;
                        break;

                    case "electron-volt":
                        output = inputValue * 2.247e+22;
                        break;

                    case "british thermal unit":
                        output = inputValue * 3.412;
                        break;

                    case "therm":
                        output = inputValue / 29300.111;
                        break;

                    case "foot pound":
                        output = inputValue * 2655.224;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "kilowatt hour": {

                switch (itemName2) {

                    case "kilowatt hour":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue * 3.6e+6;
                        break;

                    case "kilojoule":
                        output = inputValue * 3600;
                        break;

                    case "calorie":
                        output = inputValue * 860420.65;
                        break;

                    case "kilocalorie":
                        output = inputValue * 860.421;
                        break;

                    case "watt hour":
                        output = inputValue * 1000;
                        break;

                    case "electron-volt":
                        output = inputValue * 2.247e+25;
                        break;

                    case "british thermal unit":
                        output = inputValue * 3412.142;
                        break;

                    case "therm":
                        output = inputValue / 29.3;
                        break;

                    case "foot pound":
                        output = inputValue * 2.655e+6;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "electron-volt": {

                switch (itemName2) {

                    case "electron-volt":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue / 6.242e+18;
                        break;

                    case "kilojoule":
                        output = inputValue / 6.242e+21;
                        break;

                    case "calorie":
                        output = inputValue / 2.611e+19;
                        break;

                    case "kilocalorie":
                        output = inputValue / 2.611e+22;
                        break;

                    case "watt hour":
                        output = inputValue / 2.247e+22;
                        break;

                    case "kilowatt hour":
                        output = inputValue / 2.247e+25;
                        break;

                    case "british thermal unit":
                        output = inputValue / 6.585e+21;
                        break;

                    case "therm":
                        output = inputValue / 6.584e+26;
                        break;

                    case "foot pound":
                        output = inputValue / 8.462e+18;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "british thermal unit": {

                switch (itemName2) {

                    case "british thermal unit":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue * 1055.056;
                        break;

                    case "kilojoule":
                        output = inputValue * 1.055;
                        break;

                    case "calorie":
                        output = inputValue * 252.164;
                        break;

                    case "kilocalorie":
                        output = inputValue / 3.966;
                        break;

                    case "watt hour":
                        output = inputValue / 3.412;
                        break;

                    case "kilowatt hour":
                        output = inputValue / 3412.142;
                        break;

                    case "electron-volt":
                        output = inputValue * 6.585e+21;
                        break;

                    case "therm":
                        output = inputValue / 99976.129;
                        break;

                    case "foot pound":
                        output = inputValue * 778.169;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "therm": {

                switch (itemName2) {

                    case "therm":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue * 1.055e+8;
                        break;

                    case "kilojoule":
                        output = inputValue * 105480.4;
                        break;

                    case "calorie":
                        output = inputValue * 2.521e+7;
                        break;

                    case "kilocalorie":
                        output = inputValue * 25210.421;
                        break;

                    case "watt hour":
                        output = inputValue * 29300.111;
                        break;

                    case "kilowatt hour":
                        output = inputValue * 29.3;
                        break;

                    case "electron-volt":
                        output = inputValue * 6.584e+26;
                        break;

                    case "british thermal unit":
                        output = inputValue * 99976.129;
                        break;

                    case "foot pound":
                        output = inputValue * 7.78e+7;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "foot pound": {

                switch (itemName2) {

                    case "foot pound":
                        output = inputValue;
                        break;

                    case "joule":
                        output = inputValue * 1.356;
                        break;

                    case "kilojoule":
                        output = inputValue / 737.562;
                        break;

                    case "calorie":
                        output = inputValue / 3.086;
                        break;

                    case "kilocalorie":
                        output = inputValue / 3085.96;
                        break;

                    case "watt hour":
                        output = inputValue / 2655.224;
                        break;

                    case "kilowatt hour":
                        output = inputValue / 2.655e+6;
                        break;

                    case "electron-volt":
                        output = inputValue * 8.462e+18;
                        break;

                    case "british thermal unit":
                        output = inputValue / 778.169;
                        break;

                    case "therm":
                        output = inputValue / 7.78e+7;
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
