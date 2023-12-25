package id.saputra.adi.oop.transfer.controller;

import id.saputra.adi.oop.constant.ApiVersion;
import id.saputra.adi.oop.transfer.dto.TransferRqDto;
import id.saputra.adi.oop.transfer.service.FundTransferEnhance;
import id.saputra.adi.oop.transfer.service.IFundTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    private static final Logger log = LoggerFactory.getLogger(TransferController.class);
    private static final String PREFIX_TRACE_ERROR = "Trace error : ";

    @Autowired
    @Qualifier("IFundTransfer")
    private IFundTransfer fundTransfer;

    @Autowired
    @Qualifier("FundTransferEnhance")
    private FundTransferEnhance fundTransferEnhance;

    @PostMapping(value = "/inquiry", consumes = ApiVersion.V1)
    @ResponseBody
    public ResponseEntity<Object> accountInq (@RequestBody TransferRqDto transferRqDto){
        try {
            log.info("Inbound traffic from /transfer/inquiry endpoint with request body {}", transferRqDto);
            return ResponseEntity.ok(fundTransfer.accountInquiry(transferRqDto.getAccountNo(), transferRqDto.getAmount()));
        } catch (Exception ex){
            log.error("Happened error when account inquiry. Error {}", ex.getMessage());
            log.trace(PREFIX_TRACE_ERROR, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/fund", consumes = ApiVersion.V1)
    @ResponseBody
    public ResponseEntity<Object> fund (@RequestBody TransferRqDto transferRqDto){
        try {
            log.info("Inbound traffic from /transfer/fund endpoint with request body {}", transferRqDto);
            return ResponseEntity.ok(fundTransfer.fundTransfer(transferRqDto.getAccountNo(), transferRqDto.getAmount()));
        } catch (Exception ex){
            log.error("Happened error when fund transfer. Error {}", ex.getMessage());
            log.trace(PREFIX_TRACE_ERROR, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/inquiry", consumes = ApiVersion.V2)
    @ResponseBody
    public ResponseEntity<Object> accountInqEnhance (@RequestBody TransferRqDto transferRqDto){
        try {
            log.info("Inbound traffic from /transfer/inquiry v2 endpoint with request body {}", transferRqDto);
            return ResponseEntity.ok(fundTransferEnhance.accountInquiry(transferRqDto.getAccountNo(), transferRqDto.getAmount()));
        } catch (Exception ex){
            log.error("Happened error when account inquiry. Error {}", ex.getMessage());
            log.trace(PREFIX_TRACE_ERROR, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/fund", consumes = ApiVersion.V2)
    @ResponseBody
    public ResponseEntity<Object> fundEnhance (@RequestBody TransferRqDto transferRqDto){
        try {
            log.info("Inbound traffic from /transfer/fund v2 endpoint with request body {}", transferRqDto);
            return ResponseEntity.ok(fundTransferEnhance.fundTransfer(transferRqDto.getAccountNo(), transferRqDto.getAmount()));
        } catch (Exception ex){
            log.error("Happened error when fund transfer. Error {}", ex.getMessage());
            log.trace(PREFIX_TRACE_ERROR, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
