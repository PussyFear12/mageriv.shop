package service;

import model.Person;

/**
 * @author besko
 */
public interface PersonService {
    Person createPerson();
    boolean registerPerson(Person person);
    boolean changePassword(String password, Person person);
    boolean removePerson(String login);


}
