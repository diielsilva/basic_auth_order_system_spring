package com.olix.stock_system.common.mapper;

import java.util.ArrayList;
import java.util.List;

import com.olix.stock_system.api.representation.input.SaveExit;
import com.olix.stock_system.api.representation.input.SaveExitItem;
import com.olix.stock_system.api.representation.input.SaveExitItemProduct;
import com.olix.stock_system.api.representation.output.ShowExit;
import com.olix.stock_system.api.representation.output.ShowExitItem;
import com.olix.stock_system.api.representation.output.ShowProduct;
import com.olix.stock_system.domain.model.CustomExit;
import com.olix.stock_system.domain.model.ExitItem;
import com.olix.stock_system.domain.model.Product;

import org.springframework.stereotype.Component;

@Component
public class CustomExitMapper {

    public Product fromSaveExitItemProductToProduct(SaveExitItemProduct saveExitItemProduct) {
        return new Product(saveExitItemProduct.getId(), null, null);
    }

    public ExitItem fromSaveExitItemToExitItem(SaveExitItem saveExitItem) {
        Product product = fromSaveExitItemProductToProduct(saveExitItem.getSaveExitItemProduct());
        return new ExitItem(null, saveExitItem.getAmount(), null, product);
    }

    public List<ExitItem> fromSaveExitItemListToExitItemList(List<SaveExitItem> saveExitItems) {
        List<ExitItem> exitItems = new ArrayList<ExitItem>();
        for (SaveExitItem saveExitItem : saveExitItems) {
            ExitItem exitItem = fromSaveExitItemToExitItem(saveExitItem);
            exitItems.add(exitItem);
        }
        return exitItems;
    }

    public ShowExitItem fromExitItemToShowExitItem(ExitItem exitItem, ProductMapper productMapper) {
        ShowProduct showProduct = productMapper.fromProductToShowProduct(exitItem.getProduct());
        ShowExitItem showExitItem = new ShowExitItem(exitItem.getId(), exitItem.getAmount(), showProduct);
        return showExitItem;
    }

    public List<ShowExitItem> fromExitItemListToShowExitItemList(List<ExitItem> exitItems,
            ProductMapper productMapper) {
        List<ShowExitItem> showExitItems = new ArrayList<ShowExitItem>();
        for (ExitItem exitItem : exitItems) {
            ShowExitItem showExitItem = fromExitItemToShowExitItem(exitItem, productMapper);
            showExitItems.add(showExitItem);
        }
        return showExitItems;
    }

    public ShowExit fromCustomExitToShowExit(CustomExit customExit, ProductMapper productMapper) {
        ShowExit showExit = new ShowExit(customExit.getId(), customExit.getExitDate(),
                fromExitItemListToShowExitItemList(customExit.getExitItems(), productMapper));
        return showExit;
    }

    public List<ShowExit> fromCustomExitListToShowExitList(List<CustomExit> customExits, ProductMapper productMapper) {
        List<ShowExit> showExits = new ArrayList<ShowExit>();
        for (CustomExit customExit : customExits) {
            ShowExit showExit = fromCustomExitToShowExit(customExit, productMapper);
            showExits.add(showExit);
        }
        return showExits;
    }

    public CustomExit fromSaveExitToCustomExit(SaveExit saveExit) {
        List<ExitItem> exitItems = fromSaveExitItemListToExitItemList(saveExit.getExitItems());
        return new CustomExit(null, null, exitItems);
    }

}
