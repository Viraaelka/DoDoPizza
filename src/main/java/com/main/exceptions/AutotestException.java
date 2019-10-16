package com.main.exceptions;

public class AutotestException extends  Error{
        /**
         *
         * @param e
         */
        public AutotestException(Throwable e){
            super(e);
        }

        /**
         *
         * @param message a {Link java.lang.String} object
         * @param e a {Link java.lang.Throwable} object
         */
        public AutotestException(String message, Throwable e){
            super(message, e);
        }

        /**
         *
         * @param message a {Link java.lang.String} object
         */
        public AutotestException(String message){
            super(message);
        }
    }