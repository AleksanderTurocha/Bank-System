package turocha.aleksander.banksystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import turocha.aleksander.banksystem.exceptions.custom.NotEnoughFundsException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NotEnoughFundsException.class})
    ResponseEntity<ExceptionResponse> handleNotFoundException(NotEnoughFundsException ex){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_ACCEPTABLE, ex.getLocalizedMessage());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_ACCEPTABLE);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap;
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(NotFoundException.class)
//    public Map<String,String> handleBusinessException(NotFoundException ex){
//        Map<String,String> errorMap = new HashMap<>();
//        errorMap.put("errorMessage",ex.getMessage());
//        return errorMap;
//    }

}
