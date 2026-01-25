package net.oussama.loans.Repository;

import net.oussama.loans.entites.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepositroy extends JpaRepository<Loans,Long> {
    @Query("select l from Loans l where l.loan_number like :wq")
    Optional<Loans> findByLoan_Number(@Param("wq") String loan_Number);

    @Query("select l from Loans l WHERE l.mobile_number like :phone")
    Optional<Loans> findby_phoneNumber(@Param("phone") String phone);
}
