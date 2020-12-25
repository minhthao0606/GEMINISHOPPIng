package service;

import java.util.List;

import model.Product;

public interface ProductService {

    List<Product> seachByCategory(int cate_id);

    void edit(Product product);

    Product get(int id);

    List<Product> sortByCategory();

    List<Product> getAll();

    void delete(int id);

    List<Product> seachByName(String productName);

    void insert(Product product);

    List<Product> sortByName();

    List<Product> sortByPrice();

    List<Product> search(String username);

}
