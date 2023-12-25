package id.saputra.adi.oop.transfer.service;

import id.saputra.adi.oop.transfer.constant.Status;
import id.saputra.adi.oop.transfer.dto.TransferRsDto;
import id.saputra.adi.oop.transfer.exception.TransferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("IFundTransfer")
public class IFundTransfer extends FundTransfer {
    private static final Logger log = LoggerFactory.getLogger(IFundTransfer.class);

    @Override
    public TransferRsDto accountInquiry(String accountNo, String amount) throws TransferException {
        log.info("Starting account inquiry with account no [{}], amount [{}]", accountNo, amount);

        //TODO put your here

        TransferRsDto response = new TransferRsDto();
        response.setAccountNo(accountNo);
        response.setAmount(amount);
        response.setStatus(Status.SUCCESS.ordinal());
        return response;
    }

    @Override
    public TransferRsDto fundTransfer(String accountNo, String amount) {
        log.info("Starting fund transfer to beneficiary account no [{}], amount [{}]", accountNo, amount);

        //TODO put your here

        TransferRsDto response = new TransferRsDto();
        response.setAccountNo(accountNo);
        response.setAmount(amount);
        response.setStatus(Status.SUCCESS.ordinal());
        return response;
    }
}
