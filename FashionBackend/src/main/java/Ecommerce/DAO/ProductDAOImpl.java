package Ecommerce.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Ecommerce.model.Category;
import Ecommerce.model.Product;

public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	@Override
	public boolean addProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		}

	@Override
	public boolean deleteProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e) {
			return false;
		}}

	@Override
	public boolean updateProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e) {
			return false;
		}}

	@Override
	public List<Product> listProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Products");
		List<Product> listProducts= query.list();
		session.close();
		return listProducts();
	}


	@Override
	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		Product product = session.get(Product.class, productId);		
		return product;
	}

}
