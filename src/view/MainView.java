package view;

import model.Person;
import model.Product;
import model.enums.Role;
import service.PersonService;
import service.ProductService;
import service.impl.PersonServiceImpl;
import service.impl.ProductServiceImpl;
import util.Admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

;

/**
 * @author besko
 */
public class MainView {
    private ProductsView productsView = new ProductsView();
    private Admin admin = new Admin();
    private PersonService personService = new PersonServiceImpl();
    private ProductService productService = new ProductServiceImpl();


    public static void main(String[] args) {
        MainView mw = new MainView();
        /*List<Person> persons = mw.showPersons();
        persons.forEach(System.out::println);*/


        mw.showProducts().forEach(System.out::println);




    }



    public List<Person> showPersons() {
        Person cashier = personService.createPerson();
        Person chief = personService.createPerson();
        Person adminPerson = personService.createPerson();
        Person customer = personService.createPerson();

        adminPerson.setRole(Role.ADMIN);
        chief.setRole(Role.ADMIN);
        cashier.setRole(Role.CASHIER);
        customer.setRole(Role.CUSTOMER);

        return new ArrayList<>(Arrays.asList(adminPerson, chief, cashier, customer));
    }
    public List<Product> showProducts() {
        Product bread0 = productService.createProduct();
        Product bread1 = productService.createProduct();
        Product bread2 = productService.createProduct();
        Product bread3 = productService.createProduct();
        Product bread4 = productService.createProduct();

        bread0.setCount(100);
        bread0.setPrice(50.0);
        bread0.setBrand("1");
        bread1.setBrand("2");
        bread2.setBrand("45");
        bread2.setPrice(150.0);
        bread4.setCount(20);
        bread3.setCount(21);

        return new ArrayList<>(Arrays.asList(bread0, bread1, bread2, bread3, bread4));
    }

    public ProductsView getProductsView() {
        return productsView;
    }

    public void setProductsView(ProductsView productsView) {
        this.productsView = productsView;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
