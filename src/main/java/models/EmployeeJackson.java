package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;
import java.io.IOException;

public class EmployeeJackson {
    public static EmployeeJackson getEmployeeJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "user.json"),EmployeeJackson.class);
    }

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("emailAddress")
    private String emailAddress;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("Register")
    Register register;

    static class Register{
        @JsonProperty ("fullname")
        private String fullname;
    }
}
