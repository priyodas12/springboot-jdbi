package io.springboot.rnd.springboot_jdbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringbootJdbiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbiApplication.class, args);
	}

}
