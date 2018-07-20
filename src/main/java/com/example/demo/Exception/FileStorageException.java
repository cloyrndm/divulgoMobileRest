package com.example.demo.Exception;

/**
 * Created by Cloie Andrea on 16/07/2018.
 */
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
