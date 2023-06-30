package com.avega.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import com.avega.dao.ProductDao;
import com.avega.daoimpl.ProductDaoImpl;
import com.avega.dbutil.DBUtils;

import com.avega.pojo.Product;
import com.avega.service.ProductService;

public class ProductServiceImpl implements ProductService {
	static Connection connection = DBUtils.getConnection();
	PreparedStatement ps = null;
	Statement statement = null;
	static Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());
	
	ProductDao productDao = null;
	
	public ProductServiceImpl() {
		this.productDao = new ProductDaoImpl();
	}
	
	List<Product> products = new ArrayList<>();


	@Override
	public List<Product> findAllProducts() {
		return productDao.getAllProducts();
	}
	
	@Override
	public Product findProductByProductId(String productId) {
		return productDao.getProductByProductId(productId);
	}
	
	@Override
	public boolean createProduct(Product product) {
		return productDao.addProduct(product);
	}
	
	@Override
	public boolean removeProduct(Product product) {
		return productDao.deleteProduct(product);
	}
	
	@Override
	public boolean editProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public void uploadExceltoDb(Connection connection, String filePath) throws SQLException, Exception {
		productDao.uploadExceltoDb(connection, filePath);
		
	}

	@Override
	public void writeProductsToExcel(Connection connection, String filePath) throws SQLException, Exception {
		productDao.writeProductsToExcel(connection, filePath);
		
	}
}
