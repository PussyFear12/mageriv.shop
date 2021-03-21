package model;

import java.util.Objects;

/**
 * @author Admin
 */
public class ShopBalance {
    private Double balance;

    public ShopBalance() {
        this.balance = 0.0;
    }

    public Double addBalance(Double money) {
        if (Objects.nonNull(money) && money > 0) {
            this.balance += money;
        }
        return balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopBalance that = (ShopBalance) o;
        return Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    @Override
    public String toString() {
        return "ShopBalance{" +
                "balance=" + balance +
                '}';
    }
}
