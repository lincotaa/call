package fr.agregio.call.repository;

import fr.agregio.call.model.BlockProducer;
import fr.agregio.call.model.enums.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlockProducerRepository extends JpaRepository<BlockProducer, Long> {
    //Update BlockProducer when allocating part or whole available power to a call for tenders on a specific reserve
    @Transactional
    @Modifying
    @Query("""
            update BlockProducer b set b.allocatedPower = ?1, b.availablePower = ?2
            where b.id = ?3""")
    void updateAllocatedPowerAndAvailablePowerByAllocatedPowerAndAvailablePower(@NonNull Double allocatedPower,
                                                                                @NonNull Double availablePower,
                                                                                @NonNull Long blockProducerId);

    //List all Power Supply for the corresponding day
    List<BlockProducer> findByDay(@NonNull String day);

    //List all Power Supply for the corresponding day and step
    List<BlockProducer> findByDayAndStep(@NonNull String day,
                                         Step step);

    // Purging old blocks after a while
    long deleteByDay(@NonNull String day);
}