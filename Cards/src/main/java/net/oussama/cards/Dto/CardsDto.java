package net.oussama.cards.Dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CardsDto {
    @NotEmpty(message = "le card number ne doit pas etre null")
    private String card_number;
    @Pattern(regexp = "(^([0-9]{10}))",message = "Mobile number most be +212+your number ")
    private String mobile_number;
    @NotEmpty(message = "ne doit pas etre null")
    private String card_type;
    @NotEmpty(message = "ne doit pas etre null")
    private String total_limit;
    private String available_amount;
}
