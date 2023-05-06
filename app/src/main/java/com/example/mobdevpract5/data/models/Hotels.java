package com.example.mobdevpract5.data.models;

import java.io.Serializable;

public class Hotels implements Serializable {
    private String value;
    public Hotels(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
