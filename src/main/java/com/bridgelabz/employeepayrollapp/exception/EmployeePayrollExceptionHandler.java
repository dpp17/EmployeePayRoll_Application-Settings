package com.bridgelabz.employeepayrollapp.exception;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errorMessage = errorList.stream().map(data->data.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception Handling while REST API call", errorMessage);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeePayrollCustomException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollCustomException(EmployeePayrollCustomException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception Handling while REST API call", exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
        log.error("Invalid date format", exception);
        ResponseDTO responseDTO = new ResponseDTO("Should have date in format dd MM yyyy", exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeePayrollDepartmentNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollDepartmentNotFoundException(EmployeePayrollDepartmentNotFoundException exception){
        ResponseDTO responseDTO = new ResponseDTO("Invalid Department", exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
