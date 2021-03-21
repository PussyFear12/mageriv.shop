package service.impl;

import model.Person;
import model.enums.Role;
import model.enums.UserStatus;
import service.PersonService;
import util.Logger;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Admin
 */
public class PersonServiceImpl implements PersonService {

    private static final String USER = "user";

    private Map<String, Person> persons;

    public PersonServiceImpl() {
        // default constructor
    }

    public Map<String, Person> getPersons() {
        return persons;
    }

    public void setPersons(Map<String, Person> persons) {
        this.persons = persons;
    }

    @Override
    public Person createPerson() {
        return Person.newPersonBuilder()
                .setLogin("example@gmail.com")
                .setName("John")
                .setAge(23)
                .setBalance(5000.0)
                .setPassword("11111")
                .setUserStatus(UserStatus.GUEST)
                .setRole(Role.CUSTOMER)
                .buildPerson();
    }

    @Override
    public boolean registerPerson(Person person) {
        if (persons.isEmpty()) {
            persons = new HashMap<>();
            Logger.logToConsole("Users list created");
        }
        if (Objects.nonNull(person) && !persons.containsKey(person.getLogin())) {
            persons.put(person.getLogin(), person);

            Logger.logToConsole(USER + " [" + person.getLogin() + "] successfully saved at ["
                    + LocalDateTime.now().toString());
            return true;
        } else if (Objects.isNull(person)) {
            Logger.logToConsole("User data is null");
            return false;
        }
        Logger.logToConsole(USER + " [" + person.getLogin() + "] already registered");
        return false;
    }

    @Override
    public boolean removePerson(String login) {
        if (persons.size() > 0) {
            persons.remove(login);

            Logger.logToConsole(USER + " [" + login + "] removed. [" + LocalDateTime.now().toString() + "]");
            return true;
        }
        Logger.logToConsole(USER + " [" + login + "] is not registered");
        return false;
    }

    @Override
    public boolean changePassword(String password, Person person) {
        if (UserStatus.AUTHORIZED.equals(person.getStatus())) {
            person.setPassword(password);
            return true;
        }
        return resetPasswordIfGuest(person);
    }

    public boolean resetPasswordIfGuest(Person person) {
        Scanner sc = new Scanner(System.in);
        Logger.logToConsole("Insert your last password : ");
        final String answer = sc.next();
        if (Objects.equals(person.getPassword(), answer)) {
            Logger.logToConsole("Enter your new password : ");

            final String newPassword = sc.next();
            person.setPassword(newPassword);
            Logger.logToConsole("Password changed.");
            Logger.logToFile("User account [ " + person.getLogin() + " ] password changed .");
            return true;
        }
        return false;
    }
}
