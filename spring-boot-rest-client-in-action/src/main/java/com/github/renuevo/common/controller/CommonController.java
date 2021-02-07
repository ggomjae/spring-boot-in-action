package com.github.renuevo.common.controller;

import com.github.renuevo.common.ErrorResponse;
import com.github.renuevo.dto.PostRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @GetMapping("/get500")
    public ResponseEntity<ErrorResponse> getInternalError() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .errorCode("500")
                        .errorMessage("500 에러가 발생 했습니다")
                        .build()
                );
    }


    @GetMapping("/get400")
    public ResponseEntity<ErrorResponse> getBadrequestError() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .errorCode("400")
                        .errorMessage("400 에러가 발생 했습니다")
                        .build()
                );
    }

    @PostMapping("/post")
    public String postCommonResponse(@RequestBody PostRequest postRequest) {
        return postRequest.toString();
    }

    @GetMapping("/timeout")
    public String test(){
        return "test";
    }

}
