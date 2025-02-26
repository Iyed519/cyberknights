package tn.coconsultbackend.CustomerOperationProcess.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.CustomerOperationProcess.Services.INotificationService;
import tn.coconsultbackend.Model.Notification;
import java.util.List;
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

//    private final INotificationService notificationService;
//
//    @Autowired
//    public NotificationController(INotificationService notificationService) {
//        this.notificationService = notificationService;
//    }
//
//    // Get all notifications for a user
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Notification>> getAllNotificationsForUser(@PathVariable Long userId) {
//        List<Notification> notifications = notificationService.getAllNotificationsForUser(userId);
//        return ResponseEntity.ok(notifications);
//    }
//
//    // Get unread notifications for a user
//    @GetMapping("/user/{userId}/unread")
//    public ResponseEntity<List<Notification>> getUnreadNotificationsForUser(@PathVariable Long userId) {
//        List<Notification> notifications = notificationService.getUnreadNotificationsForUser(userId);
//        return ResponseEntity.ok(notifications);
//    }
//
//    // Create a new notification
//    @PostMapping("/")
//    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
//        Notification createdNotification = notificationService.createNotification(notification);
//        return ResponseEntity.ok(createdNotification);
//    }
//
//    // Get a single notification by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
//        return notificationService.getNotificationById(id)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Mark a notification as read
//    @PutMapping("/{id}/read")
//    public ResponseEntity<Void> markNotificationAsRead(@PathVariable Long id) {
//        notificationService.markNotificationAsRead(id);
//        return ResponseEntity.ok().build();
//    }
//
//    // Delete a notification
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
//        notificationService.deleteNotification(id);
//        return ResponseEntity.ok().build();
//    }
}
