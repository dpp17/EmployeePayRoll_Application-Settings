package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;
import java.time.LocalDate;
import java.util.List;

@ToString
public class EmployeeDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{2,}$", message = "Start Name With Capital Letter")
    public String name;

    @Min(value = 500, message = "Salray shoild be greater than 500")
    public double salary;

    public String gender;

    public LocalDate startDate;

    public String profilePic;

    public String note;

    public List<String> department;
}
