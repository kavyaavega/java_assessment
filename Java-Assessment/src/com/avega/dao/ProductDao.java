package com.avega.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.avega.pojo.Product;

public interface ProductDao {
	
	List<Product> getAllProducts();
	Product getProductByProductId(String productId) ;
	boolean addProduct(Product product);
	boolean deleteProduct(Product product);
	boolean updateProduct(Product product);
	public void uploadExceltoDb(Connection connection ,String filePath)throws SQLException,Exception;
	public void writeProductsToExcel(Connection connection ,String filePath)throws SQLException,Exception;


}
