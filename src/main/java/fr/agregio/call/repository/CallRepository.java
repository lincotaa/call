package fr.agregio.call.repository;

import fr.agregio.call.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.List;

public interface CallRepository extends JpaRepository<Call, Long> {
    //Get Call for a Reserve and a specific day
    Call findByReserve_IdAndDay(@NonNull Long id, @NonNull Date day);

    //Find all Calls for Reserve
    List<Call> findByReserve_Id(@NonNull Long id);




}