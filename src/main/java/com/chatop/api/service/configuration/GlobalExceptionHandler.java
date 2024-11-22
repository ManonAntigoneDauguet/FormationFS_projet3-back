package com.chatop.api.service.configuration;

import com.chatop.api.service.exception.PictureUploadException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Allows to return at the user some precision on a bad request
     *
     * @param e as MethodArgumentNotValidException
     * @return ResponseEntity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Allows to avert the user that the picture could not be loaded
     *
     * @param e as PictureUploadException
     * @return ResponseEntity
     */
    @ExceptionHandler(PictureUploadException.class)
    public ResponseEntity<String> handleUploadPictureExceptions(PictureUploadException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Allows to avert the user when there is an unfound error
     *
     * @param e as EntityNotFoundException
     * @return ResponseEntity
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Allows to avert the user when there is an authentication error
     *
     * @param e as BadCredentialsException
     * @return ResponseEntity
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException e) {
        return new ResponseEntity<>("Bad correspondence between password and email", HttpStatus.UNAUTHORIZED);
    }

    /**
     * Allows to avert the user when there is an error when loading picture
     *
     * @param e as IOException
     * @return ResponseEntity
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleBadCredentialsException(IOException e) {
        if (e instanceof NoSuchFileException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested file does not exist.");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while processing the file.");
    }
}
