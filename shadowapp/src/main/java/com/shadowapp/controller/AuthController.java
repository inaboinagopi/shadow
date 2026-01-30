package com.shadowapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shadowapp.config.JwtService;
import com.shadowapp.dto.LoginRequestDto;
import com.shadowapp.dto.RegisterRequestDto;
import com.shadowapp.dto.TokenResponseDto;
import com.shadowapp.entity.User;
import com.shadowapp.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
			AuthenticationManager authenticationManager) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	// ✅ Register a new user
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequestDto request) {
		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			return ResponseEntity.badRequest().body("Email already exists!");
		}

		User user = new User();
		user.setEmail(request.getEmail());
		user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
       user.setPhone(request.getPhone());
       user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
//        user.setRole("ROLE_USER"); // default role

		userRepository.save(user);

		String token = jwtService.generateToken(user.getEmail());
		return ResponseEntity.ok(new TokenResponseDto(token, null));
	}

	// ✅ Login
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		var user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));

		String token = jwtService.generateToken(user.getEmail());
		return ResponseEntity.ok(new TokenResponseDto(token, null));
	}
}
