package net.oussama.loans.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class Loans extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mobile_number;
    private String loan_number;
    private String loan_type;
    private String total_loan;
    private String amount_paid;
    private String outstanding_amount;
}
