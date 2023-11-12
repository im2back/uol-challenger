package im2back.com.github.uolchallenger.service;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Service
public class XmlService {
	 private final String apiUrl = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";
	 
	    private final RestTemplate restTemplate;
	    
	    public XmlService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    
	    public List<String> getCodinomesDaLigaDaJustica() {
	    	var xml = restTemplate.getForObject(apiUrl, String.class);
	    		List<String> codinomes = parseXmlToList(xml);
	    			return codinomes;
	    }
	    
	    
	    public static List<String> parseXmlToList(String xml) {
	    	
	        List<String> codinomes = new ArrayList<>();
	        
	        try {
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document document = builder.parse(new InputSource(new StringReader(xml)));

	            NodeList codinomeNodes = document.getElementsByTagName("codinome");

	            for (int i = 0; i < codinomeNodes.getLength(); i++) {
	                Node node = codinomeNodes.item(i);
	                if (node.getNodeType() == Node.ELEMENT_NODE) {
	                    Element element = (Element) node;
	                    String codinome = element.getTextContent();
	                    codinomes.add(codinome);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return codinomes;
	    }
	    
	   
	    
	
	    
}
	
	






