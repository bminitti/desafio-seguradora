package br.com.acme.insurancequote.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
