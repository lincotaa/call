package fr.agregio.call.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BlockRepository<T extends BlockOLD> extends JpaRepository<T, Long> {
}