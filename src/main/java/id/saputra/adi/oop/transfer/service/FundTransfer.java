package id.saputra.adi.oop.transfer.service;

import id.saputra.adi.oop.transfer.dto.TransferRsDto;
import id.saputra.adi.oop.transfer.exception.TransferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
public abstract class FundTransfer {
    private static final Logger log = LoggerFactory.getLogger(FundTransfer.class);
    public BigDecimal balanceInquiry(){
        return new BigDecimal("100000000");
    }
    /**
     *  Balance validation
     * @param balance : account balance
     * @param amount : transfer amount
     * @throws TransferException transfer amount > account balance
     */
    public void balanceValidation(BigDecimal balance, BigDecimal amount) throws TransferException {
        if (balance.compareTo(amount) > 0){
            log.error("Sufficient funds.. transfer amount [{}], account balance[{}]", amount, balance);
            throw new TransferException("Sufficient funds.");
        }
    }
    public abstract TransferRsDto accountInquiry(String accountNo, String amount) throws TransferException;

    public abstract TransferRsDto fundTransfer(String accountNo, String amount);
}
