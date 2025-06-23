package parcial.prog3.ORIGINAL;

public class User {
    private String username;
    private String plan; // "Free", "Premium"

    public User(String username, String plan) {
        this.username = username;
        this.plan = plan;
    }

    public String getUsername() {
        return username;
    }

    public String getPlan() {
        return plan;
    }
}
