package id.saputra.adi.oop.transfer.service;

import id.saputra.adi.oop.notification.NotificationService;
import id.saputra.adi.oop.notification.Type;
import id.saputra.adi.oop.transfer.constant.Status;
import id.saputra.adi.oop.transfer.dto.TransferRsDto;
import id.saputra.adi.oop.transfer.exception.TransferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Qualifier("FundTransferEnhance")
public class FundTransferEnhance extends IFundTransfer {
    private static final Logger log = LoggerFactory.getLogger(FundTransferEnhance.class);

    @Autowired
    private NotificationService notificationService;

    @Override
    public TransferRsDto accountInquiry(String accountNo, String amount) throws TransferException {
        log.info("Starting account inquiry with account no [{}], amount [{}]", accountNo, amount);
        BigDecimal balance = balanceInquiry();
        balanceValidation(balance, new BigDecimal(amount));
        return super.accountInquiry(accountNo, amount);
    }

    @Override
    public TransferRsDto fundTransfer(String accountNo, String amount) {
        TransferRsDto transferRsDto = super.fundTransfer(accountNo, amount);
        if (Status.SUCCESS.ordinal() == transferRsDto.getStatus()){
            log.info("Successfully fund transfer. send push notification..");
            notificationService.send("{generator processing id}", Status.SUCCESS.name(), Type.PUSH.name());
        }
        return transferRsDto;
    }

}
