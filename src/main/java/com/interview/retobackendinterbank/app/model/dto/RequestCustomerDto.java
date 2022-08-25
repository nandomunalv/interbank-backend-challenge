package com.interview.retobackendinterbank.app.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestCustomerDto implements Serializable {

    @NotNull
    private String codigoUnico;

    @NotNull
    @NotBlank(message = "Los nombres son necesarios.")
    private String nombres;

    @NotNull
    @NotBlank(message = "Los apellidos son necesarios.")
    private String apellidos;

    @NotNull
    @NotBlank(message = "El tipo de documento es necesario.")
    @Size(min = 1, max = 3, message = "Solo se acepta el valor de DNI o CE.")
    private String tipoDocumento;

    @NotNull
    @NotBlank(message = "El número de documento es necesario.")
    @Size(min = 8, max = 11, message = "Solo se acepta entre 8 y 11 dígitos.")
    private String numeroDocumento;
}
