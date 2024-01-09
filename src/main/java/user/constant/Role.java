package user.constant;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
