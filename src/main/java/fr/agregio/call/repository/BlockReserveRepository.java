package fr.agregio.call.repository;

import fr.agregio.call.model.BlockReserve;
import fr.agregio.call.model.ProductionGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface BlockReserveRepository extends JpaRepository<BlockReserve, Long> {

    //List all Power Blocks corresponding to the call where productionGroup is not NULL (i.e. detailed traceability)
    @Query("select b from BlockReserve b where b.call.id = ?1 and b.productionGroup = ?2")
    List<BlockReserve> findByCall_IdAndProductionGroup(@NonNull Long id, @NonNull ProductionGroup productionGroup);

    //List all Power Blocks corresponding to the call where productionGroup is NULL (i.e. aggregated block for step)
    @Query("select b from BlockReserve b where b.call.id = ?1 and b.productionGroup is null")
    List<BlockReserve> findByCall_IdAndProductionGroupNull(@NonNull Long id, ProductionGroup productionGroup);

}