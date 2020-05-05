package ecommerce.service;

import java.util.List;

import ecommerce.model.Category;

public interface CategoryService {
	public void saveCategory(Category category);
	public List<Category> findAllCategory();
	public Category findCategoryById(Integer id);
	public void deleteCategoryById(Integer id);
}
