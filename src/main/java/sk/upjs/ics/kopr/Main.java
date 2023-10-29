package sk.upjs.ics.kopr;

import jakarta.xml.ws.Endpoint;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Source> metadata = new ArrayList<>();

        var wsdlSource = new StreamSource(DefaultThesesPort.class.getResourceAsStream("/theses.wsdl"));
        wsdlSource.setSystemId("https://kopr.ics.upjs.sk/theses.wsdl");
        metadata.add(wsdlSource);

        var xsdSource = new StreamSource(DefaultThesesPort.class.getResourceAsStream("/theses.xsd"));
        xsdSource.setSystemId("https://kopr.ics.upjs.sk/theses.xsd");
        metadata.add(xsdSource);

        var filter = new HashMap<String, Object>();
        filter.put(Endpoint.WSDL_SERVICE, new QName("https://kopr.ics.upjs.sk", "ThesesService"));
        filter.put(Endpoint.WSDL_PORT, new QName("https://kopr.ics.upjs.sk", "ThesesPort"));

        var endpoint = Endpoint.create(new DefaultThesesPort());
        endpoint.setProperties(filter);
        endpoint.setMetadata(metadata);
        endpoint.publish("http://localhost:8888/");
    }
}
