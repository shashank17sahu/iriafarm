package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exceptions.ResourceNotFoundException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository employeeRepository;
	
	//get all Employees 
	
	@GetMapping("/users")
	public List<User> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	//Create Employee RestAPI
	@PostMapping("/users")
	public User createEmployee(@RequestBody User employee) {
		return employeeRepository.save(employee);
		
	}
	
	// Get Employee by id REST API
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getEmployeeById(@PathVariable Long id) {
		User employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with Id :" + id));
		return ResponseEntity.ok(employee);		
	}
	
	//update employee REEST API
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable Long id,@RequestBody User employeeDetails ){
		User employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with Id :" + id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setLocation(employeeDetails.getLocation());
		
		User updatedEmployee =  employeeRepository.save(employee);
		
		return ResponseEntity.ok(updatedEmployee);		
	}
	// Delete Employee rest API
	@DeleteMapping("/employee/{id}")	
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		User employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with Id :" + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
