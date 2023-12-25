package id.saputra.adi.oop.customers.controller;

import id.saputra.adi.oop.constant.ApiVersion;
import id.saputra.adi.oop.customers.dto.CustomerDto;
import id.saputra.adi.oop.customers.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private static final String PREFIX_TRACE_ERROR = "Trace error : ";

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/inquiry", consumes = ApiVersion.V1)
    @ResponseBody
    public ResponseEntity<Object> inquiryByMobilePhone (@RequestBody CustomerDto customerDto){
        try {
            log.info("Inbound traffic from inquiry endpoint with request body {}", customerDto);
            return ResponseEntity.ok(customerService.customerInquiry(customerDto.getMobilePhone()));
        } catch (Exception ex){
            log.error("Happened error when inquiry customer. Error {}", ex.getMessage());
            log.trace(PREFIX_TRACE_ERROR, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "/inquiry", consumes = ApiVersion.V2)
    @ResponseBody
    public ResponseEntity<Object> inquiryByMobilePhoneAndCif (@RequestBody CustomerDto customerDto){
        try {
            log.info("Inbound traffic from inquiry endpoint with request body {}", customerDto);
            return ResponseEntity.ok(customerService.customerInquiry(customerDto.getMobilePhone(), customerDto.getCif()));
        } catch (Exception ex){
            log.error("Happened error when inquiry customer. Error {}", ex.getMessage());
            log.trace(PREFIX_TRACE_ERROR, ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
