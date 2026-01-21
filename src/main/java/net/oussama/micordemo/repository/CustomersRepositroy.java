package net.oussama.micordemo.repository;

import net.oussama.micordemo.entites.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepositroy extends JpaRepository<Customers,Long> {
    @Query("SELECT c from Customers c where c.phone like :phone")
    Optional<Customers>  finByphone(@Param("phone") String phone);
}
