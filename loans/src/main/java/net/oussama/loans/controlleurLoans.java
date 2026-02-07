package net.oussama.loans;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import net.oussama.loans.Dto.AccountEnvSupportDto;
import net.oussama.loans.Dto.LoansDto;
import net.oussama.loans.Dto.ResponseDto;
import net.oussama.loans.Services.Impl.LoansServiceImpl;
import net.oussama.loans.constant.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class controlleurLoans {
    private LoansServiceImpl loansservice;
    private AccountEnvSupportDto accountenv;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@Valid @RequestBody LoansDto loansDto){
        loansservice.CreateLoans(loansDto);
        return new ResponseEntity<>(new ResponseDto(
                Constant.STATUS_200,
                "created"
        ), HttpStatus.CREATED);
    }
   @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetch(@RequestParam @Valid @Pattern(regexp = "(^([0-9]{10}))",message = "number most be valid") String phone,@RequestHeader("eazybank-id-request") String correlationId){
        LoansDto loansDto = loansservice.fetchLoans(phone);
        return new ResponseEntity<>(loansDto,HttpStatus.OK);
   }
   @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody LoansDto loansDto){
        Boolean update = loansservice.updateLoans(loansDto);
       return update?  ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDto("updated",Constant.STATUS_200)) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("file to update",Constant.STATUS_500));
   }
   @GetMapping("/supportinfo")
   public ResponseEntity<AccountEnvSupportDto> getAccountEnvSupport(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(accountenv);
    }

}
