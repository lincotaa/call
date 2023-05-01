package fr.agregio.call.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "block_producer")
public class BlockProducer extends Block {
    @Column(name = "total_power", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double totalPower;

    @Column(name = "available_power", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double availablePower;

    public Double allocatePower(Double powerToAllocate) {
        Double powerAllocated = Math.min(availablePower, powerToAllocate);
        availablePower = availablePower - powerAllocated;
        return powerAllocated;
    }
}