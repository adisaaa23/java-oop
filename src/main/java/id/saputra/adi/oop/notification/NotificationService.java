package id.saputra.adi.oop.notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationService extends INotification {

    @Override
    void push(String processingId, String transactionStatus) {
        send(processingId, transactionStatus, Type.PUSH.name());
    }

    @Override
    void email(String processingId, String transactionStatus) {
        send(processingId, transactionStatus, Type.EMAIL.name());
    }
}
