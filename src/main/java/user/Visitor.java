package user;

import java.io.Serializable;
import java.time.LocalDate;

public class Visitor implements Serializable {

    private  String  visitorName,visitorNID,phoneNumber,purposeOfVisit,visitorPass;

    public Visitor( String phoneNumber, String purposeOfVisit, String visitorName, String visitorNID, String visitorPass) {
        this.phoneNumber = phoneNumber;
        this.purposeOfVisit = purposeOfVisit;
        this.visitorName = visitorName;
        this.visitorNID = visitorNID;
        this.visitorPass = visitorPass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorNID() {
        return visitorNID;
    }

    public void setVisitorNID(String visitorNID) {
        this.visitorNID = visitorNID;
    }

    public String getVisitorPass() {
        return visitorPass;
    }

    public void setVisitorPass(String visitorPass) {
        this.visitorPass = visitorPass;
    }
}
