package fr.agregio.call.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Description is mandatory")
    @NotBlank
    @Size(min = 2, message = "Description is too short. Min string length is 2 characters")
    @Size(max = 100, message = "Description is too long. Max string length is 100 characters")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @OneToMany(mappedBy = "reserve", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Call> calls = new ArrayList<>();
}