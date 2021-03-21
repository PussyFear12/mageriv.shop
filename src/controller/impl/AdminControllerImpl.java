package controller.impl;

import controller.AdminController;
import model.Person;
import model.Product;
import util.Logger;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Admin
 */
public class AdminControllerImpl implements AdminController {

    private static final String USER = "user";

    @Override
    public boolean addPerson(Person person, Map<String, Person> persons) {
        if (persons.isEmpty()) {
            persons = new HashMap<>();
            Logger.log("Users list created");
        }
        if (Objects.nonNull(person) && !persons.containsKey(person.getLogin())) {
            persons.put(person.getLogin(), person);

            Logger.log(USER + " [" + person.getLogin() + "] successfully saved at ["
                    + LocalDateTime.now().toString());
            return true;
        } else if (Objects.isNull(person)) {
            Logger.log("person data is null");
            return false;
        }
        Logger.log(USER + " [" + person.getLogin() + "] already registered");
        return false;
    }

    @Override
    public boolean removePerson(String login, Map<String, Person> persons) {
        if (persons.size() > 0) {
            persons.remove(login);

            Logger.log(USER + " [" + login + "] removed. [" + LocalDateTime.now().toString() + "]");
            return true;
        }
        Logger.log(USER + " [" + login + "] is not registered");
        return false;
    }

    @Override
    public boolean addProduct(Product product, Set<Product> products) {
        if (products.isEmpty()) {
            products = new HashSet<>();
        }
        if (Objects.nonNull(product) && !products.contains(product)) {
            products.add(product);

            Logger.log("Product [" + product.getUid() + "] saved");
            return true;
        }
        Logger.log("product not saved");
        return false;
    }

    @Override
    public boolean removeProduct(int uid, Set<Product> products) {
        products.removeIf((Product product) -> Objects.equals(uid, product.getUid()));

        Logger.log("product [" + uid +"] removed ну або нє хуй зна.");
        return products.stream().noneMatch(product -> uid == product.getUid());
    }
}
