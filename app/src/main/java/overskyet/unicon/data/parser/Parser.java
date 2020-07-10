package overskyet.unicon.data.parser;

import java.io.InputStream;

import overskyet.unicon.data.pojo.ExchangeRates;

public abstract class Parser {
    public abstract ExchangeRates parse(InputStream is);
}
