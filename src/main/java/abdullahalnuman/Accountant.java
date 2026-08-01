package abdullahalnuman;

import user.Employee;

import java.time.LocalDate;

public class Accountant extends Employee {

    public Accountant(LocalDate dateOfBirth, String userEmail, String userId, String userName, String userPassword, LocalDate dateOfJoining, float salary) {
        super(dateOfBirth, userEmail, userId, userName, userPassword, dateOfJoining, salary);
    }
}
