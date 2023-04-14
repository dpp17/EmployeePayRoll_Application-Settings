package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class EmployeeData {
    @Id
    @GeneratedValue
    private int emp_id;
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String profilePic;
    private String note;
    private List<String> department;

    public EmployeeData(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.salary = employeeDTO.salary;
        this.gender = employeeDTO.gender;
        this.startDate = employeeDTO.startDate;
        this.profilePic = employeeDTO.profilePic;
        this.note = employeeDTO.note;
        this.department = employeeDTO.department;
    }
}
