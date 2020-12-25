package service.impl;

import java.io.File;
import java.util.List;
import dao.ProductDao;
import dao.UserDao;
import model.Product;
import model.User;
import service.ProductService;
import service.UserService;
import dao.impl.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = (ProductDao) new ProductDaoImpl();

    @Override
    public List<Product> seachByName(String productName) {
        return productDao.seachByName(productName);
    }

    @Override
    public void edit(Product newProduct) {
        Product oldProduct = productDao.get(newProduct.getId());

        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCategory(newProduct.getCategory());
        if (newProduct.getImage() != null) { //add new picture
            String fileName = oldProduct.getImage();
            final String dir = "D:\\Code\\JavaWeb\\GEMINISHOPPING\\image";
            File file = new File(dir + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }

            oldProduct.setImage(newProduct.getImage());
        }

        productDao.edit(oldProduct);

    }

    @Override
    public void insert(Product product) {
        productDao.insert(product);

    }

    @Override
    public Product get(int id) {
        return productDao.get(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);

    }

    @Override
    public List<Product> search(String product) {
        return productDao.search(product);
    }

    @Override
    public List<Product> seachByCategory(int cate_id) {
        return productDao.seachByCategory(cate_id);
    }

    @Override
    public List<Product> sortByCategory() {
        return productDao.sortByCategory();
    }

    @Override
    public List<Product> sortByName() {
        return productDao.sortByName();
    }

    @Override
    public List<Product> sortByPrice() {
        return productDao.sortByPrice();
    }

}
