package com.avega.client;

import java.sql.SQLException;

import com.avega.dbutil.DBUtils;
import com.avega.pojo.Product;
import com.avega.service.ProductService;
import com.avega.serviceimpl.ProductServiceImpl;

public class ProductTestClient {

	public static void main(String[] args) throws SQLException, Exception {
		ProductService  productService = new ProductServiceImpl();
		//productService.findAllProducts().forEach(product-> System.out.println(product));
		
		//System.out.println(productService.findProductByProductId("PR001"));
		
		//System.out.println(productService.createProduct(new Product("PR004","fridge",250000,10)));
		
		//System.out.println(productService.editProduct(new Product("PR004","fridge",260000,10)));
		
		//System.out.println(productService.removeProduct(new Product("PR004","fridge",260000,10)));
		
		//7th qn uploadexceltodb
			/*String filepath="C:\\Demo\\kavya\\productDetails.xlsx";
			productService.uploadExceltoDb(DBUtils.getConnection(), filepath);*/
			
		//6th qn writeProductsToExcel
			String filepath="C:\\Demo\\kavya\\productDetails.xlsx";
			productService.writeProductsToExcel(DBUtils.getConnection(), filepath);

	}

}
