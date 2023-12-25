package id.saputra.adi.oop.customers.service;

import id.saputra.adi.oop.customers.dao.Customer;
import id.saputra.adi.oop.customers.dto.CustomerDto;
import id.saputra.adi.oop.customers.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Customer inquiry by mobile phone
     * @param mobilePhone mobile phone
     * @return customer is present return dto customer, otherwise null.
     */
    public CustomerDto customerInquiry(String mobilePhone) {
        log.info("Starting customer inquiry by mobile phone [{}]", mobilePhone);
        Optional<Customer> customer = customerRepository.findByMobilePhone(mobilePhone);
        if (customer.isPresent()) {
            log.info("Customer with mobile phone [{}] is found.", mobilePhone);
            log.debug("Customer data {}", customer.get());
            return constructDto(customer.get());
        }
        return null;
    }

    /**
     * Customer inquiry by mobile phone and cif
     * @param mobilePhone customer mobile phone
     * @param cif customer cif
     * @return customer is present return dto customer, otherwise null.
     */
    public CustomerDto customerInquiry(String mobilePhone, String cif) {
        log.info("Starting customer inquiry by mobile phone [{}] and cif [{}]", mobilePhone, cif);
        Optional<Customer> customer = customerRepository.findByMobilePhoneAndCif(mobilePhone, cif);
        if (customer.isPresent()) {
            log.info("Customer with mobile phone [{}] and cif [{}] is found.", mobilePhone, cif);
            log.debug("Customer data {}", customer.get());
            return constructDto(customer.get());
        }
        log.info("Customer with mobile phone [{}] and cif [{}] not found.", mobilePhone, cif);
        return null;
    }

    /**
     * constructor from data access to data transfer
     * @param customer {@link Customer}
     * @return customerDto {@link CustomerDto}
     */
    protected CustomerDto constructDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCif(customer.getCif());
        customerDto.setMobilePhone(customer.getMobilePhone());
        customerDto.setName(customer.getName());
        return customerDto;
    }
}
