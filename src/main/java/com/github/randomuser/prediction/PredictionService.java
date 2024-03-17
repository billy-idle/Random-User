package com.github.randomuser.prediction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
class PredictionService {

    private final RestTemplate restTemplate;
    @Value("${agify.url}")
    private String url;
    @Value("${agify.response.error}")
    private String error ;

    public Map<String, Object> query() {
        Map<String, Object> responseMap;
        try {
            String response = restTemplate.getForObject(url, String.class);
            responseMap = JsonParserFactory.getJsonParser().parseMap(response);
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }

        log.info(Objects.requireNonNull(responseMap).toString());
        return responseMap;
    }
}
