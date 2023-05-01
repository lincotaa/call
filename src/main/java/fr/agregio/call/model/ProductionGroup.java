package fr.agregio.call.model;

import fr.agregio.call.model.enums.ProductionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "production_group")
public class ProductionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message =
        """
        Production type is mandatory.
        Valid entries are: SOLAR, HYDRAULIC or WIND
        """)
    @Enumerated(EnumType.STRING)
    @Column(name = "production_type", nullable = false, length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private ProductionType productionType;

    @NotNull(message = "Production cost is mandatory. Expected unit is [[ €/MWh ]]")
    @Min(value = 0L, message = "The value must be positive")
    @Column(name = "production_cost", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double productionCost;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "power_agreement_id", nullable = false, unique = true)
    private PowerAgreement powerAgreement;

}