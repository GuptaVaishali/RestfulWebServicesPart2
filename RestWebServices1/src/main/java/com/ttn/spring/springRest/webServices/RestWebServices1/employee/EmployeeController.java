package com.ttn.spring.springRest.webServices.RestWebServices1.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDaoService service;

    @GetMapping("/employees")
    public List<EmployeeBean> retrieveAllEmployees() {
        return service.findAll();
    }

    /*
    @GetMapping("/employees/{id}")
    public EmployeeBean retrieveEmployee(@PathVariable int id){
        EmployeeBean employee = service.findOne(id);
        if(employee == null)
            throw new EmployeeNotFoundException("id- " + id);
        return employee;
    }
     */

    @GetMapping("/employees/{id}")
    public EntityModel<EmployeeBean> retrieveEmployee(@PathVariable int id){
        EmployeeBean employee = service.findOne(id);
        if(employee == null)
            throw new EmployeeNotFoundException("id- " + id);

        //using hateoas
        EntityModel<EmployeeBean> resource = EntityModel.of(employee);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllEmployees());
        resource.add(linkTo.withRel("all-employees"));
        return resource;
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody EmployeeBean employee){
        EmployeeBean savedEmployee = service.save(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public void DeleteEmployee(@PathVariable int id){
        EmployeeBean employee = service.deleteById(id);
        if(employee == null)
            throw new EmployeeNotFoundException("id-" + id);
    }

    @PutMapping("/employees")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody EmployeeBean employee){
        EmployeeBean updatedEmployee = service.updateEmployeeDetails(employee);
        if (updatedEmployee == null)
            throw new EmployeeNotFoundException("Incorrect id");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(updatedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
