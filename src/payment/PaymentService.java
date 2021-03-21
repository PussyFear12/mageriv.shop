package payment;

import model.Product;

import java.util.List;

public interface PaymentService {
    public void plusBalance(Double payment);
    public boolean buyGoods(List<Product> products);
}
