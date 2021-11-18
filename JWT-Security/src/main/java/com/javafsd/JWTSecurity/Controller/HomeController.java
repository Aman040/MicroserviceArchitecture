package com.javafsd.JWTSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafsd.JWTSecurity.Entity.JwtRequest;
import com.javafsd.JWTSecurity.Entity.JwtResponse;
import com.javafsd.JWTSecurity.Service.UserService;
import com.javafsd.JWTSecurity.Utility.JwtUtility;

@RestController
public class HomeController {
	
	@Autowired
	private JwtUtility jwtUtility;



	@Autowired
	private AuthenticationManager authenticationManager;



	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "Welcome Spring Security";
	}
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
	try {
	authenticationManager.authenticate(
	new UsernamePasswordAuthenticationToken(
	jwtRequest.getUsername(), jwtRequest.getPassword()));
	}catch(BadCredentialsException be) {
	throw new Exception("INVALID CREDENTIALS", be);
	}

	final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
	final String token = jwtUtility.generateToken(userDetails);

	return new JwtResponse(token);



	}

}
