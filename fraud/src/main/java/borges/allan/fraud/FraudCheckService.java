package borges.allan.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {
	
	private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
		
	public boolean isFraudlentCustomer(Integer customerId) {
		fraudCheckHistoryRepository.save(
			FraudCheckHistory.builder()
					.customerId(customerId)
					.createdAt(LocalDateTime.now())
					.isFraudster(false)
					.build()
		);
		return false;
	}

}
