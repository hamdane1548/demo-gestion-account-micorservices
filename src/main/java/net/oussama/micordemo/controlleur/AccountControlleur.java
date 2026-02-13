package net.oussama.micordemo.controlleur;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import net.oussama.micordemo.Services.Impl.AccountServicesImpl;
import net.oussama.micordemo.constant.AccountConstant;
import net.oussama.micordemo.dtos.AccountContactInfoDTo;
import net.oussama.micordemo.dtos.CustomersDto;
import net.oussama.micordemo.dtos.ResponseDto;
import net.oussama.micordemo.exeption.CustomerAleradyExistExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated

@Tag(
        name = "CRUD REST API FOR CUSTOMERS AND ACCOUNT",
        description = "CRUD OPERATION FOR CUSTOMERS AND ACCOUNT BANK "
)
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountControlleur {
    private final AccountServicesImpl accountServices;
    public AccountControlleur(AccountServicesImpl accountServices) {
        this.accountServices = accountServices;
    }
    @Value("${build.version}")
    private String version;
    @Autowired
    private AccountContactInfoDTo accountContactInfoDTo;
    @Autowired
    private Environment environment;

    @Operation(
            summary = "Create account rest api",
            description = "rest api to create customers and account in applcation"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status Created"
    )

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomersDto customersDto) throws CustomerAleradyExistExeption {
        accountServices.createAccount(customersDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstant.STATUS_201,AccountConstant.MESSAGE_201));
    }
    @GetMapping("/fetch")
    public ResponseEntity<CustomersDto> getinfocutomers(@RequestParam @Pattern(regexp = "(^([0-9]{10}))" , message = "mobile number most be +212{8 caracter}") String phone){
         CustomersDto customersDto=accountServices.fetchAccount(phone);
          return ResponseEntity
                  .status(HttpStatus.ACCEPTED)
                  .body(customersDto);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomersDto customersDto){
         Boolean check=accountServices.updateAccount(customersDto);
        if (check) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(AccountConstant.STATUS_500,AccountConstant.MESSAGE_500));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deletecustomersandaccount(@RequestParam @Pattern(regexp = "(^([0-9]{10}))",message = "mobile number most be +212{8 caracter}") String phone){
        Boolean delete=accountServices.deleteAccount(phone);
       return   delete? ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200)) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(AccountConstant.STATUS_500,AccountConstant.MESSAGE_500));
    }
    @Operation(
            summary = "Fetch version de notre application",
            description = "fetch la version de notre application via une rest api de type get"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status ok = 200"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "erreur de appele la methode de fetch api de get version"

            )}
    )

    @GetMapping("/envariable")
    public ResponseEntity<String> getbuildenvvariable(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(environment.getProperty("JAVA_HOME"));
    }
    @Operation(
            summary = "Fetch contact de notre application",
            description = "fetch la version de notre application via une rest api de type get"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status ok = 200"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "erreur de appele la methode de fetch api de get version"

            )}
    )
    @GetMapping("/contact-info")
    public ResponseEntity<AccountContactInfoDTo> getcontactinfo(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(accountContactInfoDTo);
    }
    @RateLimiter(name = "ratelimitertest")
    @Retry(name = "GET_VERSION", fallbackMethod = "getVersionfallback")
    @GetMapping("/version")
    public ResponseEntity<String> getVersion(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(version);
    }
    public ResponseEntity<String> getVersionfallback(Throwable throwable){
        System.out.println("oussama");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("tet 5");
    }
}
