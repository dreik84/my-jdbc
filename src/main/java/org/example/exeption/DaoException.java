package org.example.exeption;

public class DaoException extends RuntimeException {
    public DaoException(Throwable e) {
        super(e);
    }
}
