package co.com.ufps.controlleradvice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorModel {
    private String code;
    @JsonIgnore
    private String exception;
    @JsonIgnore
    private String message;
}
