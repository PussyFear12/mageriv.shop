package model.enums;

/**
 * @author Admin
 */

public enum Role {
    ADMIN {
        @Override
        public String toString() {
            return "admin";
        }
    },
    CUSTOMER {
        @Override
        public String toString() {
            return "customer";
        }
    },
    CASHIER {
        @Override
        public String toString() {
            return "cashier";
        }
    }
}
