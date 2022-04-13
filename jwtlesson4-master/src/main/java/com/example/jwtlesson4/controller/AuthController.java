package com.example.jwtlesson4.controller;

import com.example.jwtlesson4.config.JwtProvider;
import com.example.jwtlesson4.payload.LoginDto;
import com.example.jwtlesson4.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

private final AuthService authService;
    @PostMapping("/login")
    public HttpEntity<?> login(@Valid @RequestBody LoginDto dto){

        ApiResponse apiResponse;
        try {
            Authentication authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

            User user = (User) authentication.getPrincipal();

            // kirgan odamga token berish kk
            String token = jwtProvider.generateToken(user.getUsername());

          apiResponse=  new ApiResponse("Your token : "+token,true,user);

        } catch (AuthenticationException e) {
           apiResponse =  new ApiResponse("Something went wrong",false);
        }


        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }



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
