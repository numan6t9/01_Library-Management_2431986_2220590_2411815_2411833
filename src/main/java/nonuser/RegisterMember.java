package nonuser;
import java.io.Serializable;
import java.time.LocalDate;

public class RegisterMember implements Serializable {
    private String memberName,memberEmailAddress,memberAddress,memberGender;
    private int memberAge;
    private LocalDate memberDOB;

    public RegisterMember(String memberAddress, int memberAge, LocalDate memberDOB, String memberEmailAddress, String memberGender, String memberName) {
        this.memberAddress = memberAddress;
        this.memberAge = memberAge;
        this.memberDOB = memberDOB;
        this.memberEmailAddress = memberEmailAddress;
        this.memberGender = memberGender;
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public LocalDate getMemberDOB() {
        return memberDOB;
    }

    public String getMemberEmailAddress() {
        return memberEmailAddress;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public void setMemberEmailAddress(String memberEmailAddress) {
        this.memberEmailAddress = memberEmailAddress;
    }

    @Override
    public String toString() {
        return "RegisterMember{" +
                "memberAddress='" + memberAddress + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberEmailAddress='" + memberEmailAddress + '\'' +
                ", memberGender='" + memberGender + '\'' +
                ", memberAge=" + memberAge +
                ", memberDOB=" + memberDOB +
                '}';
    }
}
