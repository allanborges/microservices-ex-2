package borges.allan.clients.notification;

import java.time.LocalDateTime;

public record NotificationRequest(Integer toCustomerId,
								  String customerEmail,								  
								  String message) {

}
