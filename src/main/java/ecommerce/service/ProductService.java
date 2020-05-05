package ecommerce.service;

import java.util.List;

import ecommerce.model.Product;

public interface ProductService {
	public void saveProduct(Product product);
	public List<Product> findAllProduct();
	public Product findProductById(Long id);
	public void deleteProductById(Long id);
}
