package fr.agregio.call.model;

import fr.agregio.call.model.enums.Step;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@MappedSuperclass
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "day", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    private String day;

    @Column(name = "step", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Step step;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "production_group_id")
    private ProductionGroup productionGroup;

    @Column(name = "allocated_power", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private Double allocatedPower;

}