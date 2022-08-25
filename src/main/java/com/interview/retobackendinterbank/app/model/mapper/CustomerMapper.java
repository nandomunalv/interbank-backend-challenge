package com.interview.retobackendinterbank.app.model.mapper;

import com.interview.retobackendinterbank.app.model.dto.RequestCustomerDto;
import com.interview.retobackendinterbank.app.model.dto.ResponseCustomerDto;
import com.interview.retobackendinterbank.app.model.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    @Mapping(target = "codigoUnico", source = "code")
    @Mapping(target = "nombres", source = "names")
    @Mapping(target = "apellidos", source = "lastNames")
    @Mapping(target = "tipoDocumento", source = "documentType")
    @Mapping(target = "numeroDocumento", source = "documentNumber")
    ResponseCustomerDto toResponseDto(Customer entity);

}
