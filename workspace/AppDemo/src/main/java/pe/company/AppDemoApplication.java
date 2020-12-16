package pe.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AppDemoApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(AppDemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		/*
		System.out.println("c123 "+passwordEncoder.encode("c123"));
		System.out.println("m123 "+passwordEncoder.encode("m123"));
		System.out.println("k123 "+passwordEncoder.encode("k123"));
		*/
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
