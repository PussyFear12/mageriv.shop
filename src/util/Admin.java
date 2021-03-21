package util;

import controller.PersonController;
import controller.ProductController;
import controller.ShopController;
import controller.impl.DefaultPersonController;
import controller.impl.DefaultProductController;
import controller.impl.DefaultShopController;
import model.Person;
import model.Product;
import payment.impl.PaymentServiceImpl;

/**
 * @author besko
 */
public class Admin implements PersonController, ProductController, ShopController {

    private PersonController personController;
    private ProductController productController;
    private ShopController shopController;
    private PaymentServiceImpl paymentServiceImpl;

    public Admin() {}

    public Admin(PersonController personController,
                 ProductController productController,
                 ShopController shopController,
                 PaymentServiceImpl paymentServiceImpl) {
        this.personController = personController;
        this.productController = productController;
        this.shopController = shopController;
        this.paymentServiceImpl = paymentServiceImpl;
    }

    @Override
    public Double calculateRest(Double price, Double total) {
        return ((DefaultShopController) shopController).calculateRest(price, total);
    }

    @Override
    public Double calculateWithDiscount(Double price, Integer percent) {
        return ((DefaultShopController) shopController).calculateWithDiscount(price, percent);
    }


    public Person createPerson() {
        return ((DefaultPersonController) personController).getPersonService().createPerson();
    }

    @Override
    public boolean registerPerson(Person person) {
        return ((DefaultPersonController) personController).registerPerson(person);
    }

    @Override
    public boolean changePassword(String password, Person person) {
        return ((DefaultPersonController) personController).changePassword(password, person);
    }

    @Override
    public boolean removePerson(String login) {
        return ((DefaultPersonController) personController).removePerson(login);
    }


    public Product createProduct() {
        return ((DefaultProductController) productController).getProductService().createProduct();
    }

    @Override
    public boolean addProduct(Product product) {
        return ((DefaultProductController) productController).addProduct(product);
    }

    @Override
    public boolean removeProduct(int uid) {
        return ((DefaultProductController) productController).removeProduct(uid);
    }

    public PersonController getPersonController() {
        return personController;
    }

    public void setPersonController(PersonController personController) {
        this.personController = personController;
    }

    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public ShopController getShopController() {
        return shopController;
    }

    public void setShopController(ShopController shopController) {
        this.shopController = shopController;
    }
}
