package dao;

import java.util.List;

import model.Cart;
import model.Category;

public interface CartDao {

    List<Cart> search(String name);

    void insert(Cart cart);

    void edit(Cart cart);

    Cart get(int id);

    void delete(int id);

    Cart get(String name);

    List<Cart> getAll();

}
