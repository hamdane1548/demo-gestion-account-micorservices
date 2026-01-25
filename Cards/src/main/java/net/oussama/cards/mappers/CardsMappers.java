package net.oussama.cards.mappers;

import net.oussama.cards.Dto.CardsDto;
import net.oussama.cards.entites.Cards;
import org.springframework.beans.BeanUtils;

public class CardsMappers {
    public static CardsDto toCardsDto(Cards cards) {
        CardsDto cardsDto = new CardsDto();
        BeanUtils.copyProperties(cards, cardsDto);
        return cardsDto;
    }
    public static Cards toCards(CardsDto cardsDto) {
        Cards cards = new Cards();
        BeanUtils.copyProperties(cardsDto, cards);
        return cards;
    }
}
