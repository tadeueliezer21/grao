package com.primo.grao.application.services.impl;

import org.apache.commons.logging.Log;

public abstract class AbstractLoggerService {

    public final Log log;

    protected AbstractLoggerService(Log log) {
        this.log = log;
    }

}
