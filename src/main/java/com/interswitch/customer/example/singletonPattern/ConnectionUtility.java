package com.interswitch.customer.example.singletonPattern;

public enum ConnectionUtility {
    INSTANCE;

    public String getValue(){
        return "This is a test Value";
    }
}
