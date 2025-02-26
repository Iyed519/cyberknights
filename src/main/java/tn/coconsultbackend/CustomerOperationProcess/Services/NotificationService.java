package tn.coconsultbackend.CustomerOperationProcess.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.coconsultbackend.Model.Notification;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
//
//    private final NotificationRepository notificationRepository;
//
//    @Autowired
//    public NotificationService(NotificationRepository notificationRepository) {
//        this.notificationRepository = notificationRepository;
//    }
//
//    // Fetch all notifications for a user
//    public List<Notification> getAllNotificationsForUser(Long userId) {
//        return notificationRepository.findByRecipientId(userId);
//    }
//
//    // Fetch only unread notifications for a user
//    public List<Notification> getUnreadNotificationsForUser(Long userId) {
//        return notificationRepository.findByReadFalseAndRecipientId(userId);
//    }
//
//    // Save a new notification
//    public Notification createNotification(Notification notification) {
//        return notificationRepository.save(notification);
//    }
//
//    // Get a single notification by ID
//    public Optional<Notification> getNotificationById(Long id) {
//        return notificationRepository.findById(id);
//    }
//
//    // Update a notification's read status to true
//    @Transactional
//    public void markNotificationAsRead(Long id) {
//        Notification notification = notificationRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));
//        notification.setRead(true);
//        notificationRepository.save(notification);
//    }
//
//    // Delete a notification
//    public void deleteNotification(Long id) {
//        notificationRepository.deleteById(id);
//    }
}
