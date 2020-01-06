package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.MyUserDetails;
import com.example.demo.model.AuthenticationRequest;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.security.MyUserDetailService;
import com.example.demo.security.util.JwtUtil;
import com.example.demo.service.UserService;

@Controller
public class SampleController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@ResponseBody
	@GetMapping("/hello")
	public String sampleGreet() {
		return "Welcome";
	}
	
	@ResponseBody
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException ex) {
			throw new Exception("Incorrect Username and Password" + ex);
		}
		
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	/*@ResponseBody
	@GetMapping("/getuser/{id}")
	public User getUser(@PathVariable("id") String id) {
		User outerUser = null;
		Long userId = Long.parseLong(id);
		Optional<User> optionalUser = userservice.getUserById(userId);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			outerUser = user;
		}
		return outerUser;
	}*/
	
	
}
