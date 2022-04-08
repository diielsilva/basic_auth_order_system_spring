package com.olix.stock_system.api.representation.input;

import javax.validation.constraints.NotBlank;

public class UpdateProduct {
    @NotBlank(message = "Name cannot be empty, null or blank")
    private String name;

    public UpdateProduct() {

    }

    public UpdateProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
