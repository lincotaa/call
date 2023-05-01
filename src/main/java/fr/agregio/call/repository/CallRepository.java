package fr.agregio.call.repository;

import fr.agregio.call.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CallRepository extends JpaRepository<Call, Long> {
    Call findByReserve_IdAndDay(Long id, Date day);

}