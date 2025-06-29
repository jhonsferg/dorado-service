package com.dorado.service.model.security;

public enum Role {
    ADMIN("Administrador"),
    MANAGER("Gerente"),
    CASHIER("Cajero"),
    COOK("Cocinero"),
    WAITER("Mesero");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
