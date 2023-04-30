package fr.agregio.call.repository;

import fr.agregio.call.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BlockRepository<T extends Block> extends JpaRepository<T, Long> {
}