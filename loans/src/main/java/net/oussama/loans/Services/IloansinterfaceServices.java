package net.oussama.loans.Services;

import net.oussama.loans.Dto.LoansDto;
import net.oussama.loans.entites.Loans;
import org.springframework.stereotype.Service;

public interface IloansinterfaceServices {
    void CreateLoans(LoansDto loansDto);
    LoansDto fetchLoans(String phone_number);
    Boolean updateLoans(LoansDto loansDto);
}
