package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeData,Integer> {
    @Query(value = "select * from employee_payroll,employee_department where emp_id = id and department =:department", nativeQuery = true)
    List<EmployeeData> findEmployeeByDepartment(String department);
}
