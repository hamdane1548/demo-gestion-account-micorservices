package net.oussama.micordemo;

import lombok.AllArgsConstructor;
import net.oussama.micordemo.Services.Impl.AccountServicesImpl;
import net.oussama.micordemo.constant.AccountConstant;
import net.oussama.micordemo.dtos.AccountDto;
import net.oussama.micordemo.dtos.CustomersDto;
import net.oussama.micordemo.dtos.ResponseDto;
import net.oussama.micordemo.exeption.CustomerAleradyExistExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountControlleur {
    private AccountServicesImpl accountServices;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomersDto customersDto) throws CustomerAleradyExistExeption {
        accountServices.createAccount(customersDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstant.STATUS_201,AccountConstant.MESSAGE_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<CustomersDto> getinfocutomers(@RequestParam String phone){
         CustomersDto customersDto=accountServices.fetchAccount(phone);
          return ResponseEntity
                  .status(HttpStatus.ACCEPTED)
                  .body(customersDto);
    }

}
