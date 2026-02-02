package net.oussama.micordemo.dtos;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "accounts")
@Getter @Setter
public class AccountContactInfoDTo{
    private String message;
    private List<String> onCallSupport;
    private Map<String,String> contactDetails;

}
