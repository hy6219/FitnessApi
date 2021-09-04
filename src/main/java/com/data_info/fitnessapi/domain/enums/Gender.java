package com.data_info.fitnessapi.domain.enums;

public enum Gender {
    MALE("남성"),
    FEMALE("여성");

    private String value;

    Gender(String value){
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }

}
