package com.diocesisdecarupano.sgp.modules.user.domain.enums;

public enum TypeUser {
    ADMIN((byte) 0),
    REQUESTED((byte) 1);

    private final byte code;

    TypeUser(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static TypeUser fromCode(byte code) {
        for (TypeUser state : values()) {
            if (state.code == code) return state;
        }
        throw new IllegalArgumentException("Invalid type: " + code);
    }
}
