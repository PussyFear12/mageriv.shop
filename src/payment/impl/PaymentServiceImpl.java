package payment.impl;

import model.Product;
import payment.PaymentService;
import util.Logger;

import java.util.List;
import java.util.Objects;

/**
 * @author Admin
 */
public class PaymentServiceImpl implements PaymentService {

    private Double mainBalance;

    private PaymentServiceImpl() {
    }

    @Override
    public void plusBalance(Double payment) {
        if (Objects.nonNull(payment) && payment > 0) {
            increaseBalance(payment);
            Logger.logToConsole("Shop balance plus [" + payment + "]");
        }
        Logger.logToConsole("Current balance is : [" + mainBalance + "]");
    }

    @Override
    public boolean buyGoods(List<Product> products) {
        double total = products.stream().mapToDouble(Product::getPrice).sum();

        if (total <= mainBalance / 2.0) {
            mainBalance -= total;
            Logger.logToConsole(total + " - wasted from main balance.");

            return true;
        }
        Logger.logToConsole("Not enough money, operation declined...");
        return false;
    }

    public Double getMainBalance() {
        return mainBalance;
    }

    public void setMainBalance(Double mainBalance) {
        this.mainBalance = mainBalance;
    }

    public void increaseBalance(Double payment) {
        this.mainBalance += payment;
    }
}
