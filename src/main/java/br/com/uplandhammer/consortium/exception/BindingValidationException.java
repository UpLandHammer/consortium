package br.com.uplandhammer.consortium.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class BindingValidationException extends RuntimeException {

    private List<String> messages;

    public BindingValidationException(String message) {
        super(message);
    }

    public BindingValidationException(List<String> messages) {
        this.messages = messages;
    }
}
