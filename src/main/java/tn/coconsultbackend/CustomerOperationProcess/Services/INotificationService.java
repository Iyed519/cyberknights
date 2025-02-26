package tn.coconsultbackend.CustomerOperationProcess.Services;

import tn.coconsultbackend.Model.Notification;

import java.util.List;
import java.util.Optional;

public interface INotificationService {

    List<Notification> getAllNotificationsForUser(Long userId);

    List<Notification> getUnreadNotificationsForUser(Long userId);

    Notification createNotification(Notification notification);

    Optional<Notification> getNotificationById(Long id);

    void markNotificationAsRead(Long id);

    void deleteNotification(Long id);
}
