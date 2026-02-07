package net.oussama.micordemo.controlleur;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import net.oussama.micordemo.Services.Impl.CustomersServicesImpl;
import net.oussama.micordemo.dtos.CustomersDetailsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Tag(
        name = "rest controlleuer of customers services",
        description = "le rest controlleur de fetch le data de customers and create customers"
)
@RestController
@RequestMapping(value = "/api/customers",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class CustomersControlleur {
    private  CustomersServicesImpl customersServicesImpl;
    @GetMapping("/fetch")
    public ResponseEntity<CustomersDetailsDto> fetchCustomers(
            @RequestHeader("eazybank-id-request") String correlationId,
            @RequestParam @Valid @Pattern( regexp = "(^([0-9]{10}))",message = "not valid") String phone_number){
        CustomersDetailsDto customersDetailsDto =  customersServicesImpl.getCustomers(phone_number,correlationId);
        return ResponseEntity.status(HttpStatus.OK).body(customersDetailsDto);
    }
}
