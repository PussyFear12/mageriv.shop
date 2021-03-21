package controller;

import model.Person;
import model.Product;

import java.util.Map;
import java.util.Set;

public interface AdminController {
    boolean addPerson(Person person, Map<String, Person> persons);

    boolean removePerson(String login, Map<String, Person> persons);

    boolean addProduct(Product product, Set<Product> products);

    boolean removeProduct(int uid, Set<Product> products);
}
