package service;

import java.util.List;
import model.Cart;

public interface CartService {

    List<Cart> search(String keyword);

    void edit(Cart newCart);

    Cart get(int id);

    List<Cart> getAll();

    void insert(Cart cart);

    void delete(int id);
}
