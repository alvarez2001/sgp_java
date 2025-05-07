package com.diocesisdecarupano.sgp.modules.bank.domain.enums;

public enum BankType {
    Pago_Movil("Pago Movil"),
    Transferencia("Transferencia");

    private final String label;

    BankType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
