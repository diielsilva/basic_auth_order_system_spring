package com.olix.stock_system.api.representation.output;

public class ShowExitItem {
    private Long id;
    private Long amount;
    private ShowProduct showProduct;

    public ShowExitItem() {

    }

    public ShowExitItem(Long id, Long amount, ShowProduct showProduct) {
        this.id = id;
        this.amount = amount;
        this.showProduct = showProduct;
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

    public ShowProduct getShowProduct() {
        return showProduct;
    }

    public void setShowProduct(ShowProduct showProduct) {
        this.showProduct = showProduct;
    }

}
