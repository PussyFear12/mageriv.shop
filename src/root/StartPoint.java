package root;


import controller.impl.CustomerControllerImpl;
import model.Person;
import model.Product;
import model.ShopBalance;
import model.enums.Role;
import model.enums.Status;
import model.enums.UserStatus;

import java.util.*;

/**
 * @author Admin
 */
public class StartPoint {

    ShopBalance shopBalance = new ShopBalance();
    Set<Product> products = new HashSet<>();

    public static void main(String[] args) {
        initProducts().forEach(System.out::println);

        CustomerControllerImpl customerController = new CustomerControllerImpl();
        Person person1 = Person.newPersonBuilder()
                .setLogin("Lolka@gmail.com")
                .setAge(25)
                .setName("John")
                .setBalance(56000.0)
                .setRole(Role.CUSTOMER)
                .setPassword("1111")
                .setUserStatus(UserStatus.AUTHORIZED)
                .buildPerson();

        Map<String, Person> personMap = initPersons();

        System.out.println(customerController.register(person1, personMap));

        System.out.println(customerController.register(person1, personMap));

    }

    public static Map<String, Person> initPersons() {
        return new HashMap<>().put(Person.newPersonBuilder()
                .setLogin("Lolka@gmail.com")
                .setAge(25)
                .setName("John")
                .setBalance(56000.0)
                .setRole(Role.CUSTOMER)
                .setPassword("1111")
                .setUserStatus(UserStatus.AUTHORIZED)
                .buildPerson());
    }

    public static Set<Product> initProducts() {
        Product product1 = Product.newProductBuilder()
                .setUID(1)
                .setBrand("Bosch")
                .setValue(30L)
                .setPrice(499.95)
                .setStatus(Status.AVAILABLE)
                .setCount(5).buildProduct();
        Product product2 = Product.newProductBuilder().setUID(1)
                .setBrand("Munck")
                .setValue(304L)
                .setPrice(4929.95)
                .setStatus(Status.AVAILABLE)
                .setCount(900).buildProduct();
        Product product3 = Product.newProductBuilder().setUID(1)
                .setBrand("Borshch")
                .setValue(3L)
                .setPrice(9.95)
                .setStatus(Status.AVAILABLE)
                .setCount(2).buildProduct();

        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        return products;
    }


}

