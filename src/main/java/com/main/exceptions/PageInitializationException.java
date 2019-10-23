package com.main.exceptions;

public class PageInitializationException extends PageException{
    /**
     *
     * @param e
     */
    public PageInitializationException(Throwable e){
        super(e);
    }

    /**
     *
     * @param message a {Link java.lang.String} object
     * @param e a {Link java.lang.Throwable} object
     */
    public PageInitializationException(String message, Throwable e){
        super(message, e);
    }

    /**
     *
     * @param message a {Link java.lang.String} object
     */
    public PageInitializationException(String message){
        super(message);
    }
}
