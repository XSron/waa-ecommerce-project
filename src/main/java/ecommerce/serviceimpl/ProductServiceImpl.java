package ecommerce.serviceimpl;

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
}