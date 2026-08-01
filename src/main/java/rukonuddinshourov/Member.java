package rukonuddinshourov;

import user.User;

import java.time.LocalDate;

public class Member  extends User {

    public Member(LocalDate dateOfBirth, String userEmail, String userId, String userName, String userPassword) {
        super(dateOfBirth, userEmail, userId, userName, userPassword);
    }
}
