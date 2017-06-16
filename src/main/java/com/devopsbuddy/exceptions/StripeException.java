package com.devopsbuddy.exceptions;

import com.stripe.exception.AuthenticationException;

/**
 * Created by Donald F. Coffin on 6/15/17.
 **/
public class StripeException extends RuntimeException {

    public StripeException(Throwable e) {
        super(e);
    }
}
