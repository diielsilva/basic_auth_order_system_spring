package com.olix.stock_system.api.representation.input;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaveExitItem {
    @NotNull(message = "Amount cannot be null")
    @Min(value = 1L, message = "Amout must be equals or bigger than 1")
    private Long amount;
    @NotNull
    @Valid
    private SaveExitItemProduct saveExitItemProduct;

    public SaveExitItem() {

    }

    public SaveExitItem(Long amount, SaveExitItemProduct saveEntryItemProduct) {
        this.amount = amount;
        this.saveExitItemProduct = saveEntryItemProduct;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public SaveExitItemProduct getSaveExitItemProduct() {
        return saveExitItemProduct;
    }

    public void setSaveExitItemProduct(SaveExitItemProduct saveExitItemProduct) {
        this.saveExitItemProduct = saveExitItemProduct;
    }

}
