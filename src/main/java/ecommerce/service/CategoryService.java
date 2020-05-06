package ecommerce.service;

import ecommerce.model.Category;

public interface CategoryService {
	public void saveCategory(Category category);
	public Iterable<Category> findAllCategory();
	public Category findCategoryById(Integer id);
	public void deleteCategoryById(Integer id);
}
