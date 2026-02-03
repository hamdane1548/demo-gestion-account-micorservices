package net.oussama.micordemo.Services.Impl;

import lombok.AllArgsConstructor;
import net.oussama.micordemo.Services.ICustomersServices;
import net.oussama.micordemo.Services.client.CardsFeignclients;
import net.oussama.micordemo.Services.client.LoansFeignclients;
import net.oussama.micordemo.dtos.*;
import net.oussama.micordemo.entites.AccountEntity;
import net.oussama.micordemo.entites.Customers;
import net.oussama.micordemo.exeption.ResourceNotFoundException;
import net.oussama.micordemo.mapper.AccountDetailsMappers;
import net.oussama.micordemo.mapper.AccountMapper;
import net.oussama.micordemo.mapper.CustomerMapper;
import net.oussama.micordemo.repository.AccountReositroy;
import net.oussama.micordemo.repository.CustomersRepositroy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomersServicesImpl implements ICustomersServices {
    private AccountReositroy   accountReositroy;
    private CustomersRepositroy customersRepositroy;
    private CardsFeignclients  cardsFeignclients;
    private LoansFeignclients loansFeignclients;
    @Override
    public CustomersDetailsDto getCustomers(String phone_number) {
       Customers customers = customersRepositroy.finByphone(phone_number).orElseThrow(
               ()-> new ResourceNotFoundException("customer","phone",phone_number)
       );
        AccountEntity account=accountReositroy.findBycustomerNumber(customers.getId()).orElseThrow(()-> new ResourceNotFoundException("Account","customer",String.valueOf(customers.getId())));
        AccountDto accountDto =  AccountMapper.maptoAccountDto(account);
        CustomersDto customersDto = CustomerMapper.maptoCustomerDto(customers);
        customersDto.setAccount(Optional.ofNullable(accountDto));
        CustomersDetailsDto customersDetailsDto = AccountDetailsMappers.customertoAccountDetailsMappers(customersDto);
        ResponseEntity<LoansDto> loansfetchdata = loansFeignclients.fetch(phone_number);
        ResponseEntity<CardsDto> cardsfetchdata = cardsFeignclients.fetchCardsPhone(phone_number);
        customersDetailsDto.setCards(cardsfetchdata.getBody());
        customersDetailsDto.setLoans(loansfetchdata.getBody());
        customersDetailsDto.setCustomerdto(customersDto);
        return customersDetailsDto;
    }
}
