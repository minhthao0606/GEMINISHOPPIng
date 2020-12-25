package dao;

import java.util.List;

import model.Category;

public interface CategoryDao {

    void insert(Category category);

    List<Category> search(String username);

    void delete(int id);

    void edit(Category category);

    Category get(int id);

    List<Category> getAll();

    Category get(String name);
}
