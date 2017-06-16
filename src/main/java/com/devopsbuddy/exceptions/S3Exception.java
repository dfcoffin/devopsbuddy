package com.devopsbuddy.exceptions;

/**
 * Created by Donald F. Coffin on 6/15/17.
 **/
public class S3Exception extends RuntimeException {

    public S3Exception(Throwable e) {
        super(e);
    }

    public S3Exception(String s) {
        super(s);
    }
}
