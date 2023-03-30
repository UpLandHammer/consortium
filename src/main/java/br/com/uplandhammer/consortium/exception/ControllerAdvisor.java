package br.com.uplandhammer.consortium.exception;

import br.com.uplandhammer.consortium.http.domain.response.ResponsePadrao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GravarUsuarioException.class)
    public ResponseEntity<ResponsePadrao> handleUsuarioException(GravarUsuarioException exception, WebRequest request) {
        log.error("Erro ao Gravar Usuário {}", exception.getMessage());
        return ResponseEntity.badRequest().body(buildResponsePadrao(exception.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(BindingValidationException.class)
    public ResponseEntity<ResponsePadrao> handleBindingException(BindingValidationException exception, WebRequest webRequest) {
        log.error("Erro ao Gravar Usuário {}", exception.getMessage());
        return ResponseEntity.badRequest().body(buildResponsePadrao(getMessage(exception.getMessages()), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<ResponsePadrao> handleUsuarioException(UsuarioException exception) {
        log.error("Erro ao Buscar Usuário {}", exception.getMessage());
        return ResponseEntity.badRequest().body(buildResponsePadrao(exception.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(ParticipanteException.class)
    public ResponseEntity<ResponsePadrao> handleUsuarioException(ParticipanteException exception) {
        log.error("Erro ao gravar Participante {}", exception.getMessage());
        return ResponseEntity.badRequest().body(buildResponsePadrao(exception.getMessage(), HttpStatus.BAD_REQUEST));
    }

    private ResponsePadrao buildResponsePadrao(String message, HttpStatus httpStatus) {
        return ResponsePadrao.builder()
                .message(message)
                .httpStatus(httpStatus)
                .build();
    }

    private String getMessage(List<String> messages) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String k : messages) {
            stringBuilder.append(k);
        }
        return stringBuilder.toString();
    }
}
