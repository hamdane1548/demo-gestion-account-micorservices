package net.oussama.micordemo.dtos;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "accounts")
public record AccountContactInfoDTo(String message, Map<String,String> contactDetails, List<String> oncallsupport) {

}
