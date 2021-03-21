package view;

import controller.ProductController;
import model.Product;
import model.enums.Status;
import service.impl.ProductServiceImpl;
import util.Logger;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author besko
 */
public class ProductsView {

    public void hello() {
        Logger.logToConsole("Hello in first very cool bar in Austria");
    }
    public void menu(ProductController controller) {
        Set<Product> products = ((ProductServiceImpl)controller)
                                .getProducts()
                                .stream()
                                .filter(Objects::nonNull)
                                .filter(product -> Status.AVAILABLE.equals(product.getStatus()))
                                .collect(Collectors.toSet());

        products.forEach(System.out::println);
        getMenu(controller).forEach(System.out::println);
    }

    public Set<Product> getMenu(ProductController controller) {
        return ((ProductServiceImpl)controller)
                .getProducts()
                .stream()
                .filter(Objects::nonNull)
                .filter(product -> Status.AVAILABLE.equals(product.getStatus()))
                .filter(product -> product.getPrice() <= 50)
                .collect(Collectors.toSet());
    }


}
