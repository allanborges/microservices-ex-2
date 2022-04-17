package borges.allan.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
		scanBasePackages = {
			"borges.allan.notification",
			"borges.allan.amqp"
		}
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
    	SpringApplication.run(NotificationApplication.class, args);
    }   
  
}
