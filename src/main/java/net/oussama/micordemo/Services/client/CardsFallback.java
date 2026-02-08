package net.oussama.micordemo.Services.client;

import net.oussama.micordemo.dtos.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignclients{
    @Override
    public ResponseEntity<CardsDto> fetchCardsPhone(String phone_number, String correlationId) {
        return null;
    }
}
