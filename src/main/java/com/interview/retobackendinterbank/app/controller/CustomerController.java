package com.interview.retobackendinterbank.app.controller;

import com.interview.retobackendinterbank.app.config.ResourceNotFoundException;
import com.interview.retobackendinterbank.app.model.dto.RequestCustomerDto;
import com.interview.retobackendinterbank.app.model.dto.ResponseCustomerDto;
import com.interview.retobackendinterbank.app.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(value = "/customer/{code}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public ResponseEntity<ResponseCustomerDto> getSimpleCustomerByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(service.getCustomerByCode(code));
    }

    @PutMapping(value = "/customer/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public ResponseEntity<ResponseCustomerDto> updateCustomer(@PathVariable("id") Long id,
                                                              @Valid @RequestBody RequestCustomerDto customerDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateCustomer(id, customerDto));
    }

}
