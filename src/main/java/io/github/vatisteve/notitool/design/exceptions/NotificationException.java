package io.github.vatisteve.notitool.design.exceptions;

import java.io.Serial;

public class NotificationException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public NotificationException(String message) {
        super(message);
    }

}
