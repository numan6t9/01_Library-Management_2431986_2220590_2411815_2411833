package rukonuddinshourov;

import user.Employee;

import java.time.LocalDate;

public class Librarian extends Employee {
    public Librarian(LocalDate dateOfBirth, String userEmail, String userId, String userName, String userPassword, LocalDate dateOfJoining, float salary) {
        super(dateOfBirth, userEmail, userId, userName, userPassword, dateOfJoining, salary);
    }
}
