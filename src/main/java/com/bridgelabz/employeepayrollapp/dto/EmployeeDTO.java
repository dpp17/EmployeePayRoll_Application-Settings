package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.NonNull;
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

    @Pattern(regexp = "male|female", message = "Gender need to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDate should not be empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate;

    @NotBlank(message = "profilePic cannot be Empty")
    public String profilePic;

    @NotBlank(message = "Note cannot be Empty")
    public String note;

    @NotNull(message = "department shouldn't be Empty")
    public List<String> departments;
}
