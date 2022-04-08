package com.olix.stock_system.api.representation.output;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowEntry {
    private Long id;
    private OffsetDateTime entryDate;
    private List<ShowEntryItem> entryItems = new ArrayList<ShowEntryItem>();

    public ShowEntry() {

    }

    public ShowEntry(Long id, OffsetDateTime entryDate) {
        this.id = id;
        this.entryDate = entryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(OffsetDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public List<ShowEntryItem> getEntryItems() {
        return entryItems;
    }

    public void setEntryItems(List<ShowEntryItem> entryItems) {
        this.entryItems = entryItems;
    }

}
