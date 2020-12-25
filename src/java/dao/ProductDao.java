package dao;

import java.util.List;

import model.Product;

public interface ProductDao {

    Product get(int id);

    List<Product> getAll();

    List<Product> sortByCategory();

    List<Product> sortByName();

    void delete(int id);

    void edit(Product product);

    void insert(Product product);

    List<Product> seachByCategory(int cate_id);

    List<Product> sortByPrice();

    List<Product> seachByName(String productName);

    List<Product> search(String username);
}
