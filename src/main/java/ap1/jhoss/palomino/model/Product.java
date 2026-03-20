package ap1.jhoss.palomino.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import java.math.BigDecimal;

@Data
@Table(name = "product")   
public class Product {

    @Id
    @Column(value = "id")
    private Long id;  

    @Column(value = "name")
    private String name;

    @Column(value = "description")
    private String description;

    @Column("price")
    private BigDecimal price; 

    @Column(value = "stock")
    private Integer stock;

    @Column(value = "category")
    private String category;

    @Column(value = "brand")
    private String brand;

    @Column(value = "sku")
    private String sku;      

    @Column(value = "active")
    private Boolean active;
    
}