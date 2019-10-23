package com.main.exceptions;

public class PageException extends Exception{

    /**
     *
     * @param e
     */
    public PageException(Throwable e){
        super(e);
    }

    /**
     *
     * @param message a {Link java.lang.String} object
     * @param e a {Link java.lang.Throwable} object
     */
    public PageException(String message, Throwable e){
        super(message, e);
    }

    /**
     *
     * @param message a {Link java.lang.String} object
     */
    public PageException(String message){
        super(message);
    }

}
