package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements IEmployeeServices{

    @Autowired
    private EmployeeRepo empRepo;

    List<EmployeeData> list = new ArrayList<>();

    @Override
    public EmployeeData addEmployee(EmployeeDTO employeeDTO) {
        EmployeeData empData = new EmployeeData(employeeDTO);
          list.add(empData);
        return empRepo.save(empData);
    }

    @Override
    public String getEmployeeDetailById(int id) {
        Optional<EmployeeData> empListId = empRepo.findById(id);
        if(empListId.isPresent()){
            return "==>> " + empListId;
        }
        return "Employee with ID:: " + id + "  doesn't found !!";
    }

    @Override
    public List<EmployeeData> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public String editEmployeeDetailsById(EmployeeData empList, int id) {
        Optional<EmployeeData> editEmployeeDetail = empRepo.findById(id);
        if (editEmployeeDetail.isPresent()) {
            editEmployeeDetail.get().setName(empList.getName());
            editEmployeeDetail.get().setSalary(empList.getSalary());
            empRepo.save(editEmployeeDetail.get());
            return "Employee Details Edited Successfully.... Name:: " + empList.getName() +" || Salary :: " + empList.getSalary();
        }
        else
            return " :: Employee ID:: "+ id +"  doesn't Exist ::";
    }

    @Override
    public String deleteEmployeeById(int id) {
        Optional<EmployeeData> empList = empRepo.findById(id);
        if(empList.isPresent()){
            empRepo.deleteById(id);
            return "Employee Details Deleted Successfully !!!";
        }
        return " :: Employee ID:: "+ id + "  doesn't Exist ::";
    }

    @Override
    public String deleteAllEmployees() {
        empRepo.deleteAll();
        return "All Employee's Detail-Recordsa are deleted";
    }


}
