package user;
import abdullahalnuman.Accountant;
import abdullahalnuman.Receptionist;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserData {

    ArrayList<User> userList = new ArrayList<>();

//LocalDate dateOfBirth, String userEmail, String userId,
// String userName, String userPassword, LocalDate dateOfJoining, float salary
    public UserData(){
        Accountant accountant = new Accountant(
                LocalDate.of(2005,10,15),
                "al.32noman@gmail.com",
                "2431986",
                "Abdullah Al Numan",
                "23123",
                LocalDate.of(2026,5,12),
                200500
        );
        userList.add(accountant);
    }












}
