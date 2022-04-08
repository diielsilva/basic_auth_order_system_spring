package com.olix.stock_system.api.representation.input;

import javax.validation.constraints.NotNull;

public class SaveEntryItemProduct {
    @NotNull(message = "Product ID cannot be null")
    private Long id;

    public SaveEntryItemProduct() {

    }

    public SaveEntryItemProduct(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
