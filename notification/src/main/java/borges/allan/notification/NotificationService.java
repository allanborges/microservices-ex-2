package borges.allan.notification;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import borges.allan.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {
	
	private NotificationRepository notificationRepository;	
	
	public void send(NotificationRequest request) {
		this.notificationRepository.save(Notification.builder().
										toCustomerId(request.toCustomerId()).
										sender("Allan").
										message(request.message()).
										toCustomerEmail(request.customerEmail()).
										sentAt(LocalDateTime.now()).
										build());
	}
	
	

}
