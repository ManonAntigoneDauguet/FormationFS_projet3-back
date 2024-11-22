package com.chatop.api.service.exception;

public class PictureUploadException extends RuntimeException {
    public PictureUploadException(String message) {
        super(message);
    }

    public PictureUploadException(String message, Throwable e) {
        super(message, e);
    }
}
