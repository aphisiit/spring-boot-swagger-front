package com.swagger.front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("EmployeeService")
public class EmployeeServiceImpl extends RestService implements EmployeeService {

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
        return getResultString(url,entity);
    }

    public ResponseEntity<String> findOne(Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        String method = "";
        String url = "/employees/findOne/" + id;
        return getResultString(url,entity);
    }

    public ResponseEntity<String> findByFirstName(String firstName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        String method = "";
        String url = "/employees/findByFirstName?firstName=" + firstName;
        return getResultString(url,entity);
    }

    public ResponseEntity<String> findByLastName(String lastName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        String method = "";
        String url = "/employees/findByLastName?lastName=" + lastName;
        return getResultString(url,entity);
    }

}
