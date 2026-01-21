package net.oussama.micordemo.dtos;

import lombok.Data;
import net.oussama.micordemo.entites.AccountEntity;

import java.util.Optional;

@Data
public class CustomersDto {
    private String name;
    private String email;
    private String address;
    private String phone;
    private Optional<AccountEntity> account;
}
