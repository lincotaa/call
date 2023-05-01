package fr.agregio.call.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "call")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reserve_id", nullable = false)
    private Reserve reserve;

    @Column(name = "day", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    private Date day;

    @OneToMany(mappedBy = "call", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlockReserve> blockReserves = new ArrayList<>();

    @Transient
    private List<BlockReserve> aggregatedBlockReserves;

    @Transient
    private List<List<BlockReserve>> detailedBlockReserves;

}