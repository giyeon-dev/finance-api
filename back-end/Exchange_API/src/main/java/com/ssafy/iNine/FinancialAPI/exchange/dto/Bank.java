package com.ssafy.iNine.FinancialAPI.exchange.dto;

public enum Bank {
    HANA("하나은행", "005"),
    WOORI("우리은행", "020"),
    KB("KB국민은행", "004"),
    SHINHAN("신한은행", "088"),
    NH("NH농협은행", "011"),
    IBK("기업은행", "003"),
    SC("SC제일은행", "023"),
    CITY("시티은행", "027"),
    SH("수협은행", "007"),
    BUSAN("부산은행", "032"),
    DGB("대구은행", "031"),
    JB("전북은행", "037"),
    BNK("경남은행", "039"),
    JEJU("제주은행", "035");


    private final String name;
    private final String code;

    Bank(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() { return name; }
    public String getCode() { return code; }

    public static String getNameByCode(String code) {
        for (Bank bank : Bank.values()) {
            if (bank.code.equals(code)) {
                return bank.name;
            }
        }
        return null;
    }
}
