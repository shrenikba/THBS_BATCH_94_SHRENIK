package Ecommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import Ecommerce.DAO.ProductDAO;
import Ecommerce.model.Product;


public class ProductJunitTestCase {

static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("Ecommerce");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		
	}
	
	@Test
	public void addCategoryTest() {
		Product product = new Product();
		product.setProductName("Tshirts");
		product.setProductDesc("All variety of tshirts");
		
		assertTrue("problem in ading category", productDAO.addProduct(product));
	}

}
