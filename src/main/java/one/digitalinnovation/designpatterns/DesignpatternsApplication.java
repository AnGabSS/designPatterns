package one.digitalinnovation.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesignpatternsApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesignpatternsApplication.class, args);
	}

}
