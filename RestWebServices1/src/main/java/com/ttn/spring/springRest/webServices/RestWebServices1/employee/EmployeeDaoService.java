package com.ttn.spring.springRest.webServices.RestWebServices1.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {
    private static List<EmployeeBean> employees = new ArrayList<>();
    private static int employeeCount = 3;

    static {
        employees.add(new EmployeeBean(1,"Vaishali",24));
        employees.add(new EmployeeBean(2,"Nidhi",30));
        employees.add(new EmployeeBean(3,"Sreyasi",23));
    }

    public List<EmployeeBean> findAll(){
        return employees;
    }

    public EmployeeBean save(EmployeeBean employee){
        if(employee.getId() == null)
            employee.setId(++employeeCount);
        employees.add(employee);
        return employee;
    }

    public EmployeeBean findOne(int id){
        for(EmployeeBean employee:employees){
            if(employee.getId() == id)
                return employee;
        }
        return null;
    }

    public EmployeeBean deleteById(int id){
        Iterator<EmployeeBean> iterator = employees.iterator();
        while(iterator.hasNext()){
            EmployeeBean employee = iterator.next();
            if(employee.getId() == id){
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}
