package service.impl;

import model.Product;
import model.enums.Status;
import service.ProductService;
import util.Logger;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Admin
 */
public class ProductServiceImpl implements ProductService {

    private Set<Product> products;

    public ProductServiceImpl() {
        //default contructor;}
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public Product createProduct() {
        return Product.newProductBuilder()
                .setUid(1)
                .setBrand("Rolex")
                .setPrice(80.0)
                .setValue(180L)
                .setCount(20)
                .setStatus(Status.AVAILABLE)
                .buildProduct();
    }

    @Override
    public boolean addProduct(Product product) {
        if (products.isEmpty()) {
            products = new HashSet<>();
        }
        if (Objects.nonNull(product) && !products.contains(product)) {
            products.add(product);

            Logger.logToConsole("Product [" + product.getUid() + "] saved");
            return true;
        }
        Logger.logToConsole("product not saved");
        return false;
    }

    @Override
    public boolean removeProduct(int uid) {
        products.removeIf((Product product) -> Objects.equals(uid, product.getUid()));
        Logger.logToConsole("product [" + uid + "] removed ну або нє хуй зна.");
        return products.stream().noneMatch(product -> uid == product.getUid());
    }

}
