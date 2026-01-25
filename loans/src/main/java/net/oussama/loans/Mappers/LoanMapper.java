package net.oussama.loans.Mappers;

import net.oussama.loans.Dto.LoansDto;
import net.oussama.loans.entites.Loans;
import org.springframework.beans.BeanUtils;

public class LoanMapper {
    public static Loans maptoLoans(LoansDto loansdto) {
        Loans loans = new Loans();
        BeanUtils.copyProperties(loansdto, loans);
        return loans;
    }
    public static LoansDto maptoLoansDto(Loans loans){
        LoansDto loansDto = new LoansDto();
        BeanUtils.copyProperties(loans, loansDto);
        return loansDto;
    }
}
