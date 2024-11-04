package org.springframework.samples.petclinic.product;

import org.springframework.samples.petclinic.model.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {
    @NotNull
    @Size(min = 1, max = 50)
    @NotBlank
    String name;

    @NotNull
    @Min(0)
    Integer price;

    @ManyToOne
    @NotNull
    ProductType type;
}
