package com.demo.thirty;

import lombok.Getter;

/**
 * @Author: sw
 * @sidereal_csday: 2019-05-01 12:18
 * 枚举使用标准
 */
public enum CountryEnum {


    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏"),SEVEN(7,"秦");

    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index) {

        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element : myArray) {
            if(index == element.retCode) {
                return element;
            }
        }
        return null;
    }
}
