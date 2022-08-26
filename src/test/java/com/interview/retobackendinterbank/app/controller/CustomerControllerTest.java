package com.interview.retobackendinterbank.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.retobackendinterbank.app.model.dto.RequestCustomerDto;
import com.interview.retobackendinterbank.app.model.dto.ResponseCustomerDto;
import com.interview.retobackendinterbank.app.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServiceImpl customerService;

    @Test
    public void shouldReturnResponseCustomerDtoFromService() throws Exception {
        Mockito.when(customerService.getCustomerByCode("abcde123")).thenReturn(getResponseCustomerDto());

        this.mockMvc.perform(get("/api/customer/abcde123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Test
    public void shouldReturnResponseCustomerDtoUpdatedFromService() throws Exception {
        Mockito.when(customerService.updateCustomer(1L, getRequestCustomerDto()))
                .thenReturn(getResponseCustomerDtoToUpdate());

        this.mockMvc.perform(put("/api/customer/1")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(convertToJson(getRequestCustomerDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(convertToJson(getResponseCustomerDtoToUpdate())));
    }

    private ResponseCustomerDto getResponseCustomerDto() {
        ResponseCustomerDto response = new ResponseCustomerDto();
        response.setId(1L);
        response.setCodigoUnico("abcde123");
        response.setNombres("Fernando");
        response.setApellidos("Muñoz Alvarez");
        response.setTipoDocumento("DNI");
        response.setNumeroDocumento("75068872");

        return response;
    }

    private RequestCustomerDto getRequestCustomerDto() {
        RequestCustomerDto request = new RequestCustomerDto();
        request.setCodigoUnico("abcde123");
        request.setNombres("Nando");
        request.setApellidos("Alvarez Muñoz");
        request.setTipoDocumento("DNI");
        request.setNumeroDocumento("75068872");

        return request;
    }

    private ResponseCustomerDto getResponseCustomerDtoToUpdate() {
        ResponseCustomerDto response = new ResponseCustomerDto();
        response.setId(1L);
        response.setCodigoUnico("abcde123");
        response.setNombres("Nando");
        response.setApellidos("Alvarez Muñoz");
        response.setTipoDocumento("DNI");
        response.setNumeroDocumento("75068872");

        return response;
    }

    private String convertToJson(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }
}
