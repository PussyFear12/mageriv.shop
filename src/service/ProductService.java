package service;

import model.Product;

import java.util.Set;

/**
 * @author besko
 */
public interface ProductService {
    Product createProduct();

    boolean addProduct(Product product);

    boolean removeProduct(int uid);

}
