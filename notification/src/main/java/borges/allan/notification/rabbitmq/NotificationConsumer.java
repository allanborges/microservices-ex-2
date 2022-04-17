package borges.allan.notification.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import borges.allan.clients.notification.NotificationRequest;
import borges.allan.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
	
	private final NotificationService notificationService;
	
	@RabbitListener(queues = "${rabbitmq.queues.notification}")
	public void consumer(NotificationRequest notificationRequest) {
		log.info("Consumed {} from queue", notificationRequest);
		notificationService.send(notificationRequest);
	}
}
