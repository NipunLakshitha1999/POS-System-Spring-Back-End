package lk.ijse.spring.advicer;

import lk.ijse.spring.util.StandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExpetionHabdler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity handleExeption(RuntimeException ex){
        StandedResponse response=new StandedResponse(500,"ERRO",ex.getMessage());

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
