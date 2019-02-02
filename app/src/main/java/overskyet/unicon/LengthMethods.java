package overskyet.unicon;

final class LengthMethods {

    static double convert (double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "kilometer": {

                switch (itemName2) {

                    case "kilometer":
                        output = inputValue;
                        break;

                    case "meter":
                        output = inputValue * 1000;
                        break;

                    case "centimeter":
                        output = inputValue * 100000;
                        break;

                    case "millimeter":
                        output = inputValue * 1e+6;
                        break;

                    case "micrometer":
                        output = inputValue * 1e+9;
                        break;

                    case "nanometer":
                        output = inputValue * 1e+12;
                        break;

                    case "mile":
                        output = inputValue / 1.609;
                        break;

                    case "yard":
                        output = inputValue * 1093.613;
                        break;

                    case "foot":
                        output = inputValue * 3280.84;
                        break;

                    case "inch":
                        output = inputValue * 39370.079;
                        break;

                    case "nautical mile":
                        output = inputValue / 1.852;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "meter": {

                switch (itemName2) {

                    case "meter":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue / 1000;
                        break;

                    case "centimeter":
                        output = inputValue * 100;
                        break;

                    case "millimeter":
                        output = inputValue * 1000;
                        break;

                    case "micrometer":
                        output = inputValue * 1e+6;
                        break;

                    case "nanometer":
                        output = inputValue * 1e+9;
                        break;

                    case "mile":
                        output = inputValue / 1609.344;
                        break;

                    case "yard":
                        output = inputValue * 1.094;
                        break;

                    case "foot":
                        output = inputValue * 3.281;
                        break;

                    case "inch":
                        output = inputValue * 39.37;
                        break;

                    case "nautical mile":
                        output = inputValue / 1852;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "centimeter": {

                switch (itemName2) {

                    case "centimeter":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue / 100000;
                        break;

                    case "meter":
                        output = inputValue / 100;
                        break;

                    case "millimeter":
                        output = inputValue * 10;
                        break;

                    case "micrometer":
                        output = inputValue * 10000;
                        break;

                    case "nanometer":
                        output = inputValue * 1e+7;
                        break;

                    case "mile":
                        output = inputValue / 160934.4;
                        break;

                    case "yard":
                        output = inputValue / 91.44;
                        break;

                    case "foot":
                        output = inputValue / 30.48;
                        break;

                    case "inch":
                        output = inputValue / 2.54;
                        break;

                    case "nautical mile":
                        output = inputValue / 185200;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "millimeter": {

                switch (itemName2) {

                    case "millimeter":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue / 1e+6;
                        break;

                    case "meter":
                        output = inputValue / 1000;
                        break;

                    case "centimeter":
                        output = inputValue / 10;
                        break;

                    case "micrometer":
                        output = inputValue * 1000;
                        break;

                    case "nanometer":
                        output = inputValue * 1e+6;
                        break;

                    case "mile":
                        output = inputValue / 1.609e+6;
                        break;

                    case "yard":
                        output = inputValue / 914.4;
                        break;

                    case "foot":
                        output = inputValue / 304.8;
                        break;

                    case "inch":
                        output = inputValue / 25.4;
                        break;

                    case "nautical mile":
                        output = inputValue / 1.852e+6;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "micrometer": {

                switch (itemName2) {

                    case "micrometer":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue / 1e+9;
                        break;

                    case "meter":
                        output = inputValue / 1e+6;
                        break;

                    case "centimeter":
                        output = inputValue / 10000;
                        break;

                    case "millimeter":
                        output = inputValue / 1000;
                        break;

                    case "nanometer":
                        output = inputValue * 1000;
                        break;

                    case "mile":
                        output = inputValue / 1.609e+9;
                        break;

                    case "yard":
                        output = inputValue / 914400;
                        break;

                    case "foot":
                        output = inputValue / 304800;
                        break;

                    case "inch":
                        output = inputValue / 25400;
                        break;

                    case "nautical mile":
                        output = inputValue / 1.852e+9;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "nanometer": {

                switch (itemName2) {

                    case "nanometer":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue / 1e+12;
                        break;

                    case "meter":
                        output = inputValue / 1e+9;
                        break;

                    case "centimeter":
                        output = inputValue / 1e+7;
                        break;

                    case "millimeter":
                        output = inputValue / 1e+6;
                        break;

                    case "micrometer":
                        output = inputValue / 1000;
                        break;

                    case "mile":
                        output = inputValue / 1.609e+12;
                        break;

                    case "yard":
                        output = inputValue / 9.144e+8;
                        break;

                    case "foot":
                        output = inputValue / 3.048e+8;
                        break;

                    case "inch":
                        output = inputValue / 2.54e+7;
                        break;

                    case "nautical mile":
                        output = inputValue / 1.852e+12;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "mile": {

                switch (itemName2) {

                    case "mile":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue * 1.609;
                        break;

                    case "meter":
                        output = inputValue * 1609.344;
                        break;

                    case "centimeter":
                        output = inputValue * 160934.4;
                        break;

                    case "millimeter":
                        output = inputValue * 1.609e+6;
                        break;

                    case "micrometer":
                        output = inputValue * 1.609e+9;
                        break;

                    case "nanometer":
                        output = inputValue * 1.609e+12;
                        break;

                    case "yard":
                        output = inputValue * 1760;
                        break;

                    case "foot":
                        output = inputValue * 5280;
                        break;

                    case "inch":
                        output = inputValue * 63360;
                        break;

                    case "nautical mile":
                        output = inputValue / 1.151;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "yard": {

                switch (itemName2) {

                    case "yard":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue / 1093.613;
                        break;

                    case "meter":
                        output = inputValue / 1.094;
                        break;

                    case "centimeter":
                        output = inputValue * 91.44;
                        break;

                    case "millimeter":
                        output = inputValue * 914.4;
                        break;

                    case "micrometer":
                        output = inputValue * 914400;
                        break;

                    case "nanometer":
                        output = inputValue * 9.144e+8;
                        break;

                    case "mile":
                        output = inputValue / 1760;
                        break;

                    case "foot":
                        output = inputValue * 3;
                        break;

                    case "inch":
                        output = inputValue * 36;
                        break;

                    case "nautical mile":
                        output = inputValue / 2025.372;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "foot": {

                switch (itemName2) {

                    case "foot":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue / 3280.84;
                        break;

                    case "meter":
                        output = inputValue / 3.281;
                        break;

                    case "centimeter":
                        output = inputValue * 30.48;
                        break;

                    case "millimeter":
                        output = inputValue * 304.8;
                        break;

                    case "micrometer":
                        output = inputValue * 304800;
                        break;

                    case "nanometer":
                        output = inputValue * 3.048e+8;
                        break;

                    case "mile":
                        output = inputValue / 5280;
                        break;

                    case "yard":
                        output = inputValue / 3;
                        break;

                    case "inch":
                        output = inputValue * 12;
                        break;

                    case "nautical mile":
                        output = inputValue / 6076.115;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "inch": {

                switch (itemName2) {

                    case "inch":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue / 39370.079;
                        break;

                    case "meter":
                        output = inputValue / 39.37;
                        break;

                    case "centimeter":
                        output = inputValue * 2.54;
                        break;

                    case "millimeter":
                        output = inputValue * 25.4;
                        break;

                    case "micrometer":
                        output = inputValue * 25400;
                        break;

                    case "nanometer":
                        output = inputValue * 2.54e+7;
                        break;

                    case "mile":
                        output = inputValue / 63360;
                        break;

                    case "yard":
                        output = inputValue / 36;
                        break;

                    case "foot":
                        output = inputValue / 12;
                        break;

                    case "nautical mile":
                        output = inputValue / 72913.386;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "nautical mile": {

                switch (itemName2) {

                    case "nautical mile":
                        output = inputValue;
                        break;

                    case "kilometer":
                        output = inputValue * 1.852;
                        break;

                    case "meter":
                        output = inputValue * 1852;
                        break;

                    case "centimeter":
                        output = inputValue * 185200;
                        break;

                    case "millimeter":
                        output = inputValue * 1.852e+6;
                        break;

                    case "micrometer":
                        output = inputValue * 1.852e+9;
                        break;

                    case "nanometer":
                        output = inputValue * 1.852e+12;
                        break;

                    case "mile":
                        output = inputValue * 1.151;
                        break;

                    case "yard":
                        output = inputValue * 2025.372;
                        break;

                    case "foot":
                        output = inputValue * 6076.115;
                        break;

                    case "inch":
                        output = inputValue * 72913.386;
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
