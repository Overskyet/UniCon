package overskyet.unicon.data.parser;

interface ParserFactory {
    Parser createParser(ParseType type);
}
