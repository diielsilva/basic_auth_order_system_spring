package com.olix.stock_system.common.mapper;

import java.util.ArrayList;
import java.util.List;

import com.olix.stock_system.api.representation.input.SaveEntryItemProduct;
import com.olix.stock_system.api.representation.input.SaveProduct;
import com.olix.stock_system.api.representation.input.UpdateProduct;
import com.olix.stock_system.api.representation.output.ShowProduct;
import com.olix.stock_system.domain.model.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public Product fromSaveProductToProduct(SaveProduct saveProduct) {
		return new Product(null, saveProduct.getName(), null);
	}

	public ShowProduct fromProductToShowProduct(Product product) {
		return new ShowProduct(product.getId(), product.getName(), product.getAmount());
	}

	public Product fromUpdateProductToProduct(UpdateProduct updateProduct) {
		return new Product(null, updateProduct.getName(), null);
	}

	public Product fromSaveEntryItemProductToProduct(SaveEntryItemProduct saveEntryItemProduct) {
		return new Product(saveEntryItemProduct.getId(), null, null);
	}

	public List<ShowProduct> fromProductListToShowProductList(List<Product> productList) {
		List<ShowProduct> showProductList = new ArrayList<ShowProduct>();
		for (Product product : productList) {
			ShowProduct showProduct = fromProductToShowProduct(product);
			showProductList.add(showProduct);
		}
		return showProductList;
	}
}
