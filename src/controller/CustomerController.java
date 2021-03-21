package controller;

import model.Person;
import model.Product;
import model.ShopBalance;

import java.util.List;
import java.util.Map;

public interface CustomerController {
    boolean register(Person person, Map<String, Person> persons);
    boolean buyGoods(List<Product> products, Person person, ShopBalance shopBalance);
    boolean changePassword(String password, Person person);
}
