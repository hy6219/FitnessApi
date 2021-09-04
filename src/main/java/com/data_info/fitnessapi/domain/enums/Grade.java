package com.data_info.fitnessapi.domain.enums;

public enum Grade {
    /*등급: 비고객회원, 고객회원,트레이너회원,사업자회원,관리자로 구분*/
    general("비고객회원"),
    member("고객회원"),
    trainer("트레이너회원"),
    ceo("사업자회원"),
    admin("관리자회원");

    private String value;

    Grade(String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }
}
