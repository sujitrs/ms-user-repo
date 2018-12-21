package org.sj.msuserrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MsUserRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUserRepoApplication.class, args);
	}

}

