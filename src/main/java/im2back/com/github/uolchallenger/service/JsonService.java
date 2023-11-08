package im2back.com.github.uolchallenger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonService {

    private final String jsonUrl = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";
    private final RestTemplate restTemplate;

    public JsonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> fetchJsonData() {
        String jsonResponse = restTemplate.getForObject(jsonUrl, String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> codinomes = new ArrayList<>();

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            JsonNode vingadoresNode = jsonNode.get("vingadores");

            if (vingadoresNode.isArray()) {
                for (JsonNode vingador : vingadoresNode) {
                    String codinome = vingador.get("codinome").asText();
                    codinomes.add(codinome);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

     return codinomes;
    }
}
