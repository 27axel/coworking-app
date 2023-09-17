package ru.smclinic.coworking_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongValueException extends RuntimeException {
    public WrongValueException(LocalDateTime dateTime) {
        super("Wrong date booking: " + dateTime);
    }
}
