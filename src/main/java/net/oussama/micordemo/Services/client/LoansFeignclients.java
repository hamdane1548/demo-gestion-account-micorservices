package net.oussama.micordemo.Services.client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import net.oussama.micordemo.dtos.CardsDto;
import net.oussama.micordemo.dtos.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("Loans")
public interface LoansFeignclients {
    @GetMapping(value = "/api/fetch",consumes = "application/json")
    public ResponseEntity<LoansDto> fetch(@RequestParam String phone);
}
