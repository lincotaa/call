package fr.agregio.call.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
    Map<String, String> repartitionkey = new HashMap<>();
}
