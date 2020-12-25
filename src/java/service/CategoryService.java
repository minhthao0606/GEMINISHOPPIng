package service;

import java.util.List;
import model.Category;

public interface CategoryService {

    List<Category> search(String username);

    void delete(int id);

    Category get(int id);

    void insert(Category category);

    Category get(String name);

    List<Category> getAll();

    void edit(Category category);
}
