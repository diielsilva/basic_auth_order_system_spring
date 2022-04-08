package com.olix.stock_system.api.representation.input;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaveEntryItem {
    @NotNull(message = "Amount cannot be null or empty")
    @Min(value = 1L, message = "Amount must be equals or bigger than 1")
    private Long amount;
    @NotNull(message = "Product cannot be null or empty")
    @Valid
    private SaveEntryItemProduct saveEntryItemProduct;

    public SaveEntryItem() {

    }

    public SaveEntryItem(Long amount, SaveEntryItemProduct saveEntryItemProduct) {
        this.amount = amount;
        this.saveEntryItemProduct = saveEntryItemProduct;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public SaveEntryItemProduct getSaveEntryItemProduct() {
        return saveEntryItemProduct;
    }

    public void setSaveEntryItemProduct(SaveEntryItemProduct saveEntryItemProduct) {
        this.saveEntryItemProduct = saveEntryItemProduct;
    }

}
