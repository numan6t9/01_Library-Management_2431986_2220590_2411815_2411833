package rukonuddinshourov;

import java.util.*;
import java.io.*;

public class MemberManager {

    private static final String FILE_NAME = "members.bin";

    // Load members
    public List<Member> loadMembers() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (List<Member>) ois.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Save members
    public void saveMembers(List<Member> members) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(members);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMember(Member newMember) {
        List<Member> members = loadMembers();
        members.add(newMember);
        saveMembers(members);
    }
}