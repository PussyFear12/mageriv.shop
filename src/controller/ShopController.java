package controller;

/**
 * @author besko
 */
public interface ShopController {
    Double calculateRest(Double price, Double total);
    Double calculateWithDiscount(Double price, Integer percent);
}
