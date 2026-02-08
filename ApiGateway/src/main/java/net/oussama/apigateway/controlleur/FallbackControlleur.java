package net.oussama.apigateway.controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackControlleur {
    @RequestMapping("/contactSupport")
    public Mono<String> FallbackControlleur() {
       return Mono.just("fallback erreur dans mon serveur essaie ou next time pls");
    }
}
