package overskyet.unicon.data.parser;

import androidx.annotation.Nullable;

public final class ParserFactoryImpl implements ParserFactory {

    private ParserFactoryImpl() {}

    private static class ParserFactoryImplHolder {
        private final static ParserFactoryImpl instance = new ParserFactoryImpl();
    }

    public static ParserFactoryImpl getInstance() { return ParserFactoryImplHolder.instance; }

    @Nullable
    @Override
    public Parser createParser(ParseType type) {
        switch (type) {
            case XML: return ExchangeRatesXmlParser.getInstance();
            // case JSON: return ExchangeRatesJsonParser.getInstance();
            default: return null;
        }
    }
}
