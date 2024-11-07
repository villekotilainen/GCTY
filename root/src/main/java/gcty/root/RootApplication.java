package gcty.root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gcty.root.Entities.User;
import gcty.root.Entities.UserRole;
import gcty.root.Repositories.ArtistiRepository;
import gcty.root.Repositories.KeikkaRepository;
import gcty.root.Repositories.RolePermissionRepository;
import gcty.root.Repositories.UserRepository;
import gcty.root.Repositories.UserRoleRepository;
import gcty.root.Repositories.VenueRepository;

@SpringBootApplication
public class RootApplication {

	private static final Logger log = LoggerFactory.getLogger(RootApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RootApplication.class, args);
	}

	@Bean
	public CommandLineRunner createStarterData ( 
		ArtistiRepository artistiRepository,
		KeikkaRepository keikkaRepository,
		RolePermissionRepository rolePermissionRepository,
		UserRepository userRepository,
		UserRoleRepository userRoleRepository,
		VenueRepository venueRepository
	) {
		return (args) ->   {
			log.info("Creating sample data");

			UserRole adminRole = new UserRole(null, "ADMIN");
            UserRole userRole = new UserRole(null, "USER");
			UserRole visitorRole = new UserRole(null, "VISITOR");
            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);
			userRoleRepository.save(visitorRole);

			User user1 = new User(null, "villek", "Ville", "Kotilainen", "1234abCD", "villek@email.com", "123 456 7890", adminRole);
			User user2 = new User(null, "taneli", "Taneli", "Tumpelo", "heipähei123", "taneli@email.fi", "123 098 7654", userRole);
			userRepository.save(user1);
			userRepository.save(user2);

			log.info("Sample data created succesfully.");
		};
	}
	
}
