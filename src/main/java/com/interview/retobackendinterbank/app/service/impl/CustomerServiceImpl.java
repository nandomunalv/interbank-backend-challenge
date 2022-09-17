package com.interview.retobackendinterbank.app.service.impl;

import com.interview.retobackendinterbank.app.config.ApiRequestException;
import com.interview.retobackendinterbank.app.model.dto.RequestCustomerDto;
import com.interview.retobackendinterbank.app.model.dto.ResponseCustomerDto;
import com.interview.retobackendinterbank.app.model.entity.Customer;
import com.interview.retobackendinterbank.app.model.mapper.CustomerMapper;
import com.interview.retobackendinterbank.app.repository.CustomerRepository;
import com.interview.retobackendinterbank.app.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseCustomerDto getCustomerByCode(String code) {
        Customer customer = repository.findOneByCode(code);
        return mapper.toResponseDto(customer);
    }

    @Override
    @Transactional
    public ResponseCustomerDto updateCustomer(Long id, RequestCustomerDto customerDto) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new ApiRequestException(String.format("No existe el cliente con id: %d", id)));
        customer.setNames(customerDto.getNombres());
        customer.setLastNames(customerDto.getApellidos());
        customer.setDocumentType(customerDto.getTipoDocumento());
        customer.setDocumentNumber(customerDto.getNumeroDocumento());

        repository.save(customer);

        return mapper.toResponseDto(customer);
    }

}
