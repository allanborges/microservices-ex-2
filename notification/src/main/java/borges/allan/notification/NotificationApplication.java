package borges.allan.notification;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import borges.allan.amqp.RabbitMQMessageProducer;

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
    
    @Bean
    CommandLineRunner commandLineRunner(
    		RabbitMQMessageProducer producer,
    		NotificationConfig notificationConfig
    		) {
    	return args -> {
    		producer.publish(new Person("Alie", 35),
    				notificationConfig.getInternalExchange(),
    				notificationConfig.getInternalNotificationRoutingKey());
    	};
    }
    
    record Person(String name, int age) {}
}
