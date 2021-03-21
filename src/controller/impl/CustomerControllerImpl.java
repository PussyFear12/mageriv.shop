package controller.impl;

import controller.CustomerController;
import model.Person;
import model.Product;
import model.ShopBalance;
import model.enums.UserStatus;
import payment.Payment;
import util.Logger;

import java.util.*;

/**
 * @author Admin
 */
public class CustomerControllerImpl implements CustomerController {
    @Override
    public boolean register(Person person, Map<String, Person> persons) {
        if (persons.isEmpty()) {
            persons = new HashMap<>();
        }
        if (Objects.nonNull(person)) {
            if (!persons.containsKey(person.getLogin())) {
                persons.put(person.getLogin(), person);
                Logger.log("User [" + person.getLogin() + "] registered.");
                return true;
            }
            if (persons.containsKey(person.getLogin())) {
                Logger.log("You`re already registered, please login.");
                return false;
            }
        }
        Logger.log("registration failed...");
        return false;
    }

    @Override
    public boolean buyGoods(List<Product> products, Person person, ShopBalance shopBalance) {
        Double sum = products.stream().mapToDouble(Product::getPrice).sum();

        if (sum <= person.getBalance()) {
            Payment.plusBalance(sum, shopBalance);
            Logger.log(sum + " - was added to balance.");
            return true;
        }
        Logger.log("Not enough money, operation declined...");
        return false;
    }

    @Override
    public boolean changePassword(String password, Person person) {
        if (UserStatus.AUTHORIZED.equals(person.getStatus())) {
            person.setPassword(password);
            return true;
        }
        return resetPasswordGuest(person);
    }

    public boolean resetPasswordGuest(Person person) {
        Scanner sc = new Scanner(System.in);
        Logger.log("Insert your last password : ");
        final String answer = sc.next();
        if (Objects.equals(person.getPassword(), answer)) {
            Logger.log("Enter your new password : ");
            final String newPassword = sc.next();
            person.setPassword(newPassword);
            Logger.log("Password changed.");
            return true;
        }
        return false;
    }
}
