package fr.agregio.call.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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

    @NotNull(message = "Name is mandatory")
    @NotBlank
    @Size(min = 2, message = "Name is too short. Min string length is 2 characters")
    @Size(max = 100, message = "Name is too long. Max string length is 100 characters")
    private String name;

    @Transient
    private List<BlockAvailable> availableBlocks;

    @Transient
    private List<BlockAllocated> allocatedBlocks;



}