package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column
    Integer id;

    @Size(min= 3, max = 50)
    @NotEmpty
    @Column
    String name;
    
    @PositiveOrZero
    @NotEmpty
    @Column
    double price;
    
    @OneToOne
    ProductType productType;
}
