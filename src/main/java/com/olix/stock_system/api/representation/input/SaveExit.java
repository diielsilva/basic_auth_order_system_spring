package com.olix.stock_system.api.representation.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class SaveExit {
    @NotEmpty(message = "Exit items cannot be empty or null")
    @Valid
    private List<SaveExitItem> exitItems;

    public SaveExit() {

    }

    public SaveExit(@NotEmpty(message = "Exit items cannot be empty or null") List<SaveExitItem> exitItems) {
        this.exitItems = exitItems;
    }

    public List<SaveExitItem> getExitItems() {
        return exitItems;
    }

    public void setExitItems(List<SaveExitItem> exitItems) {
        this.exitItems = exitItems;
    }

}
