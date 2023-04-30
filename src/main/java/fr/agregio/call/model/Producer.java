package fr.agregio.call.model;

import fr.agregio.call.model.enums.ProductionType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "producer")
@EntityListeners(AuditingEntityListener.class)
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Valid
    @NotBlank(message =
            """
            Production type is mandatory.
            Valid entries are: SOLAR, HYDRAULIC or WIND.
            """)
    private ProductionType type;

    @Valid
    @Column(name = "created_date")
    @CreatedBy
    private ZonedDateTime created;

    @Valid
    @Column(name = "modified_date")
    @CreatedBy
    private String lastModified;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Valid
    @Column(name = "modified_by")
    @LastModifiedBy
    private String lastModifiedBy;

}