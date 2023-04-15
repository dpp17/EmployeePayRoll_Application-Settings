package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee_payroll")
public class EmployeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;

    @Column(name = "employee_name")
    private String name;
    private double salary;
    private String gender;
    private LocalDate startDate;
    private String profilePic;
    private String note;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name="id"))
    @Column(name = "department")
    private List<String> departments;

    public EmployeeData(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.salary = employeeDTO.salary;
        this.gender = employeeDTO.gender;
        this.startDate = employeeDTO.startDate;
        this.profilePic = employeeDTO.profilePic;
        this.note = employeeDTO.note;
        this.departments = employeeDTO.departments;
    }
}
