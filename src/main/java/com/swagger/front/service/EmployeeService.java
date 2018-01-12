package com.swagger.front.service;

import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<String> getAllEmployee();
    ResponseEntity<String> findOne(Long id);
    ResponseEntity<String> findByFirstName(String firstName);
    ResponseEntity<String> findByLastName(String lastName);

}
