package fr.agregio.call.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@Table(name = "power_agreement")
public class PowerAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Min(value = 0L, message = "The value must be positive")
    @Column(name = "min_power", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double minPower;

    @Min(value = 0L, message = "The value must be positive")
    @Column(name = "max_power", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double maxPower;
}