package com.olix.stock_system.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.olix.stock_system.api.representation.input.SaveProduct;
import com.olix.stock_system.api.representation.input.UpdateProduct;
import com.olix.stock_system.api.representation.output.ShowProduct;
import com.olix.stock_system.common.mapper.ModelMapper;
import com.olix.stock_system.domain.model.Product;
import com.olix.stock_system.domain.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	private ProductService productService;
	private ModelMapper modelMapper;

	public ProductController(ProductService productService, ModelMapper modelMapper) {
		this.productService = productService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid SaveProduct saveProduct) {
		Product product = this.modelMapper.getProductMapper().fromSaveProductToProduct(saveProduct);
		this.productService.save(product);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShowProduct> findById(@PathVariable Long id) {
		Product product = this.productService.findById(id);
		ShowProduct showProduct = this.modelMapper.getProductMapper().fromProductToShowProduct(product);
		return new ResponseEntity<ShowProduct>(showProduct, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ShowProduct>> findAll() {
		List<Product> productList = this.productService.findAll();
		List<ShowProduct> showProductList = this.modelMapper.getProductMapper()
				.fromProductListToShowProductList(productList);
		return new ResponseEntity<List<ShowProduct>>(showProductList, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid UpdateProduct updateProduct) {
		Product product = this.modelMapper.getProductMapper().fromUpdateProductToProduct(updateProduct);
		this.productService.update(id, product);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
