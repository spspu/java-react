package backend.hobbiebackend.service;

import org.springframework.scheduling.annotation.Async;

import backend.hobbiebackend.model.entities.UserEntity;

public interface NotificationService {
    @Async
    void sendNotification(UserEntity userEntity);
}
