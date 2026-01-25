package net.oussama.loans.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class LoansDto{
    @Pattern(regexp = "(^([0-9]{10}))",message = "le mobile number doit etre suite de format 06.... 10 number")
    private String mobile_number;
    @NotEmpty(message = "le loan number ne doit pas etre null")
    private String loan_number;
    @NotEmpty(message = "le loan type ne doit pas etre null")
    private String loan_type;
    private String total_loan;
    private String amount_paid;
    private String outstanding_amount;
}
