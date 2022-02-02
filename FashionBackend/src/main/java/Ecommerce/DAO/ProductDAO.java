package Ecommerce.DAO;

import java.util.List;

import Ecommerce.model.Product;



public interface ProductDAO {
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> listProducts();
	public Product getProduct(int productid);
}
