package overskyet.unicon.data.parser;

import java.io.InputStream;

import overskyet.unicon.data.pojo.ExchangeRates;

interface Parser {
    ExchangeRates parse(InputStream is);
}
