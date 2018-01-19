package com.swagger.front.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("EmployeeService")
public class EmployeeServiceImpl extends RestService implements EmployeeService {

    private Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @SuppressWarnings("All")
    @Override
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        super.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getAllEmployee(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        String method = "";
        String url = "/employees/findAllEmployee";
        try {
            return getResultString(url,entity);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public ResponseEntity<String> findOne(Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        String method = "";
        String url = "/employees/findOne/" + id;

        try {
            return getResultString(url,entity);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public ResponseEntity<String> findByFirstName(String firstName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        String method = "";
        String url = "/employees/findByFirstName?firstName=" + firstName;

        try {
            return getResultString(url,entity);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public ResponseEntity<String> findByLastName(String lastName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        String method = "";
        String url = "/employees/findByLastName?lastName=" + lastName;

        try {
            return getResultString(url,entity);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

}
