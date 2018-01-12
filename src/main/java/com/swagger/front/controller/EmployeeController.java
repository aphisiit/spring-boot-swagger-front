package com.swagger.front.controller;

import com.swagger.front.service.EmployeeService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/findAll",produces = "text/html; charset=utf-8",headers = "Accept=application/json; charset=utf-8")
    public ResponseEntity<String> getAllEmployee(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");

        ResponseEntity<String> responseEntity = employeeService.getAllEmployee();

        return new ResponseEntity<String>(responseEntity.getBody(),headers, HttpStatus.OK);
    }

}
