package Bank_AppCore.beans;

public class User {
    private String username;
    private String password;
    private String role; // "Admin" or "Customer"
    private int accountId; // For customers only

    public User(String username, String password, String role, int accountId) {
        super();
        this.username = username;
        this.password = password;
        this.role = role;
        this.accountId = accountId;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", role=" + role + ", accountId=" + accountId
                + "]";
    }


}