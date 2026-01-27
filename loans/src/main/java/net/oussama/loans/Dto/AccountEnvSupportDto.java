package net.oussama.loans.Dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "contact")
public record AccountEnvSupportDto(String message, Map<String,String> contact, List<String> support) {
}
