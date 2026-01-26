package net.oussama.cards.Services.Impl;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import net.oussama.cards.Dto.CardsDto;
import net.oussama.cards.Exeption.CardAlerdayExistsExption;
import net.oussama.cards.Services.ServicesCard;
import net.oussama.cards.entites.Cards;
import net.oussama.cards.mappers.CardsMappers;
import net.oussama.cards.repository.CardsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardsImplServices implements ServicesCard {
    private CardsRepository cardsRepository;
    @Override
    public void createCards(CardsDto cardsDto) {
        Optional<Cards> cards= cardsRepository.findBycard_number(cardsDto.getCard_number());
        if(cards.isPresent()){
            throw new CardAlerdayExistsExption("card already exists");
        }
        Cards cards_create = CardsMappers.toCards(cardsDto);
        cardsRepository.save(cards_create);
    }

    @Override
    public CardsDto getCard(String card_number) {
        Cards cards=cardsRepository.findBycard_number(card_number).orElseThrow(
                () -> new CardAlerdayExistsExption("card not found")
        );
        return CardsMappers.toCardsDto(cards);
    }

    @Override
    public void updateCard(CardsDto cardsDto) {
          Cards cards=cardsRepository.findBycard_number(cardsDto.getCard_number()).orElseThrow(
                  () -> new CardAlerdayExistsExption("card not found")
          );
          cards.setAvailable_amount(cardsDto.getAvailable_amount());
          cards.setCard_type(cardsDto.getCard_type());
          cards.setCard_number(cardsDto.getCard_number());;
          cardsRepository.save(cards);
    }

    @Override
    public void  deletecard(String phone_number){
        Cards cards = cardsRepository.findBy_phone(phone_number).orElseThrow(
                () -> new CardAlerdayExistsExption("card not found")
        );
        cardsRepository.delete(cards);
    }
}
