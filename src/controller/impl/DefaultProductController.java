package controller.impl;

import controller.ProductController;
import model.Product;
import service.ProductService;

import java.util.Objects;

/**
 * @author besko
 */
public class DefaultProductController implements ProductController {

    private ProductService productService;


    public DefaultProductController() {}

    public DefaultProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean addProduct(Product product) {
        if (Objects.nonNull(product)) {
            productService.addProduct(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeProduct(int uid) {
        if (uid >= 0) {
            productService.removeProduct(uid);
            return true;
        }
        return false;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
