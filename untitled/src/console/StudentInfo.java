package console;
import java.util.ArrayList;
import java.util.List;
public class StudentInfo {
    private String lastName;
    private String firstName;
    private String middleName;
    private List<String> violationInfoList;
    public StudentInfo() {
        this.violationInfoList = new ArrayList<>();
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String setMiddleName(String middleName){this.middleName = middleName;
        return middleName;
    }
    public String getMiddleName(){return middleName;}
    public List<String> getViolationInfoList() {
        return violationInfoList;
    }
    public void addViolationInfo(String violationInfo) {
        this.violationInfoList.add(violationInfo);
    }
}
