package com.swagger.front.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.*;

@Configuration
public abstract class RestService {
    @Value("${EngineServer}")
    protected String EngineServer;
    protected static Properties connectProperties = null;

    protected String webServicesString = "";
    protected String resultString = "";

    protected RestTemplate restTemplate;

    public abstract void setRestTemplate(RestTemplate restTemplate);


    public RestService () {
    }

    public String getWebServicesString() {
        return webServicesString;
    }

    public RestService  setWebServicesString(String webServicesString) {
        this.webServicesString = webServicesString;
        return this;
    }

    public String getResultString() {
        resultString = restTemplate.getForObject(getWebServicesString(), String.class);
        return resultString;
    }

    public String getResultString(String urlParam) {
        String url = this.EngineServer + urlParam;
        resultString = restTemplate.getForObject(url, String.class);
        return resultString;
    }

    public ResponseEntity<String> getResultStringAndSetUser(String urlParam) {

        String url = this.EngineServer +urlParam;
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("Content-Type", "application/json; charset=utf-8");
            HttpEntity<String> entity = new HttpEntity<String>("", headers);
            return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public String getResultString(String urlParam, String param) {
        String url = this.EngineServer + urlParam;
        return restTemplate.getForObject(url, String.class, param);
    }

    public ResponseEntity<String> getResultString(String urlParam, HttpEntity<String> entity) {
        String url = this.EngineServer + urlParam;
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<String> getResultByExchange(String urlParam) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Content-Type", "application/json; charset=utf-8");

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        String url = this.EngineServer + urlParam;
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public ResponseEntity<String> getResultStringByTypeHttpMethodAndBodyContent(String json, HttpMethod httpMethod, String url, RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Content-Type", "application/json; charset=utf-8");


        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        ResponseEntity<String> reponseEntity = restTemplate.exchange(url, httpMethod, entity, String.class);
        return reponseEntity;
    }

    public ResponseEntity<String> getResultStringByTypeHttpMethodAndBodyContent(HttpMethod httpMethod, String urlParam) {
        String url = this.EngineServer + urlParam;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Content-Type", "application/json; charset=utf-8");


        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        ResponseEntity<String> reponseEntity = restTemplate.exchange(url, httpMethod, entity, String.class);
        return reponseEntity;
    }


}
