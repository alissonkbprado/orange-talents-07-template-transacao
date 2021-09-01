package br.com.zup_academy.alisson_prado.transacao.handler;

import br.com.zup_academy.alisson_prado.transacao.exception.ApiErroException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class HandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardizedError> handle(MethodArgumentNotValidException exception) {
        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
            mensagens.add(message);
        });

        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<StandardizedError> handle(BindException exception) {
        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String message = String.format("Campo %s %s", fieldError.getField(), fieldError.getDefaultMessage());
            mensagens.add(message);
        });
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(ApiErroException.class)
    public ResponseEntity<StandardizedError> handleApiErroException(ApiErroException apiErroException) {
        Collection<String> mensagens = new ArrayList<>();
        mensagens.add(apiErroException.getReason());

        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(apiErroException.getHttpStatus()).body(standardizedError);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<StandardizedError> handle(IllegalStateException exception){
        Collection<String> mensagens = new ArrayList<>();
        String message = String.format("Campo %s %s", exception.getLocalizedMessage(), "Formato de entrada de dados inválido");
        mensagens.add(message);
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardizedError> handle(HttpMessageNotReadableException exception){
        Collection<String> mensagens = new ArrayList<>();
        String message = String.format("Campo %s %s", exception.getLocalizedMessage(), "Corpo da requisição inválido");
        mensagens.add(message);
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardizedError> handle(IllegalArgumentException exception){
        Collection<String> mensagens = new ArrayList<>();
        String message = String.format("Campo %s", exception.getLocalizedMessage());
        mensagens.add(message);
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardizedError> handle(ConstraintViolationException exception){
        Collection<String> mensagens = new ArrayList<>();
        String message = String.format("Campo %s", exception.getLocalizedMessage());
        mensagens.add(message);
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardizedError> handle(HttpRequestMethodNotSupportedException exception){
        Collection<String> mensagens = new ArrayList<>();
        String message = String.format(exception.getLocalizedMessage());
        mensagens.add(message);
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(standardizedError);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<StandardizedError> handle(MissingServletRequestParameterException exception){
        Collection<String> mensagens = new ArrayList<>();
        String message = String.format("Campo %s ", exception.getLocalizedMessage());
        mensagens.add(message);
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<StandardizedError> handle(MissingPathVariableException exception){
        Collection<String> mensagens = new ArrayList<>();
        String message = String.format("Campo %s ", exception.getParameter().getParameter().getName() + " não foi enviado pela URL");
        mensagens.add(message);
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StandardizedError> handle(NullPointerException exception){
        Collection<String> mensagens = new ArrayList<>();
        String message = String.format(exception.getMessage());
        mensagens.add(message);
        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardizedError);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<StandardizedError> handleResponseStatusException(ResponseStatusException responseStatusException) {
        Collection<String> mensagens = new ArrayList<>();
        mensagens.add(responseStatusException.getReason());

        StandardizedError standardizedError = new StandardizedError(mensagens);
        return ResponseEntity.status(responseStatusException.getStatus()).body(standardizedError);
    }
}
