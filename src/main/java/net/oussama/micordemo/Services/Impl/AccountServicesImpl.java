package net.oussama.micordemo.Services.Impl;

import lombok.AllArgsConstructor;
import net.oussama.micordemo.Services.IAccountService;
import net.oussama.micordemo.constant.AccountConstant;
import net.oussama.micordemo.dtos.AccountDto;
import net.oussama.micordemo.dtos.CustomersDto;
import net.oussama.micordemo.entites.AccountEntity;
import net.oussama.micordemo.entites.Customers;
import net.oussama.micordemo.exeption.CustomerAleradyExistExeption;
import net.oussama.micordemo.exeption.ResourceNotFoundException;
import net.oussama.micordemo.mapper.CustomerMapper;
import net.oussama.micordemo.repository.AccountReositroy;
import net.oussama.micordemo.repository.CustomersRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServicesImpl implements IAccountService {
    private AccountReositroy accountReositroy;
    private CustomersRepositroy  customersRepositroy;
    @Override
    public void createAccount(CustomersDto customersDto) throws CustomerAleradyExistExeption {
        Customers customers= CustomerMapper.maptoCustomers(customersDto);
        Optional<Customers> optionalCustomers=customersRepositroy.finByphone(customersDto.getPhone());
        if(optionalCustomers.isPresent()){
            throw new CustomerAleradyExistExeption("customer deja exists");
        }
        customers.setCreadtedBy(customersDto.getName());
        customers.setCreationDate(LocalDateTime.now());
        Customers customersId =customersRepositroy.save(customers);
        accountReositroy.save(createAccount(customersId));
    }
    @Override
    public CustomersDto fetchAccount(String phone)  {
        Customers customers=customersRepositroy.finByphone(phone).orElseThrow(()->{
            return  new ResourceNotFoundException("Customers","mobileNumber",phone);
        });
        System.out.println(customers.getId());
        AccountEntity account=accountReositroy.findBycustomerNumber(customers.getId()).orElseThrow(()-> new ResourceNotFoundException("Account","customer",String.valueOf(customers.getId())));
        CustomersDto customersDto=CustomerMapper.maptoCustomerDto(customers);
        customersDto.setAccount(Optional.ofNullable(account));
        return customersDto;
    }

        private AccountEntity createAccount(Customers customers) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCustomerNumber(customers.getId());
        long ramdhom=100000 + new Random().nextInt(9999);
        accountEntity.setAccountNumber(ramdhom);
        accountEntity.setAccountType(AccountConstant.SAVING);
        accountEntity.setBranchAddress(AccountConstant.ADDRESS);
        return accountEntity;
    }
}
