package ecommerce.service;

import java.util.List;

import ecommerce.model.Product;

public interface ProductService {
	public void saveProduct(Product product);
	public Iterable<Product> findAllProduct();
	public List<Product> findProductByUserId(Integer id);
	public Product findProductById(Long id);
	public void deleteProductById(Long id);
	public Boolean isBuyerBuyProductById(Long productId, Integer orderById);
}
