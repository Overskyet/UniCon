package overskyet.unicon;

final class AngleUnitsCalculation {

    static double convert(double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "gradian": {

                switch (itemName2) {

                    case "gradian":
                        output = inputValue;
                        break;

                    case "degree":
                        output = inputValue * 180 / 200;
                        break;

                    case "arcminute":
                        output = inputValue * 54;
                        break;

                    case "radian":
                        output = inputValue * Math.PI / 200;
                        break;

                    case "milliradian":
                        output = inputValue * (1000 * Math.PI) / 200;
                        break;

                    case "arcsecond":
                        output = inputValue * 3240;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "degree": {

                switch (itemName2) {

                    case "degree":
                        output = inputValue;
                        break;

                    case "gradian":
                        output = inputValue * 200 / 180;
                        break;

                    case "arcminute":
                        output = inputValue * 60;
                        break;

                    case "radian":
                        output = inputValue * Math.PI / 180;
                        break;

                    case "milliradian":
                        output = inputValue * (1000 * Math.PI) / 180;
                        break;

                    case "arcsecond":
                        output = inputValue * 3600;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "arcminute": {

                switch (itemName2) {

                    case "arcminute":
                        output = inputValue;
                        break;

                    case "gradian":
                        output = inputValue / 54;
                        break;

                    case "degree":
                        output = inputValue / 60;
                        break;

                    case "radian":
                        output = inputValue * Math.PI / (60 * 180);
                        break;

                    case "milliradian":
                        output = inputValue * (1000 * Math.PI) / (60 * 180);
                        break;

                    case "arcsecond":
                        output = inputValue * 60;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "radian": {

                switch (itemName2) {

                    case "radian":
                        output = inputValue;
                        break;

                    case "gradian":
                        output = inputValue * 200 / Math.PI;
                        break;

                    case "degree":
                        output = inputValue * 180 / Math.PI;
                        break;

                    case "arcminute":
                        output = inputValue * (60 * 180) / Math.PI;
                        break;

                    case "milliradian":
                        output = inputValue * 1000;
                        break;

                    case "arcsecond":
                        output = inputValue * (3600 * 180) / Math.PI;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "milliradian": {

                switch (itemName2) {

                    case "milliradian":
                        output = inputValue;
                        break;

                    case "gradian":
                        output = inputValue * 200 / (1000 * Math.PI);
                        break;

                    case "degree":
                        output = inputValue * 180 / (1000 * Math.PI);
                        break;

                    case "arcminute":
                        output = inputValue * (60 * 180) / (1000 * Math.PI);
                        break;

                    case "radian":
                        output = inputValue / 1000;
                        break;

                    case "arcsecond":
                        output = inputValue * (3600 * 180) / (1000 * Math.PI);
                        break;

                    default:
                        break;

                }
                break;
            }

            case "arcsecond": {

                switch (itemName2) {

                    case "arcsecond":
                        output = inputValue;
                        break;

                    case "gradian":
                        output = inputValue / 3240;
                        break;

                    case "degree":
                        output = inputValue / 3600;
                        break;

                    case "arcminute":
                        output = inputValue / 60;
                        break;

                    case "radian":
                        output = inputValue * Math.PI / (180 * 3600);
                        break;

                    case "milliradian":
                        output = inputValue * (1000 * Math.PI) / (180 * 3600);
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
