package com.avega.daoimpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.avega.dao.ProductDao;
import com.avega.dbutil.DBUtils;
import com.avega.pojo.Product;

public class ProductDaoImpl implements ProductDao {
	
	static Logger logger = Logger.getLogger(DBUtils.class.getName());
    Connection connection = DBUtils.getConnection();
    PreparedStatement ps = null;

	@Override
	public List<Product> getAllProducts() {
		ResultSet rs = null;
		String query = "SELECT * FROM products";
		List<Product> products = new ArrayList<>();
		
		try {
			ps= connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				products.add(new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	@Override
	public Product getProductByProductId(String productId) {
		ResultSet rs = null;
	    String query = "SELECT * FROM products WHERE product_id = ?";
	    
	    try {
	        ps = connection.prepareStatement(query);
	         ps.setString(1, productId);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	        	Product productdb = new Product();
	        	productdb.setProductId(rs.getString("product_id"));
	        	productdb.setProductName(rs.getString("product_name"));
	        	productdb.setUnitPrice(rs.getInt("unit_price"));
	        	productdb.setQuantityOnHand(rs.getInt("quantity_on_hand"));
	        	return productdb;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return null;
	}

	@Override
	public boolean addProduct(Product product) {
		boolean isAdded = false;
		String query = "Insert into products Values(?,?,?,?)";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setDouble(3, product.getUnitPrice());
			ps.setInt(4, product.getQuantityOnHand());
			 int count = ps.executeUpdate();
	            if (count > 0) {
	                logger.info("Product added successfully!");
	                isAdded = true;
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteProduct(Product product) {
		boolean isDeleted = false;
		String query = "Delete from products WHERE product_id = ?";
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, product.getProductId());
			int count = ps.executeUpdate();
			if(count > 0) {
				logger.info("Product deleted successfully");
				isDeleted= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdate = false;
	    String query = "UPDATE products SET  product_name = ?,unit_price = ?,quantity_on_hand = ? Where product_id = ?";
	    try {
			ps = connection.prepareStatement(query);
			ps.setString(1,product.getProductName());
			ps.setDouble(2, product.getUnitPrice());
			ps.setInt(3, product.getQuantityOnHand());
			ps.setString(4, product.getProductId());
			
			int count = ps.executeUpdate();
			if(count> 0) {
				logger.info("Product updated successfully");
				isUpdate= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	return isUpdate;
	}

	@Override
	public void uploadExceltoDb(Connection connection, String filePath) throws SQLException, Exception {
		String query = "INSERT INTO products values(?, ?, ?,?)";
		ps = connection.prepareCall(query);
		List<Product> products = new ArrayList<>();
		try (FileInputStream fileIn = new FileInputStream(filePath)) {
		Workbook workbook = new XSSFWorkbook(fileIn);
		Sheet sheet = workbook.getSheetAt(0);
		
		
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			Row row = sheet.getRow(i);
			if(row!=null) {
				Product product = new Product();
				product.setProductId(row.getCell(0).getStringCellValue());
				product.setProductName(row.getCell(1).getStringCellValue());
				product.setUnitPrice((int)row.getCell(2).getNumericCellValue());
				product.setQuantityOnHand((int)row.getCell(3).getNumericCellValue());
				products.add(product);
			}
		}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		connection.setAutoCommit(false);
		products.forEach(e->{
			try {
				ps.setString(1, e.getProductId());
				ps.setString(2, e.getProductName());
				ps.setDouble(3, e.getUnitPrice());
				ps.setInt(4, e.getQuantityOnHand());
				ps.addBatch();
				
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		});	
		ps.executeBatch();
		connection.commit();
		
	}

	@Override
	public void writeProductsToExcel(Connection connection, String filePath) throws SQLException, Exception {
		String query = "SELECT * FROM products Where quantity_on_hand < 10 ";
		ResultSet rs = null;
		ps=connection.prepareStatement(query);
		rs =ps.executeQuery();
		FileInputStream fn = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fn);
		Sheet sheet = workbook.getSheetAt(0);
		int count=sheet.getLastRowNum();
		
		while(rs.next()) {
			Product product = new Product(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
			Row row = sheet.createRow(count + 1);
			row.createCell(0).setCellValue(product.getProductId());
			row.createCell(1).setCellValue(product.getProductName());
			row.createCell(2).setCellValue(product.getUnitPrice());
			row.createCell(3).setCellValue(product.getQuantityOnHand());
			count++;	
		}
		fn.close();
		
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			workbook.write(fileOut);
			fileOut.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
