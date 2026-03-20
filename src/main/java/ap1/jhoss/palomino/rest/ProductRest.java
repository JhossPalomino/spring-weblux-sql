package ap1.jhoss.palomino.rest;

import ap1.jhoss.palomino.model.Product;
import ap1.jhoss.palomino.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductRest {

    private final ProductService productService;

    @Autowired
    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/save")
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update/{id}")
    public Mono<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @PatchMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

    @PatchMapping("/restore/{id}")
    public Mono<Void> restoreProduct(@PathVariable Long id) {
        return productService.restore(id);
    }

}
