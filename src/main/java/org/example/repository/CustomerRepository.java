package org.example.repository;

import org.example.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

    Customers findByCpf(String cpf);
}
