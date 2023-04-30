package fr.agregio.call.config.preload;

import fr.agregio.call.model.Reserve;
import fr.agregio.call.repository.ReserveRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
class ReservePreloader {

  private static final Logger log = Logger.getLogger(ReservePreloader.class.getName());

  @Bean
  CommandLineRunner initDatabase(ReserveRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Reserve()));
      log.info("Preloading " + repository.save(new Reserve()));
    };
  }
}