package service;

import java.util.List;
import model.CartItem;

public interface CartItemService {

    List<CartItem> search(String keyword);

    void delete(String id);

    CartItem get(int id);

    void insert(CartItem cartItem);

    List<CartItem> getAll();

    void edit(CartItem cartItem);
}
