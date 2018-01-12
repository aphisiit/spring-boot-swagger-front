package com.swagger.front.service;

import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<String> getAllEmployee();
}
