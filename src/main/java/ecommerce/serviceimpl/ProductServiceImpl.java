package ecommerce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.Product;
import ecommerce.repository.ProductRepository;
import ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public void saveProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public Iterable<Product> findAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product findProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteProductById(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public List<Product> findProductByUserId(Integer id) {
		return productRepo.findProductByUserId(id);
	}

	@Override
	public Boolean isBuyerBuyProductById(Long productId, Integer orderById) {
		return productRepo.isBuyerBuyProductById(productId, orderById);
	}
}
