package id.saputra.adi.oop.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class INotification implements Notification {

    protected static final Logger log = LoggerFactory.getLogger(INotification.class);

    abstract void push(String processingId, String transactionStatus);
    abstract void email(String processingId, String transactionStatus);

    @Override
    public void send(String processingId, String transactionStatus, String notificationType) {
        try {
            log.info("Starting send notification transaction with process ID [{}], transaction status [{}], notification type [{}]", processingId, transactionStatus, notificationType);
            //TODO put your code here
            log.info("Successfully send notification transaction with process ID [{}], transaction status [{}], notification type [{}]", processingId, transactionStatus, notificationType);
        } catch (Exception ex){
            log.error("Failed send notification transaction with process ID [{}}, notification type [{}], error message [{}]", processingId, notificationType, ex.getMessage(), ex);
        }
    }
}
