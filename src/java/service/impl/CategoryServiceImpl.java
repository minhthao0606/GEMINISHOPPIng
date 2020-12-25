package service.impl;

import java.util.List;

import dao.CategoryDao;
import model.Category;
import model.User;
import service.CategoryService;
import dao.impl.CategoryDaoImpl;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = (CategoryDao) new CategoryDaoImpl();

    @Override
    public void delete(int id) {
        categoryDao.delete(id);

    }

    @Override
    public void edit(Category newCategory) {
        Category oldCate = categoryDao.get(newCategory.getId());
        oldCate.setName(newCategory.getName());
        categoryDao.edit(oldCate);

    }

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);

    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> search(String username) {
        return categoryDao.search(username);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

}
