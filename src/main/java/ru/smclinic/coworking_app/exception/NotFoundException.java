package ru.smclinic.coworking_app.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String text) {
        super(text + " not found");
    }
}
