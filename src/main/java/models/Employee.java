package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String avtImg;

    private String changeFirstname;
    private String changeLastname;
    private String deliverLicense;
    private String expireDateDriverLicense;
    private String national;
    private String marital;
    private String dateOfBirth;
    private String gender;

//    public static Employee getEmployee(){
//        return new Employee();
//    }
}
