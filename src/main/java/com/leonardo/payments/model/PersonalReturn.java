package com.leonardo.payments.model;

import java.util.Optional;

public class PersonalReturn {

    private Boolean sucess;
    private String message;

    private Optional<?> object;

    public PersonalReturn(Boolean sucess, String message, Optional<?> object) {
        this.sucess = sucess;
        this.message = message;
        this.object = object;
    }

    public PersonalReturn(Boolean sucess, String message) {
        this.sucess = sucess;
        this.message = message;
    }

    public Boolean getSucess() {
        return sucess;
    }

    public String getMessage() {
        return message;
    }

    public Optional<?> getObject() {
        return object;
    }
}
