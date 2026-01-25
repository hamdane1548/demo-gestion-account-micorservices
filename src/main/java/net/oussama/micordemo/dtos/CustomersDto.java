package net.oussama.micordemo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import net.oussama.micordemo.entites.AccountEntity;

import java.util.Optional;

@Data
@Schema(
        name = "Customers",
        description = "Schema to hold customers and account informations"
)
public class CustomersDto {
    @Schema(
            description = "Name of the customers" , example = "Oussama"
    )
    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(max = 30,min = 4,message = "min caractere is between 4 and 30")
    private String name;
    @NotEmpty(message = "Email cannot be a null or empty")
    @Email(message = "Email addresse should be validate formats")
    private String email;
    @NotEmpty(message = "you must write an address")
    private String address;
    @Pattern(regexp = "(^([0-9]{10}))",message = "Mobile number most be +212+your number ")
    private String phone;
    private Optional<AccountDto> account;
}
