package dao;

import java.util.List;

import model.Cart;
import model.CartItem;
import model.Category;

public interface CartItemDao {

    List<CartItem> getAll();

    void edit(CartItem cartItem);

    void delete(String id);

    List<CartItem> search(String name);

    void insert(CartItem cartItem);

    CartItem get(String name);

    CartItem get(int id);

}
