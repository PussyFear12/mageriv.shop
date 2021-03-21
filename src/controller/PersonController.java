package controller;

import model.Person;

public interface PersonController {
    boolean registerPerson(Person person);
    boolean changePassword(String password, Person person);
    boolean removePerson(String login);
}
