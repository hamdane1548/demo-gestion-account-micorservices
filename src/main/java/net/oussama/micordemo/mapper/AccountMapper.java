package net.oussama.micordemo.mapper;

import net.oussama.micordemo.dtos.AccountDto;
import net.oussama.micordemo.entites.AccountEntity;

public class AccountMapper {
    public static AccountDto maptoAccountDto(AccountEntity accountEntity) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(accountEntity.getAccountNumber());
        accountDto.setAccountType(accountEntity.getAccountType());
        accountDto.setBranchAddress(accountEntity.getBranchAddress());
        accountDto.setCustomerNumber(accountEntity.getCustomerNumber());
        return accountDto;
    }
    public static AccountEntity maptoAccountEntity(AccountDto accountDto) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(accountDto.getAccountNumber());
        accountEntity.setAccountType(accountDto.getAccountType());
        accountEntity.setBranchAddress(accountDto.getBranchAddress());
        accountEntity.setCustomerNumber(accountDto.getCustomerNumber());
        return accountEntity;
    }
}
