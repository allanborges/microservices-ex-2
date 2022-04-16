package borges.allan.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
		scanBasePackages = {
				"borges.allan.customer",
				"borges.allan.amqp"
			}	
)
@EnableEurekaClient
@EnableFeignClients(
	basePackages = "borges.allan.clients"	
)
public class CustomerApplication {
	
	 public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	 }

}
