package net.oussama.micordemo.Services;

import net.oussama.micordemo.dtos.CustomersDto;
import net.oussama.micordemo.exeption.CustomerAleradyExistExeption;

import javax.security.auth.login.AccountNotFoundException;

public interface IAccountService {
    /**
     *
     * @param customersDto -CustomerDto object
     */
    void createAccount(CustomersDto customersDto) throws CustomerAleradyExistExeption;

    /**
     *
     * @param phone
     * @return Customer Dto
     */
    CustomersDto fetchAccount(String phone);
}
