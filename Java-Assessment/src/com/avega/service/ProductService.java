package com.avega.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.avega.pojo.Product;

public interface ProductService {
	
	List<Product> findAllProducts();
	Product findProductByProductId(String productId) ;
	boolean createProduct(Product product);
	boolean removeProduct(Product product);
	boolean editProduct(Product product);
	public void uploadExceltoDb(Connection connection ,String filePath)throws SQLException,Exception;
	public void writeProductsToExcel(Connection connection ,String filePath)throws SQLException,Exception;

}
