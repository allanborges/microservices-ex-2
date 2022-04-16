package borges.allan.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import borges.allan.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping
	public ResponseEntity<HttpStatus> sendNotification(@RequestBody NotificationRequest request) {
		log.info("New notification...{}", request);
		notificationService.send(request);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
