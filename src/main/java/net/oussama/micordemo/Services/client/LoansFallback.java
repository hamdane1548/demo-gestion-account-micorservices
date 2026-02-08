package net.oussama.micordemo.Services.client;

import net.oussama.micordemo.dtos.LoansDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Fallback;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignclients {
    @Override
    public ResponseEntity<LoansDto> fetch(String phone, String correlationId) {
        return null;
    }
}
