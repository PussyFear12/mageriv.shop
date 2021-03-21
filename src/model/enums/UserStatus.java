package model.enums;

/**
 * @author Admin
 */

public enum UserStatus {
    GUEST {
        @Override
        public String toString() {
            return "guest";
        }
    },
    AUTHORIZED {
        @Override
        public String toString() {
            return "authorized";
        }
    }
}
