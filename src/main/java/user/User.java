package user;

import java.time.LocalDate;

public abstract class User {
    protected final String userId, userName;
    protected String userEmail;
    protected LocalDate dateOfBirth;

    public User(LocalDate dateOfBirth, String userEmail, String userId, String userName) {
        this.dateOfBirth = dateOfBirth;
        this.userEmail = userEmail;
        this.userId = userId;
        this.userName = userName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "dateOfBirth=" + dateOfBirth +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
