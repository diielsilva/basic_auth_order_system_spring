package com.olix.stock_system.api.representation.output;

public class ShowEntryItem {
    private Long id;
    private Long amount;
    private ShowProduct product;

    public ShowEntryItem() {

    }

    public ShowEntryItem(Long id, Long amount, ShowProduct product) {
        this.id = id;
        this.amount = amount;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public ShowProduct getProduct() {
        return product;
    }

    public void setProduct(ShowProduct product) {
        this.product = product;
    }

}
