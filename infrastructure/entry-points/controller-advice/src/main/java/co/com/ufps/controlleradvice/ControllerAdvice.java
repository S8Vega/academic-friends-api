package co.com.ufps.controlleradvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;


@RestControllerAdvice
@Log4j2
public class ControllerAdvice {

    private ResponseEntity<ErrorModel> processException(
            ErrorModel errorModel, Exception exception, HttpStatus status) {
        log.error(errorModel.toString());

        Arrays.stream(exception.getStackTrace())
                .filter(stackTraceElement -> stackTraceElement.getClassName().contains("ufps"))
                .forEach(log::error);

        return new ResponseEntity<>(errorModel, status);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorModel> exception(Exception exception) {
        ErrorModel errorModel = ErrorModel.builder()
                .code("ADC-666")
                .exception(exception.getClass().getName())
                .message(exception.getMessage())
                .build();
        return processException(errorModel, exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({UnsupportedJwtException.class, MissingRequestHeaderException.class,
            ExpiredJwtException.class, MalformedJwtException.class, SignatureException.class,
            java.security.SignatureException.class})
    public final ResponseEntity<ErrorModel> unauthorized(Exception exception) {
        ErrorModel errorModel = ErrorModel.builder()
                .code("ADC-601")
                .exception(exception.getClass().getName())
                .message(exception.getMessage())
                .build();
        return processException(errorModel, exception, HttpStatus.UNAUTHORIZED);
    }
}