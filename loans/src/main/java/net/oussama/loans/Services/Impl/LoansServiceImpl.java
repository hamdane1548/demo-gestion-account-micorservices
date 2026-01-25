package net.oussama.loans.Services.Impl;

import lombok.AllArgsConstructor;
import net.oussama.loans.Dto.LoansDto;
import net.oussama.loans.Exeption.LoansAleradyExists;
import net.oussama.loans.Mappers.LoanMapper;
import net.oussama.loans.Repository.LoansRepositroy;
import net.oussama.loans.Services.IloansinterfaceServices;
import net.oussama.loans.entites.Loans;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements IloansinterfaceServices {
    private LoansRepositroy loansrepositroy;
    @Override
    public void CreateLoans(LoansDto loansDto) {
        Optional<Loans> loans = loansrepositroy.findByLoan_Number(loansDto.getLoan_number());
        if (loans.isPresent()) {
            throw new LoansAleradyExists("Loan already exists");
        }
        loansrepositroy.save( LoanMapper.maptoLoans(loansDto));
    }

    @Override
    public LoansDto fetchLoans(String phone_number) {
     Loans loans = loansrepositroy.findby_phoneNumber(phone_number).orElseThrow(
             () ->new LoansAleradyExists("Loan Not Found with this number pls check your number")
     );
     return LoanMapper.maptoLoansDto(loans);

    }

    @Override
    public Boolean updateLoans(LoansDto loansDto) {
        Loans loans=loansrepositroy.findby_phoneNumber(loansDto.getMobile_number()).orElseThrow(
                ()-> new LoansAleradyExists("Loan Not Found with this number pls check your number")
        );
        System.out.println(loans);
        loans.setLoan_number(loansDto.getLoan_number());
        loans.setTotal_loan(loansDto.getTotal_loan());
        loans.setAmount_paid(loansDto.getAmount_paid());
        loans.setAmount_paid(loansDto.getAmount_paid());
        loans.setOutstanding_amount(loansDto.getOutstanding_amount());
        Loans loans_status=loansrepositroy.save(loans);
        if(loans_status != null) {
            return true;
        }
        return false;
    }
}
