package overskyet.unicon.data;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public final class ExchangeRatesXmlParser {

    private static class ExchangeRatesXmlParserHolder {
        private final static ExchangeRatesXmlParser instance = new ExchangeRatesXmlParser();
    }

    public static ExchangeRatesXmlParser getInstance() {
        return ExchangeRatesXmlParserHolder.instance;
    }

    private ExchangeRatesXmlParser() { }

    private static final String TAG = ExchangeRatesXmlParser.class.getSimpleName();

    public ExchangeRates parseXml(InputStream is) {
        return parse(is);
    }

    private ExchangeRates parse(InputStream is) {

        List<String> currencies = new ArrayList<>();
        Map<String, Double> rates = new HashMap<>();
        String time = "";

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            Element element = doc.getDocumentElement();
            element.normalize();
            Node RootNode = doc.getElementsByTagName("Cube").item(0);
            NodeList nList = RootNode.getChildNodes();
            Node node = nList.item(1);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.hasAttributes()) {
                    time = node.getAttributes().getNamedItem("time").getNodeValue();
                }
                NodeList childNodeList = node.getChildNodes();
                for (int i = 0; i < childNodeList.getLength(); i++) {
                    if (childNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        Node childNode = childNodeList.item(i);
                        String attributeCurrency = childNode.getAttributes().getNamedItem("currency").getNodeValue();
                        String attributeRate = childNode.getAttributes().getNamedItem("rate").getNodeValue();
                        currencies.add(attributeCurrency);
                        rates.put(attributeCurrency, Double.valueOf(attributeRate));
                    }
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            Log.e(TAG, "parseXml: ", e);
            return null;
        }
        return new ExchangeRates(currencies, rates, time);
    }
}
