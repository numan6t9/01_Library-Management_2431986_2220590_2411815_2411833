package user;

import java.time.LocalDate;

public abstract class User {
    protected final String userId, userName;
    protected String userPassword,userEmail;
    protected LocalDate dateOfBirth;

    public User(LocalDate dateOfBirth, String userEmail, String userId, String userName, String userPassword) {
        this.dateOfBirth = dateOfBirth;
        this.userEmail = userEmail;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "dateOfBirth=" + dateOfBirth +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
