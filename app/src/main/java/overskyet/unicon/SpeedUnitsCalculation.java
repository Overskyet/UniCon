package overskyet.unicon;

final class SpeedUnitsCalculation {

    static double convert(double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "kilometer per hour (km/h)": {

                switch (itemName2) {

                    case "kilometer per hour (km/h)":
                        output = inputValue;
                        break;

                    case "mile per hour (mi/h)":
                        output = inputValue / 1.609;
                        break;

                    case "meter per second (m/s)":
                        output = inputValue / 3.6;
                        break;

                    case "foot per second (ft/s)":
                        output = inputValue / 1.097;
                        break;

                    case "knot (kt)":
                        output = inputValue / 1.852;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "mile per hour (mi/h)": {

                switch (itemName2) {

                    case "mile per hour (mi/h)":
                        output = inputValue;
                        break;

                    case "kilometer per hour (km/h)":
                        output = inputValue * 1.609;
                        break;

                    case "meter per second (m/s)":
                        output = inputValue / 2.237;
                        break;

                    case "foot per second (ft/s)":
                        output = inputValue * 1.467;
                        break;

                    case "knot (kt)":
                        output = inputValue / 1.151;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "meter per second (m/s))": {

                switch (itemName2) {

                    case "meter per second (m/s)":
                        output = inputValue;
                        break;

                    case "kilometer per hour (km/h)":
                        output = inputValue * 3.6;
                        break;

                    case "mile per hour (mi/h)":
                        output = inputValue * 2.237;
                        break;

                    case "foot per second (ft/s)":
                        output = inputValue * 3.281;
                        break;

                    case "knot (kt)":
                        output = inputValue * 1.944;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "foot per second (ft/s)": {

                switch (itemName2) {

                    case "foot per second (ft/s)":
                        output = inputValue;
                        break;

                    case "kilometer per hour (km/h)":
                        output = inputValue * 1.097;
                        break;

                    case "mile per hour (mi/h)":
                        output = inputValue / 1.467;
                        break;

                    case "meter per second (m/s)":
                        output = inputValue / 3.281;
                        break;

                    case "knot (kt)":
                        output = inputValue / 1.688;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "knot (kt)": {

                switch (itemName2) {

                    case "knot (kt)":
                        output = inputValue;
                        break;

                    case "kilometer per hour (km/h)":
                        output = inputValue * 1.852;
                        break;

                    case "mile per hour (mi/h)":
                        output = inputValue * 1.151;
                        break;

                    case "meter per second (m/s)":
                        output = inputValue / 1.944;
                        break;

                    case "foot per second (ft/s)":
                        output = inputValue * 1.688;
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
