package ru.netology.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import ru.netology.bootdemo.classes.DevProfile;
import ru.netology.bootdemo.classes.ProductionProfile;
import ru.netology.bootdemo.interfaces.SystemProfile;

@SpringBootApplication
public class BootDemoGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoGradleApplication.class, args);
	}

	@ConditionalOnProperty(name="netology.profile.dev", havingValue = "true")
	@Bean
	public SystemProfile devProfile() {
		return new DevProfile();
	}

	@ConditionalOnMissingBean
	@Bean
	public SystemProfile prodProfile() {
		return new ProductionProfile();
	}

}
