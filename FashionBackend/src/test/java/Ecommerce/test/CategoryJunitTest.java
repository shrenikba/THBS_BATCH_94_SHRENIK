package Ecommerce.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import Ecommerce.DAO.CategoryDAO;
import Ecommerce.config.DBConfig;
import Ecommerce.model.Category;

public class CategoryJunitTest {
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

		context.scan("Ecommerce");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("Tshirts");
		category.setCategoryDesc("All variety of tshirts");
		
		assertTrue("problem in ading category", categoryDAO.addCategory(category));
	}
}
