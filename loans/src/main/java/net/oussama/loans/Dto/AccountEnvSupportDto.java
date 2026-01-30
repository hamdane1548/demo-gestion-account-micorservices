package net.oussama.loans.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "contact")
@Getter
@Setter
public class AccountEnvSupportDto {
    private String message;
    private Map<String,String> contact;
    private List<String> support;
}
