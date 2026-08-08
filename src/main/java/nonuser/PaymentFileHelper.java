package nonuser;

import rukonuddinshourov.FinePayment;

import java.io.*;
import java.util.ArrayList;

public class PaymentFileHelper {

    private static final String FILE_NAME = "FinePayments.bin";

    // ================= Save (Append) =================
    public static void savePayment(FinePayment payment) {

        ArrayList<FinePayment> list = readAllPayments();
        list.add(payment);

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(list);

        } catch (IOException e) {
            System.out.println("Error saving payment: " + e.getMessage());
        }
    }

    // ================= Read All =================
    @SuppressWarnings("unchecked")
    public static ArrayList<FinePayment> readAllPayments() {

        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ArrayList<FinePayment>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading payments: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // ================= Check if fine already paid =================
    public static boolean isFinePaid(String fineId) {

        for (FinePayment p : readAllPayments()) {
            if (p.getFineId().equalsIgnoreCase(fineId)
                    && p.getStatus().equalsIgnoreCase("Paid")) {
                return true;
            }
        }
        return false;
    }

    // ================= Get payments of a member =================
    public static ArrayList<FinePayment> getMemberPayments(String memberId) {

        ArrayList<FinePayment> result = new ArrayList<>();

        for (FinePayment p : readAllPayments()) {
            if (p.getMemberId().equalsIgnoreCase(memberId)) {
                result.add(p);
            }
        }
        return result;
    }

    // ================= Get last payment =================
    public static FinePayment getLastPayment(String memberId) {

        ArrayList<FinePayment> list = getMemberPayments(memberId);

        if (list.isEmpty()) return null;

        return list.get(list.size() - 1);
    }
}