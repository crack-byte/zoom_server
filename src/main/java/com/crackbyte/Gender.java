package com.crackbyte;

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
