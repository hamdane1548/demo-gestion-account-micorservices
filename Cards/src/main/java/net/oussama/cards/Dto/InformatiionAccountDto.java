package net.oussama.cards.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "accounts")
@Getter @Setter
public class InformatiionAccountDto {
    private String message;
    private Map<String,String> contact;
    private List<String> support;
}
