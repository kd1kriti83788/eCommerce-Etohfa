package com.etohfa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.etohfa.entity.User;
import com.etohfa.service.UserService;
import com.etohfa.utility.Constants.UserRole;
import com.etohfa.utility.Constants.UserStatus;

@SpringBootApplication
public class ETohfaBackendApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(ETohfaBackendApplication.class);

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ETohfaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User admin = this.userService.getUserByEmailIdAndRoleAndStatus("kriti@etohfa.com",
				UserRole.ROLE_ADMIN.value(), UserStatus.ACTIVE.value());

		if (admin == null) {

			LOG.info("Admin not found in system, so adding default admin");
			
			User user = new User();
			user.setEmailId("kriti@etohfa.com");
			user.setPassword(passwordEncoder.encode("kriti123"));
			user.setRole(UserRole.ROLE_ADMIN.value());
			user.setStatus(UserStatus.ACTIVE.value());
			
			this.userService.addUser(user);

		}

	}


}
