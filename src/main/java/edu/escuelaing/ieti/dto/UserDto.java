package edu.escuelaing.ieti.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
    private String name;
    private String lastName;
    private String email;
    private boolean created;


    public UserDto() {

    }

    public UserDto(String name, String lastName, String email, boolean created) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.created = created;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCreated() {
        return this.created;
    }

    public boolean getCreated() {
        return this.created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", created='" + isCreated() + "'" +
            "}";
    }

}
