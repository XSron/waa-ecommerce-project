package ecommerce.service;

import ecommerce.model.Product;

public interface ProductService {
	public void saveProduct(Product product);
	public Iterable<Product> findAllProduct();
	public Product findProductById(Long id);
	public void deleteProductById(Long id);
}
