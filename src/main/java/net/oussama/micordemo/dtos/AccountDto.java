package net.oussama.micordemo.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AccountDto {
    private Long customerNumber;
    private String accountType;
    private String branchAddress;
}
