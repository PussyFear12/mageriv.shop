package model;

import model.enums.Status;

import java.util.Objects;

public class Product {
    private int uid;
    private String brand;
    private Long value;
    private Double price;
    private Status status;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;

    public Product(int uid, String brand, Long value, Double price, Status status) {
        this.uid = uid;
        this.brand = brand;
        this.value = value;
        this.price = price;
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uid=" + uid +
                ", brand='" + brand + '\'' +
                ", value=" + value +
                ", price=" + price +
                ", status=" + status +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return getUid() == product.getUid() && Objects.equals(getBrand(),
                product.getBrand()) && Objects.equals(getValue(),
                product.getValue()) && Objects.equals(getPrice(),
                product.getPrice()) && getStatus() == product.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getBrand(), getValue(), getPrice(), getStatus());
    }
}
