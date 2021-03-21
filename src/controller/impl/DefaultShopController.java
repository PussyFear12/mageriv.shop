package controller.impl;

import controller.ShopController;
import util.Logger;

/**
 * @author besko
 */
public class DefaultShopController implements ShopController {

    public DefaultShopController() {}

    @Override
    public Double calculateRest(Double price, Double total)
    {
        Double rest = total - price;
        Logger.logToFile("Total = " + total + " price = " + price + "/rest = " + rest);
        return rest;
    }

    @Override
    public Double calculateWithDiscount(Double price, Integer percent) {
        final Double discount = (price * percent) / 100;
        return price - discount;
    }
}
