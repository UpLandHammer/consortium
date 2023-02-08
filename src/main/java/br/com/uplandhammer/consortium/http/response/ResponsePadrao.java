package br.com.uplandhammer.consortium.http.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ResponsePadrao {

    private String message;
    private HttpStatus httpStatus;
}
