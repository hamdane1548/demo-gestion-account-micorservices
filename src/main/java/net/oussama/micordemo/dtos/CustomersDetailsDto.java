package net.oussama.micordemo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Optional;

@Data
public class CustomersDetailsDto {
    private CustomersDto customerdto;
    private CardsDto cards;
    private LoansDto loans;
}
