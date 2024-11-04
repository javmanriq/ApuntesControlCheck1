package org.springframework.samples.petclinic.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    Integer id;

    @NotNull
    @NotBlank
    String name;

    @NotNull
    @Min(0)
    Integer price;

    @NotNull
    String type;

    public ProductDTO(){
        
    }

    public ProductDTO(Product p){
        this.id = p.getId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.type = p.getType().getName();
    }
    
}
