package model;

import model.enums.Role;
import model.enums.UserStatus;

import java.util.Objects;

/**
 * @author Admin
 */
public class Person {
    private String login;
    private String name;
    private int age;
    private String password;
    private Role role;
    private Double balance;
    private UserStatus status;

    private Person() { }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && Objects.equals(login, person.login)
                && Objects.equals(name, person.name)
                && Objects.equals(password, person.password) && role == person.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, age, password, role);
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password=" + password.hashCode() +
                ", role=" + role.toString() +
                ", balance=" + balance +
                ", status=" + status.toString() +
                '}';
    }

    public static PersonBuilder newPersonBuilder() {
        return new Person().new PersonBuilder();
    }

    public class PersonBuilder {

        private PersonBuilder () {}

        public PersonBuilder setLogin(String login) {
            Person.this.login = login;
            return this;
        }

        public PersonBuilder setName(String name) {
            Person.this.name = name;
            return this;
        }

        public PersonBuilder setAge(int age) {
            Person.this.age = age;
            return this;
        }

        public PersonBuilder setPassword(String password) {
            Person.this.password = password;
            return this;
        }

        public PersonBuilder setRole(Role role) {
            Person.this.role = role;
            return this;
        }

        public PersonBuilder setBalance(Double balance) {
            Person.this.balance = balance;
            return this;
        }

        public PersonBuilder setUserStatus(UserStatus status) {
            Person.this.status = status;
            return this;
        }

        public Person createPerson() {
            return Person.this;
        }
    }
}
