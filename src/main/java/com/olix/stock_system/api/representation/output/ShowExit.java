package com.olix.stock_system.api.representation.output;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowExit {
    private Long id;
    private OffsetDateTime exitDate;
    private List<ShowExitItem> exitItems = new ArrayList<ShowExitItem>();

    public ShowExit() {

    }

    public ShowExit(Long id, OffsetDateTime exitDate, List<ShowExitItem> exitItems) {
        this.id = id;
        this.exitDate = exitDate;
        this.exitItems = exitItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(OffsetDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public List<ShowExitItem> getExitItems() {
        return exitItems;
    }

    public void setExitItems(List<ShowExitItem> exitItems) {
        this.exitItems = exitItems;
    }

}
