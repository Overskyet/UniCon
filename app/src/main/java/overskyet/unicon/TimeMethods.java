package overskyet.unicon;

final class TimeMethods {
    static double convert(double inputValue, String spinnerItemName, String spinner2ItemName) {

        double output = 0.0;
        String itemName1 = spinnerItemName.toLowerCase();
        String itemName2 = spinner2ItemName.toLowerCase();

        switch (itemName1) {

            case "nanosecond": {

                switch (itemName2) {

                    case "nanosecond":
                        output = inputValue;
                        break;

                    case "microsecond":
                        output = inputValue/ 1000;
                        break;

                    case "millisecond":
                        output = inputValue / 1e+6;
                        break;

                    case "second":
                        output = inputValue / 1e+9;
                        break;

                    case "minute":
                        output = inputValue / 6e+10;
                        break;

                    case "hour":
                        output = inputValue / 3.6e+12;
                        break;

                    case "day":
                        output = inputValue / 8.64e+13;
                        break;

                    case "week":
                        output = inputValue / 6.048e+14;
                        break;

                    case "month":
                        output = inputValue / 2.628e+15;
                        break;

                    case "year":
                        output = inputValue / 3.154e+16;
                        break;

                    case "decade":
                        output = inputValue / 3.154e+17;
                        break;

                    case "century":
                        output = inputValue / 3.154e+18;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "microsecond": {

                switch (itemName2) {

                    case "microsecond":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 1000;
                        break;

                    case "millisecond":
                        output = inputValue / 1000;
                        break;

                    case "second":
                        output = inputValue / 1e+6;
                        break;

                    case "minute":
                        output = inputValue / 6e+7;
                        break;

                    case "hour":
                        output = inputValue / 3.6e+9;
                        break;

                    case "day":
                        output = inputValue / 8.64e+10;
                        break;

                    case "week":
                        output = inputValue / 6.048e+11;
                        break;

                    case "month":
                        output = inputValue / 2.628e+12;
                        break;

                    case "year":
                        output = inputValue / 3.154e+13;
                        break;

                    case "decade":
                        output = inputValue / 3.154e+14;
                        break;

                    case "century":
                        output = inputValue / 3.154e+15;
                        break;

                    default:
                        break;

                }
                break;
            }

            case "millisecond": {

                switch (itemName2) {

                    case "millisecond":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 1e+6;
                        break;

                    case "microsecond":
                        output = inputValue * 1000;
                        break;

                    case "second":
                        output = inputValue / 1000;
                        break;

                    case "minute":
                        output = inputValue / 60000;
                        break;

                    case "hour":
                        output = inputValue / 3.6e+6;
                        break;

                    case "day":
                        output = inputValue / 8.64e+7;
                        break;

                    case "week":
                        output = inputValue / 6.048e+8;
                        break;

                    case "month":
                        output = inputValue / 2.628e+9;
                        break;

                    case "year":
                        output = inputValue / 3.154e+10;
                        break;

                    case "decade":
                        output = inputValue / 3.154e+11;
                        break;

                    case "century":
                        output = inputValue / 3.154e+12;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "second": {

                switch (itemName2) {

                    case "second":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 1e+9;
                        break;

                    case "microsecond":
                        output = inputValue * 1e+6;
                        break;

                    case "millisecond":
                        output = inputValue * 1000;
                        break;

                    case "minute":
                        output = inputValue / 60;
                        break;

                    case "hour":
                        output = inputValue / 3600;
                        break;

                    case "day":
                        output = inputValue / 86400;
                        break;

                    case "week":
                        output = inputValue / 604800;
                        break;

                    case "month":
                        output = inputValue / 2.628e+6;
                        break;

                    case "year":
                        output = inputValue / 3.154e+7;
                        break;

                    case "decade":
                        output = inputValue / 3.154e+8;
                        break;

                    case "century":
                        output = inputValue / 3.154e+9;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "minute": {

                switch (itemName2) {

                    case "minute":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 6e+10;
                        break;

                    case "microsecond":
                        output = inputValue * 6e+7;
                        break;

                    case "millisecond":
                        output = inputValue * 60000;
                        break;

                    case "second":
                        output = inputValue * 60;
                        break;

                    case "hour":
                        output = inputValue / 60;
                        break;

                    case "day":
                        output = inputValue / 1440;
                        break;

                    case "week":
                        output = inputValue / 10080;
                        break;

                    case "month":
                        output = inputValue / 43800.048;
                        break;

                    case "year":
                        output = inputValue / 525600;
                        break;

                    case "decade":
                        output = inputValue / 5.256e+6;
                        break;

                    case "century":
                        output = inputValue / 5.256e+7;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "hour": {

                switch (itemName2) {

                    case "hour":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 3.6e+12;
                        break;

                    case "microsecond":
                        output = inputValue * 3.6e+9;
                        break;

                    case "millisecond":
                        output = inputValue * 3.6e+6;
                        break;

                    case "second":
                        output = inputValue * 3600;
                        break;

                    case "minute":
                        output = inputValue * 60;
                        break;

                    case "day":
                        output = inputValue / 24;
                        break;

                    case "week":
                        output = inputValue / 168;
                        break;

                    case "month":
                        output = inputValue / 730.001;
                        break;

                    case "year":
                        output = inputValue / 8760;
                        break;

                    case "decade":
                        output = inputValue / 87600;
                        break;

                    case "century":
                        output = inputValue / 876000;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "day": {

                switch (itemName2) {

                    case "day":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 8.64e+13;
                        break;

                    case "microsecond":
                        output = inputValue * 8.64e+10;
                        break;

                    case "millisecond":
                        output = inputValue * 8.64e+7;
                        break;

                    case "second":
                        output = inputValue * 86400;
                        break;

                    case "minute":
                        output = inputValue * 1440;
                        break;

                    case "hour":
                        output = inputValue * 24;
                        break;

                    case "week":
                        output = inputValue / 7;
                        break;

                    case "month":
                        output = inputValue / 30.417;
                        break;

                    case "year":
                        output = inputValue / 365;
                        break;

                    case "decade":
                        output = inputValue / 3650;
                        break;

                    case "century":
                        output = inputValue / 36500;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "week": {

                switch (itemName2) {

                    case "week":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 6.048e+14;
                        break;

                    case "microsecond":
                        output = inputValue * 6.048e+11;
                        break;

                    case "millisecond":
                        output = inputValue * 6.048e+8;
                        break;

                    case "second":
                        output = inputValue * 604800;
                        break;

                    case "minute":
                        output = inputValue * 10080;
                        break;

                    case "hour":
                        output = inputValue * 168;
                        break;

                    case "day":
                        output = inputValue * 7;
                        break;

                    case "month":
                        output = inputValue / 4.345;
                        break;

                    case "year":
                        output = inputValue / 52.143;
                        break;

                    case "decade":
                        output = inputValue / 521.429;
                        break;

                    case "century":
                        output = inputValue / 5214.286;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "month": {

                switch (itemName2) {

                    case "month":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 2.628e+15;
                        break;

                    case "microsecond":
                        output = inputValue * 2.628e+12;
                        break;

                    case "millisecond":
                        output = inputValue * 2.628e+9;
                        break;

                    case "second":
                        output = inputValue * 2.628e+6;
                        break;

                    case "minute":
                        output = inputValue * 43800.048;
                        break;

                    case "hour":
                        output = inputValue * 730.001;
                        break;

                    case "day":
                        output = inputValue * 30.417;
                        break;

                    case "week":
                        output = inputValue * 4.345;
                        break;

                    case "year":
                        output = inputValue / 12;
                        break;

                    case "decade":
                        output = inputValue / 120;
                        break;

                    case "century":
                        output = inputValue / 1200.0;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "year": {

                switch (itemName2) {

                    case "year":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 3.154e+16;
                        break;

                    case "microsecond":
                        output = inputValue * 3.154e+13;
                        break;

                    case "millisecond":
                        output = inputValue * 3.154e+10;
                        break;

                    case "second":
                        output = inputValue * 3.154e+7;
                        break;

                    case "minute":
                        output = inputValue * 525600;
                        break;

                    case "hour":
                        output = inputValue * 8760;
                        break;

                    case "day":
                        output = inputValue * 365;
                        break;

                    case "week":
                        output = inputValue * 52.143;
                        break;

                    case "month":
                        output = inputValue * 12;
                        break;

                    case "decade":
                        output = inputValue / 10;
                        break;

                    case "century":
                        output = inputValue / 100;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "decade": {

                switch (itemName2) {

                    case "decade":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 3.154e+17;
                        break;

                    case "microsecond":
                        output = inputValue * 3.154e+14;
                        break;

                    case "millisecond":
                        output = inputValue * 3.154e+11;
                        break;

                    case "second":
                        output = inputValue * 3.154e+8;
                        break;

                    case "minute":
                        output = inputValue * 5.256e+6;
                        break;

                    case "hour":
                        output = inputValue * 87600;
                        break;

                    case "day":
                        output = inputValue * 3650;
                        break;

                    case "week":
                        output = inputValue * 521.429;
                        break;

                    case "month":
                        output = inputValue * 120;
                        break;

                    case "year":
                        output = inputValue * 10;
                        break;

                    case "century":
                        output = inputValue / 10;
                        break;

                    default:
                        break;
                }
                break;
            }

            case "century": {

                switch (itemName2) {

                    case "century":
                        output = inputValue;
                        break;

                    case "nanosecond":
                        output = inputValue * 3.154e+18;
                        break;

                    case "microsecond":
                        output = inputValue * 3.154e+15;
                        break;

                    case "millisecond":
                        output = inputValue * 3.154e+12;
                        break;

                    case "second":
                        output = inputValue * 3.154e+9;
                        break;

                    case "minute":
                        output = inputValue * 5.256e+7;
                        break;

                    case "hour":
                        output = inputValue * 876000;
                        break;

                    case "day":
                        output = inputValue * 36500;
                        break;

                    case "week":
                        output = inputValue * 5214.286;
                        break;

                    case "month":
                        output = inputValue * 1200.0;
                        break;

                    case "year":
                        output = inputValue * 100;
                        break;

                    case "decade":
                        output = inputValue * 10;
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
