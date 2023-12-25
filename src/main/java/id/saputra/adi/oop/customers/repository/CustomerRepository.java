package id.saputra.adi.oop.customers.repository;

import id.saputra.adi.oop.customers.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM CUSTOMER where MOBILE_PHONE = :mobilePhone", nativeQuery = true)
    Optional<Customer> findByMobilePhone(@Param("mobilePhone") String mobilePhone);

    @Query(value = "SELECT * FROM CUSTOMER where MOBILE_PHONE = :mobilePhone and CIF = :cif", nativeQuery = true)
    Optional<Customer> findByMobilePhoneAndCif(@Param("mobilePhone") String mobilePhone, @Param("cif") String cif);

}
