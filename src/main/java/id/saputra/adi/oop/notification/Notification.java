package id.saputra.adi.oop.notification;

public interface Notification {
    void send(String processingId, String transactionStatus, String notificationType);
}
