package com.crackbyte.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    M("Male"),
    F("Female"),
    O("Others");
    private String value;
}
