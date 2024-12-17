package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolDTO {

    private String id;
    private String name;
    private String address;
    private int numberOfStudents;
    private String principalName;

    public SchoolDTO() {
    }

    public SchoolDTO(String id, String name, String address, int numberOfStudents, String principalName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfStudents = numberOfStudents;
        this.principalName = principalName;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
