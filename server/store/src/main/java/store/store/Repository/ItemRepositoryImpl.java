package store.store.Repository;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import store.store.model.Item;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    @Value("${app.token}")
    private String token;

    @Value("${app.server}")
    private String server;

    public Item findOne(String id) {
        return new Item("1", "title");
    }

    public Object search(String str) {
        Object summary;
        try {
            ResponseEntity<Object> response = restClientHelper(str);
            summary = response.getBody();
            //ArrayList<Item> result = summary.getData();
            return summary;
        } catch (Exception e) {
            System.out.println("UNAUTHORIZED - check token");
            return getMockData();
        }
    }

    private Object getMockData() {
        Object summary;
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            summary = objectMapper.readValue(new File(getClass().getResource("MockItems.json").getFile()), Object.class);
            return summary;
        } catch (Exception readfile) {
            readfile.printStackTrace();
        }
        return null;
    }

    private ResponseEntity<Object> restClientHelper(String searchValue) {
        RestTemplate restTemplate = new RestTemplate();
        String url = server + "search?q=" + searchValue;
        System.out.println(url);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, prepareRequest(), Object.class);

        return responseEntity;

    }

    private HttpEntity<String> prepareRequest() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("Authorization", token);

        return new HttpEntity<String>("", headers);
    }

}