package service.impl;

import java.io.File;
import java.util.List;

import dao.CartDao;
import dao.ProductDao;
import dao.UserDao;
import model.Cart;
import model.Product;
import model.User;
import service.CartService;
import service.ProductService;
import service.UserService;
import dao.impl.CartDaoImpl;

public class CartServiceImpl implements CartService {

    CartDao cartDao = new CartDaoImpl();

    @Override
    public List<Cart> search(String name) {
        return cartDao.search(name);
    }

    @Override
    public void delete(int id) {
        cartDao.delete(id);
    }

    @Override
    public void insert(Cart cart) {
        cartDao.insert(cart);

    }

    @Override
    public List<Cart> getAll() {
        return cartDao.getAll();
    }

    @Override
    public void edit(Cart newCart) {
        Cart oldCart = cartDao.get(newCart.getId());

        oldCart.setBuyDate(newCart.getBuyDate());
        oldCart.setBuyer(newCart.getBuyer());

        cartDao.edit(oldCart);

    }

    @Override
    public Cart get(int id) {
        return cartDao.get(id);
    }

}
