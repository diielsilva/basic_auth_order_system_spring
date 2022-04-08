package com.olix.stock_system.common.mapper;

import java.util.ArrayList;
import java.util.List;

import com.olix.stock_system.api.representation.input.SaveEntry;
import com.olix.stock_system.api.representation.input.SaveEntryItem;
import com.olix.stock_system.api.representation.input.SaveEntryItemProduct;
import com.olix.stock_system.api.representation.output.ShowEntry;
import com.olix.stock_system.api.representation.output.ShowEntryItem;
import com.olix.stock_system.domain.model.Entry;
import com.olix.stock_system.domain.model.EntryItem;
import com.olix.stock_system.domain.model.Product;

import org.springframework.stereotype.Component;

@Component
public class EntryMapper {

    public Product fromSaveEntryItemProductToProduct(SaveEntryItemProduct saveEntryItemProduct) {
        return new Product(saveEntryItemProduct.getId(), null, null);
    }

    public EntryItem fromSaveEntryItemToEntryItem(SaveEntryItem saveEntryItem) {
        Product product = fromSaveEntryItemProductToProduct(saveEntryItem.getSaveEntryItemProduct());
        return new EntryItem(null, saveEntryItem.getAmount(), null, product);
    }

    public List<EntryItem> fromSaveEntryItemListToEntryItemList(List<SaveEntryItem> saveEntryItems) {
        List<EntryItem> entryItems = new ArrayList<EntryItem>();
        for (SaveEntryItem saveEntryItem : saveEntryItems) {
            EntryItem entryItem = fromSaveEntryItemToEntryItem(saveEntryItem);
            entryItems.add(entryItem);
        }
        return entryItems;
    }

    public ShowEntryItem fromEntryItemToShowEntryItem(EntryItem entryItem, ProductMapper productMapper) {
        return new ShowEntryItem(entryItem.getId(), entryItem.getAmount(),
                productMapper.fromProductToShowProduct(entryItem.getProduct()));
    }

    public List<ShowEntryItem> fromEntryItemListToShowEntryItemList(List<EntryItem> entryItems,
            ProductMapper productMapper) {
        List<ShowEntryItem> showEntryItems = new ArrayList<>();
        for (EntryItem entryItem : entryItems) {
            ShowEntryItem showEntryItem = fromEntryItemToShowEntryItem(entryItem, productMapper);
            showEntryItems.add(showEntryItem);
        }
        return showEntryItems;
    }

    public Entry fromSaveEntryToEntry(SaveEntry saveEntry) {
        List<EntryItem> entryItems = fromSaveEntryItemListToEntryItemList(saveEntry.getEntryItems());
        return new Entry(null, null, entryItems);
    }

    public ShowEntry fromEntryToShowEntry(Entry entry, ProductMapper productMapper) {
        ShowEntry showEntry = new ShowEntry(entry.getId(), entry.getEntryDate());
        showEntry.setEntryItems(fromEntryItemListToShowEntryItemList(entry.getEntryItems(), productMapper));
        return showEntry;
    }

    public List<ShowEntry> fromEntryListToShowEntryList(List<Entry> entries, ProductMapper productMapper) {
        List<ShowEntry> showEntries = new ArrayList<ShowEntry>();
        for (Entry entry : entries) {
            ShowEntry showEntry = fromEntryToShowEntry(entry, productMapper);
            showEntries.add(showEntry);
        }
        return showEntries;
    }
}
