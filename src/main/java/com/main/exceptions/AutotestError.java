package com.main.exceptions;

public class AutotestError extends AssertionError{
        /**
         *
         * @param e
         */
        public AutotestError(Throwable e){
            super(e);
        }

        /**
         *
         * @param message a {Link java.lang.String} object
         * @param e a {Link java.lang.Throwable} object
         */
        public AutotestError(String message, Throwable e){
            super(message, e);
        }

        /**
         *
         * @param message a {Link java.lang.String} object
         */
        public AutotestError(String message){
            super(message);
        }
    }