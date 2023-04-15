package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import com.bridgelabz.employeepayrollapp.services.IEmployeeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeServices iEmployeeServices;

    //////////////////// ::  Save Employee  :: ////////////////////
    @PostMapping("/add")
    public ResponseDTO addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        EmployeeData empData = iEmployeeServices.addEmployee(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data added Successfully", empData);
        return responseDTO;
    }

    //////////////////// ::  Get Employee By Id :: ////////////////////
    @GetMapping("/getEmp/{id}")
    public String getEmployeeDetailById(@PathVariable int id){
        return iEmployeeServices.getEmployeeDetailById(id);
    }

    //////////////////// ::  Get All Description  :: ////////////////////
    @GetMapping("/getAllEmp")
    public List<EmployeeData> getAllEmployees(){
        return iEmployeeServices.getAllEmployees();
    }

    //////////////////// ::  Edit Employee :: ////////////////////
    @PutMapping("/editEmp/{id}")
    public String editEmployeeDetailsById(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable int id){
        EmployeeData empList = new EmployeeData(employeeDTO);
        return iEmployeeServices.editEmployeeDetailsById(empList,id);
    }

    //////////////////// ::  Delete Employee By Id :: ////////////////////
    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return iEmployeeServices.deleteEmployeeById(id);
    }

    //////////////////// ::  Delete All Employee :: ////////////////////
    @DeleteMapping("/deleteAllEmp/")
    public String deleteAllEmployees(){
        return iEmployeeServices.deleteAllEmployees();
    }

    //////////////////// ::  Get Employee By Id :: ////////////////////
    @GetMapping("/getEmpDept/{dept}")
    public List<EmployeeData> getEmployeeDetailByDepartment(@PathVariable String dept){
        return iEmployeeServices.getEmployeeDetailByDepartment(dept);
    }


}
