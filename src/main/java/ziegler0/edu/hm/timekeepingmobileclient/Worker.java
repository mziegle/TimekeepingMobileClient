package ziegler0.edu.hm.timekeepingmobileclient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Worker implements Serializable {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    @JsonCreator
    public Worker(
            @JsonProperty("firstName")
            String firstName,
            @JsonProperty("lastName")
            String lastName,
            @JsonProperty("username")
            String username,
            @JsonProperty("password")
            String password
    ) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Worker(){
        // Default constructor
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
