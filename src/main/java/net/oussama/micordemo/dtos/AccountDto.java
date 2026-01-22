package net.oussama.micordemo.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {
    @NotEmpty(message = "the account Number most be not empty or null")
    @Pattern(regexp = "(^.([0-9]{10}))",message = "account number most be a validate format")
    private Long accountNumber;
    private Long customerNumber;
    @NotEmpty(message = "account type most not be empty or null")
    private String accountType;
    @NotEmpty(message = "branch Address most not be empty or null")

    private String branchAddress;
}
