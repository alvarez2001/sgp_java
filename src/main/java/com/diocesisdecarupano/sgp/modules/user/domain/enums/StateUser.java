package com.diocesisdecarupano.sgp.modules.user.domain.enums;

public enum StateUser {
    ACTIVE((byte) 0),
    INACTIVE((byte) 1);

    private final byte code;

    StateUser(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public static StateUser fromCode(byte code) {
        for (StateUser state : values()) {
            if (state.code == code) return state;
        }
        throw new IllegalArgumentException("Invalid state: " + code);
    }
}
