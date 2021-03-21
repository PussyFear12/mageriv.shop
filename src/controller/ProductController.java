package controller;

import model.Product;

public interface ProductController {
    boolean addProduct(Product product);

    boolean removeProduct(int uid);
}
