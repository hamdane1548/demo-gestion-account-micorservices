package net.oussama.cards;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import net.oussama.cards.Dto.CardsDto;
import net.oussama.cards.Dto.InformatiionAccountDto;
import net.oussama.cards.Dto.ResponseDto;
import net.oussama.cards.Services.Impl.CardsImplServices;
import net.oussama.cards.constant.CardsConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CardsControlleur {
    private InformatiionAccountDto informatiionAccountDto;
    private CardsImplServices  cardsService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCards(@Valid @RequestBody CardsDto cardsDto) {
        cardsService.createCards(cardsDto);
        ResponseDto responseDto = new ResponseDto(CardsConstant.STATUS_200,CardsConstant.MESSAGE_200);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchCards(@RequestParam @Size(min=3,max = 15,message = "Donne un numero de card valid") String number_cards) {
        CardsDto cardsDto = cardsService.getCard(number_cards);
        return new ResponseEntity<>(cardsDto, HttpStatus.OK);

    }
    @GetMapping("/fetch_cardsnumber")
    public ResponseEntity<CardsDto> fetchCardsPhone(@RequestParam @Pattern(regexp = "(^([0-9]{10}))") String phone_number){
        CardsDto cardsdto = cardsService.getCardsBynumber(phone_number);
        return new ResponseEntity<>(cardsdto, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardsDto cardsDto) {
        cardsService.updateCard(cardsDto);
        return new ResponseEntity<>(new ResponseDto(CardsConstant.STATUS_200,CardsConstant.MESSAGE_200), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deletecard(@Valid @RequestBody CardsDto cardsDto){
        cardsService.deletecard(cardsDto.getMobile_number());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(CardsConstant.STATUS_200,CardsConstant.MESSAGE_200));
    }
    @GetMapping("/support-contact")
    public ResponseEntity<InformatiionAccountDto> ContactSupport(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(informatiionAccountDto);
    }

}
