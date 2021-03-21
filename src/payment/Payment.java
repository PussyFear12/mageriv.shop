package payment;

import model.ShopBalance;
import util.Logger;

import java.util.Objects;

/**
 * @author Admin
 */
public class Payment {

    private Payment() {}

    public static void plusBalance(Double payment, ShopBalance shopBalance) {
        if (Objects.nonNull(payment) && payment > 0) {
            shopBalance.addBalance(payment);
            Logger.log("Shop balance plus [" + payment + "]");
        }
        Logger.log("Current balance is : [" + shopBalance + "]");
    }
}
