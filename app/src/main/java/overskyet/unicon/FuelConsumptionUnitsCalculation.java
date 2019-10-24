package overskyet.unicon;

final class FuelConsumptionUnitsCalculation {
    static double convert (double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "mile per gallon (us)": {

                switch (itemName2) {

                    case "mile per gallon (us)":
                        output = inputValue;
                        break;

                    case "mile per gallon (uk)":
                        output = inputValue * 1.201;
                        break;

                    case "kilometer per liter":
                        output = inputValue / 2.352;
                        break;

                    case "liter per 100 kilometers":
                        output = 235.215 / inputValue;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "mile per gallon (uk)": {

                switch (itemName2) {

                    case "mile per gallon (uk)":
                        output = inputValue;
                        break;

                    case "mile per gallon (us)":
                        output = inputValue / 1.201;
                        break;

                    case "kilometer per liter":
                        output = inputValue / 2.825;
                        break;

                    case "liter per 100 kilometers":
                        output = 282.481 / inputValue;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "kilometer per liter": {

                switch (itemName2) {

                    case "kilometer per liter":
                        output = inputValue;
                        break;

                    case "mile per gallon (us)":
                        output = inputValue * 2.352;
                        break;

                    case "mile per gallon (uk)":
                        output = inputValue * 2.825;
                        break;

                    case "liter per 100 kilometers":
                        output = 100 / inputValue;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "liter per 100 kilometers": {

                switch (itemName2) {

                    case "liter per 100 kilometers":
                        output = inputValue;
                        break;

                    case "mile per gallon (us)":
                        output = 235.215 / inputValue;
                        break;

                    case "mile per gallon (uk)":
                        output = 282.481 / inputValue;
                        break;

                    case "kilometer per liter":
                        output = 100 / inputValue;
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
