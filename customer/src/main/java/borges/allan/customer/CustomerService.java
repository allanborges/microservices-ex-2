package borges.allan.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import borges.allan.amqp.RabbitMQMessageProducer;
import borges.allan.clients.fraud.FraudCheckResponse;
import borges.allan.clients.fraud.FraudClient;
import borges.allan.clients.notification.NotificationClient;
import borges.allan.clients.notification.NotificationRequest;

@Service
public record CustomerService(CustomerRepository customerRepository,
						      RestTemplate restTemplate,
						      FraudClient fraudClient,
						      NotificationClient notification,
						      RabbitMQMessageProducer rabbitMQMessageProducer) {

	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		
		customerRepository.saveAndFlush(customer);
			
		FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
		
		if (fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("fraudster");
		}
		
		NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), customer.getEmail(), "Message from Allan" );
		
		rabbitMQMessageProducer.publish(notificationRequest,
									    "internal.exchange",
									    "internal.notification.routing-key");
	}
	
}
