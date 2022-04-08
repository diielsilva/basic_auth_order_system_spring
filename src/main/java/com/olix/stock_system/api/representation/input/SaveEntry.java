package com.olix.stock_system.api.representation.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class SaveEntry {
    @NotEmpty(message = "Entry Items must null or empty")
    @Valid
    private List<SaveEntryItem> entryItems;

    public SaveEntry() {

    }

    public SaveEntry(@NotEmpty(message = "Entry Items must null or empty") @Valid List<SaveEntryItem> entryItems) {
        this.entryItems = entryItems;
    }

    public List<SaveEntryItem> getEntryItems() {
        return entryItems;
    }

    public void setEntryItems(List<SaveEntryItem> entryItems) {
        this.entryItems = entryItems;
    }

}
