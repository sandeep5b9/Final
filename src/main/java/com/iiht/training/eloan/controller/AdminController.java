package com.iiht.training.eloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register-clerk")
	public ResponseEntity<UserDto> registerClerk(@RequestBody UserDto userDto){
		UserDto userDtoRet =  this.adminService.registerClerk(userDto);
		return new ResponseEntity<UserDto>(userDtoRet, HttpStatus.OK);
	}
	
	@PostMapping("/register-manager")
	public ResponseEntity<UserDto> registerManager(@RequestBody UserDto userDto){
		UserDto userDtoRet =  this.adminService.registerManager(userDto);
		return new ResponseEntity<UserDto>(userDtoRet, HttpStatus.OK);
	}
	
	@GetMapping("/all-clerks")
	public ResponseEntity<List<UserDto>> getAllClerks(){
		List<UserDto> userList = this.adminService.getAllClerks();
		return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/all-managers")
	public ResponseEntity<List<UserDto>> getAllManagers(){
		List<UserDto> userList = this.adminService.getAllManagers();
		return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
	}
}
