package user;

import java.time.LocalDate;

public class Employee extends User{
    private float salary;
    private LocalDate dateOfJoining;

    public Employee(LocalDate dateOfBirth, String userEmail, String userId, String userName, String userPassword, LocalDate dateOfJoining, float salary) {
        super(dateOfBirth, userEmail, userId, userName, userPassword);
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }



    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dateOfJoining=" + dateOfJoining +
                ", salary=" + salary +
                '}';
    }

}
