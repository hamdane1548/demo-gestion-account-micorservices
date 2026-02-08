package net.oussama.micordemo.Services.client;

import jakarta.validation.constraints.Pattern;
import net.oussama.micordemo.dtos.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards",fallback =  CardsFallback.class)
public interface CardsFeignclients {
    @GetMapping(value = "/api/fetch_cardsnumber",consumes = "application/json")
    public ResponseEntity<CardsDto> fetchCardsPhone(@RequestParam  String phone_number,@RequestHeader("eazybank-id-request") String correlationId);
}
