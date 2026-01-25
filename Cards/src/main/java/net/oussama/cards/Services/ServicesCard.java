package net.oussama.cards.Services;

import net.oussama.cards.Dto.CardsDto;

import java.util.Optional;

public interface ServicesCard {
    /**
     *
     * @param cardsDto
     */
    void createCards(CardsDto cardsDto);

    /**
     *
     * @param card_number
     * @return
     */
    CardsDto getCard(String card_number);
    void updateCard(CardsDto cardsDto);
}
