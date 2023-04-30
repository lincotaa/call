package fr.agregio.call.model;

import fr.agregio.call.model.enums.ProductionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "production_group")
@EntityListeners(AuditingEntityListener.class)
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

    @NotNull(message = "Name is mandatory")
    @Size(min = 2, message = "Name is too short. Min string length is 2 characters")
    @Size(max = 100, message = "Name is too long. Max string length is 100 characters")
    @Column(name = "name", nullable = false, length = 100)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @NotNull(message = "Production cost is mandatory. Expected unit is [[ €/MWh ]]")
    @Min(value = 0L, message = "The value must be positive")
    @Column(name = "production_cost", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double productionCost;

    @Min(value = 0L, message = "The value must be positive")
    @Column(name = "agreement_power_min", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double agreementPowerMin;

    @Min(value = 0L, message = "The value must be positive")
    @Column(name = "agreement_power_max", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double agreementPowerMax;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP_WITH_TIMEZONE)
    private String createdAt;

    @Size(max = 50, message = "Username is too long. Max string length is 50 characters")
    @Column(name = "created_by", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP_WITH_TIMEZONE)
    private String modifiedAt;

    @Size(max = 50, message = "Username is too long. Max string length is 50 characters")
    @Column(name = "modified_by", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String modifiedBy;



//    @Transient
//    private List<BlockAvailable> availableBlocks;
//
//    @Transient
//    private List<BlockAllocated> allocatedBlocks;

}