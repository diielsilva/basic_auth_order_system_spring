package com.olix.stock_system.common.mapper;

import org.springframework.stereotype.Component;

@Component
public class ModelMapper {
	private CustomUserMapper customUserMapper;
	private ProductMapper productMapper;
	private EntryMapper entryMapper;
	private CustomExitMapper customExitMapper;

	public ModelMapper(CustomUserMapper customUserMapper, ProductMapper productMapper, EntryMapper entryMapper,
			CustomExitMapper customExitMapper) {
		this.customUserMapper = customUserMapper;
		this.productMapper = productMapper;
		this.entryMapper = entryMapper;
		this.customExitMapper = customExitMapper;
	}

	public CustomUserMapper getCustomUserMapper() {
		return customUserMapper;
	}

	public void setCustomUserMapper(CustomUserMapper customUserMapper) {
		this.customUserMapper = customUserMapper;
	}

	public ProductMapper getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	public EntryMapper getEntryMapper() {
		return entryMapper;
	}

	public void setEntryMapper(EntryMapper entryMapper) {
		this.entryMapper = entryMapper;
	}

	public CustomExitMapper getCustomExitMapper() {
		return customExitMapper;
	}

	public void setCustomExitMapper(CustomExitMapper customExitMapper) {
		this.customExitMapper = customExitMapper;
	}

}
