package com.vcs.bankApplication.repository;

import com.vcs.bankApplication.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Derived-Method Named-Query
    List<Customer> findByEmail(String email);
}
