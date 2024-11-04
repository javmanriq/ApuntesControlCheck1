package org.springframework.samples.petclinic.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    Integer id;
    String name;
    Integer price;
    String type;

    public ProductDTO(Product p){
        this.id = p.getId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.type = p.getType().getName();
    }
    
}
