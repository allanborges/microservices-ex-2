package borges.allan.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AppGWApplication {
	
    public static void main( String[] args ) {
       SpringApplication.run(AppGWApplication.class, args);
    }
    
}
