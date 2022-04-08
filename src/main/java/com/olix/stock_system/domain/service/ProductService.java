package com.olix.stock_system.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olix.stock_system.domain.exception.ModelNotFoundException;
import com.olix.stock_system.domain.exception.ProductNameInUseException;
import com.olix.stock_system.domain.model.Product;
import com.olix.stock_system.domain.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional
	public void save(Product product) {
		if (!canUseName(product.getName())) {
			throw new ProductNameInUseException();
		}
		product.setAmount(0L);
		this.productRepository.save(product);
	}

	public Product findById(Long id) {
		Optional<Product> databaseProduct = this.productRepository.findById(id);
		if (databaseProduct.isEmpty()) {
			throw new ModelNotFoundException("Product");
		}
		return databaseProduct.get();
	}

	@Transactional
	public void update(Long id, Product product) {
		Optional<Product> databaseProduct = this.productRepository.findById(id);
		if (databaseProduct.isEmpty()) {
			throw new ModelNotFoundException("Product");
		}
		product.setId(id);
		product.setAmount(databaseProduct.get().getAmount());
		this.productRepository.save(product);
	}

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	private Boolean canUseName(String name) {
		Boolean canUseName = true;
		Optional<Product> databaseProduct = this.productRepository.findByName(name);
		if (databaseProduct.isPresent()) {
			canUseName = false;
		}
		return canUseName;
	}

	@Transactional
	public void incrementAmount(Long id, Long amount) {
		Optional<Product> databaseProduct = this.productRepository.findById(id);
		if (databaseProduct.isEmpty()) {
			throw new ModelNotFoundException("Product");
		}
		databaseProduct.get().setAmount(databaseProduct.get().getAmount() + amount);
		this.productRepository.save(databaseProduct.get());
	}

	@Transactional
	public void decrementAmount(Long id, Long amount) {
		Optional<Product> databaseProduct = this.productRepository.findById(id);
		if (databaseProduct.isEmpty()) {
			throw new ModelNotFoundException("Product");
		}
		databaseProduct.get().setAmount(databaseProduct.get().getAmount() - amount);
		this.productRepository.save(databaseProduct.get());
	}
}
