package com.example.demo.productPurchase.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Data
public class ResponsePayloadDto<T> {

    private T body;
    private String error;
    private int statusCode;

    public ResponsePayloadDto(T body, int statusCode, Optional<String> error) {
        this.body = body;
        this.statusCode = statusCode;
        this.error = error.orElse("");
    }

    public ResponsePayloadDto(T body, int statusCode) {
        this(body, statusCode, Optional.empty());
    }

    public ResponsePayloadDto(T body) {
        this(body, HttpStatus.OK.value());
    }

//    public ResponsePayloadDto(T body, String error, int statusCode) {
//        this(body, statusCode, Optional.of(error));
//    }

    public ResponsePayloadDto(T body, String error) {
        this(body, HttpStatus.BAD_REQUEST.value(), Optional.of(error));
    }

    public ResponseEntity<ResponsePayloadDto<T>> toResponseEntity() {
//        if (statusCode == HttpStatus.OK.value()) {
//            return ResponseEntity.ok(this);
//        } else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
//            return ResponseEntity.badRequest().body(this);
//        } else {
//            return new ResponseEntity<>(HttpStatus.valueOf(2))
//        }
        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);

        switch (httpStatus) {
            case OK: return ResponseEntity.ok(this);
            case BAD_REQUEST: return ResponseEntity.badRequest().body(this);
            default: return ResponseEntity.status(httpStatus).body(this);
        }
    }

    public  static <T> ResponsePayloadDto<T> of(T t, int statusCode, Optional<String> error) {
        return new ResponsePayloadDto<T>(t, statusCode, error);
    }

    public  static <T> ResponsePayloadDto<T> of(T t, int statusCode) {
        return new ResponsePayloadDto<T>(t, statusCode);
    }

    public  static <T> ResponsePayloadDto<T> of(T t, String error) {
        return new ResponsePayloadDto<T>(t, error);
    }

    public  static <T> ResponsePayloadDto<T> of(T t) {
        return new ResponsePayloadDto<T>(t);
    }
}
