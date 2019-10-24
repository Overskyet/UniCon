package overskyet.unicon;

final class PressureUnitsCalculation {
    static double convert (double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "standard atmosphere": {

                switch (itemName2) {

                    case "standard atmosphere":
                        output = inputValue;
                        break;

                    case "bar":
                        output = inputValue * 1.013;
                        break;

                    case "pascal":
                        output = inputValue * 101325;
                        break;

                    case "torr":
                        output = inputValue * 760;
                        break;

                    case "pound per square inch (psi)":
                        output = inputValue * 14.696;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "bar": {

                switch (itemName2) {

                    case "bar":
                        output = inputValue;
                        break;

                    case "standard atmosphere":
                        output = inputValue / 1.013;
                        break;

                    case "pascal":
                        output = inputValue * 100000;
                        break;

                    case "torr":
                        output = inputValue * 750.062;
                        break;

                    case "pound per square inch (psi)":
                        output = inputValue * 14.504;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "pascal": {

                switch (itemName2) {

                    case "pascal":
                        output = inputValue;
                        break;

                    case "standard atmosphere":
                        output = inputValue / 101325;
                        break;

                    case "bar":
                        output = inputValue / 100000;
                        break;

                    case "torr":
                        output = inputValue / 133.322;
                        break;

                    case "pound per square inch (psi)":
                        output = inputValue / 6894.757;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "torr": {

                switch (itemName2) {

                    case "torr":
                        output = inputValue;
                        break;

                    case "standard atmosphere":
                        output = inputValue / 760;
                        break;

                    case "bar":
                        output = inputValue / 750.062;
                        break;

                    case "pascal":
                        output = inputValue / 133.322;
                        break;

                    case "pound per square inch (psi)":
                        output = inputValue / 51.715;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "pound per square inch (psi)": {

                switch (itemName2) {

                    case "pound per square inch (psi)":
                        output = inputValue;
                        break;

                    case "standard atmosphere":
                        output = inputValue / 14.696;
                        break;

                    case "bar":
                        output = inputValue / 14.504;
                        break;

                    case "pascal":
                        output = inputValue / 6894.757;
                        break;

                    case "torr":
                        output = inputValue * 51.715;
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
