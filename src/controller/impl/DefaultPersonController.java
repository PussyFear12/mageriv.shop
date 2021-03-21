package controller.impl;

import controller.PersonController;
import model.Person;
import service.PersonService;

import java.util.Objects;

/**
 * @author besko
 */
public class DefaultPersonController implements PersonController {

    private PersonService personService;

    public DefaultPersonController() {}

    public DefaultPersonController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean registerPerson(Person person) {
        if (Objects.nonNull(person)) {
            personService.registerPerson(person);
            return true;
        }
        return false;
    }

    @Override
    public boolean changePassword(String password, Person person) {
        if (Objects.nonNull(person) && Objects.nonNull(password)) {
            personService.changePassword(password, person);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePerson(String login) {
        if (Objects.nonNull(login)) {
            personService.removePerson(login);
            return true;
        }
        return false;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
