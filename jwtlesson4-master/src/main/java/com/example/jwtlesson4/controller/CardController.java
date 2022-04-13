package com.example.jwtlesson4.controller;

import com.example.jwtlesson4.payload.CardDTO;
import com.example.jwtlesson4.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    // pul o'tqazish

    @PostMapping("/pay")
    public HttpEntity<?> pay(@Valid @RequestBody CardDTO dto){
        ApiResponse apiResponse = cardService.pay(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }


    @GetMapping("/incomeHistory")
        public HttpEntity<?> incomeHistory(){
        ApiResponse apiResponse = cardService.incomeHistory();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

     @GetMapping("/outcomeHistory")
        public HttpEntity<?> outcomeHistory(){
        ApiResponse apiResponse = cardService.outcomeHistory();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }




    // hamma o'zini income va outcomeni ko'ra olsin :















    // xatolik bo'lsa requiredlarni ko'rsatadi
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
