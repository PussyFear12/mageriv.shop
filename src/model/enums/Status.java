package model.enums;

/**
 * @author Admin
 */

public enum Status {
    AVAILABLE {
        @Override
        public String toString() {
            return "available";
        }
    },
    NOT_AVAILABLE {
        @Override
        public String toString() {
            return "not_available";
        }
    }

}
