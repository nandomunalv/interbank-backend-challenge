package com.interview.retobackendinterbank.app.service;

import com.interview.retobackendinterbank.app.model.dto.RequestCustomerDto;
import com.interview.retobackendinterbank.app.model.dto.ResponseCustomerDto;

public interface CustomerService {

    ResponseCustomerDto getCustomerByCode(String code);

    ResponseCustomerDto updateCustomer(Long id, RequestCustomerDto customerDto);

}
