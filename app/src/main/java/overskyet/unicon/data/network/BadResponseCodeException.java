package overskyet.unicon.data.network;

public class BadResponseCodeException extends Exception {
    public BadResponseCodeException() {}
    public BadResponseCodeException(String responseCode) { super(responseCode); }
}
