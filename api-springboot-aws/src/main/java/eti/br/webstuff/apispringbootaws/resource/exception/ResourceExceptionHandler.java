package eti.br.webstuff.apispringbootaws.resource.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eti.br.webstuff.apispringbootaws.exceptions.GenericNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//FIXME: Responsável em detectar as excessões
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(GenericNotFoundException ex) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiError> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        String[] parts = ex.getMessage().split(":");
        String msg = parts[parts.length - 1].trim().toUpperCase();

        ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), msg, new Date());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.add(error.getDefaultMessage());
        });

        String defaultMessage = "Invalid field(s)";

        ApiErrorList error = new ApiErrorList(HttpStatus.BAD_REQUEST.value(), defaultMessage, new Date(), errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
