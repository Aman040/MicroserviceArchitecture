package com.example.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.Entity.User;
import com.example.User.Service.UserService;
import com.example.User.Service.Vo.ResponseTemplate;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUsers(@RequestBody User user) {
		return userService.saveUser(user);
	}
	@GetMapping("/{id}")
	public ResponseTemplate getUserWithDepartmentId(@PathVariable("id") Long userId) {
		return userService.getUserWithDepartmentId(userId);
	}
}
