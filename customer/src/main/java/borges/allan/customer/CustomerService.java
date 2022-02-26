package borges.allan.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository,
						      RestTemplate restTemplate) {

	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		
		customerRepository.saveAndFlush(customer);
		//TODO regras de negocio aqui
		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
				"http://FRAUD/api/v1/fraud-check/{customerId}", 
				FraudCheckResponse.class,
				customer.getId()
		);
		
		if (fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("fraudster");
		}
		
	}
	
}
