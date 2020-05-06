package ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.Category;
import ecommerce.repository.CategoryRepository;
import ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public void saveCategory(Category category) {
		categoryRepo.save(category);
	}

	@Override
	public Iterable<Category> findAllCategory() {
		return categoryRepo.findAll();
	}

	@Override
	public Category findCategoryById(Integer id) {
		return categoryRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteCategoryById(Integer id) {
		categoryRepo.deleteById(id);
	}
}
