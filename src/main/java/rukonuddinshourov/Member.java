package rukonuddinshourov;

import java.io.Serializable;
import java.time.LocalDate;

public class Member implements Serializable {

    private String memberId;
    private String name;
    private Integer age;
    private String email;
    private String adress;
    private LocalDate dateOfBirth;
    private String gender;
    private String firstName;
    private String lastName;
    private  String password;
    public String status;

    public Member(String memberId, String name, Integer age, String email, String adress, LocalDate dateOfBirth, String gender, String firstName, String lastName, String password, String status) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.adress = adress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setPhone(Integer phone) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}