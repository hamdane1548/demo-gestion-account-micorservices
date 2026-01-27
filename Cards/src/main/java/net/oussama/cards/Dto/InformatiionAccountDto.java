package net.oussama.cards.Dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "accounts")
public record InformatiionAccountDto(String message, Map<String,String> accounts, List<String> contact) {
}
