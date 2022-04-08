package com.olix.stock_system.api.representation.input;

import javax.validation.constraints.NotNull;

public class SaveExitItemProduct {
    @NotNull(message = "Product ID cannot be null")
    private Long id;

    public SaveExitItemProduct() {

    }

    public SaveExitItemProduct(@NotNull(message = "Product ID cannot be null") Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
