package hu.schonherz.homework.blog.core.repository;

import java.util.List;

import hu.schonherz.homework.blog.core.entitiy.Product;

public interface ProductDao {

	// Dao interface
	public List<Product> getAllProduct();

	public Product getProductById(int id);

	public Product getProductByName(String name);

	public void addProduct(String name, int price);

	public void addProduct(String name);

	public void deleteProductById(int id);

	public void updateProductName(int id, String newName);

	public void updateProductPrice(int id, int newPrice);

	public void getProductsByCall();
}
