package overskyet.unicon;

final class TemperatureMethods {

    static double convert (double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "celsius": {

                switch (itemName2) {

                    case "celsius":
                        output = inputValue;
                        break;

                    case "fahrenheit":
                        output = (inputValue * (9.0 / 5.0)) + 32.0;
                        break;

                    case "kelvin":
                        output = inputValue + 273.15;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "fahrenheit": {

                switch (itemName2) {

                    case "fahrenheit":
                        output = inputValue;
                        break;

                    case "celsius":
                        output = (inputValue - 32.0) * (5.0 / 9.0);
                        break;

                    case "kelvin":
                        output = ((inputValue - 32.0) * (5.0 / 9.0)) + 273.15;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "kelvin": {

                switch (itemName2) {

                    case "kelvin":
                        output = inputValue;
                        break;

                    case "celsius":
                        output = inputValue - 273.15;
                        break;

                    case "fahrenheit":
                        output = (inputValue - 273.15) * (9.0 / 5.0) + 32;
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
