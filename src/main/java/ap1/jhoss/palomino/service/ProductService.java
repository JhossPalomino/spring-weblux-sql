package ap1.jhoss.palomino.service;

import ap1.jhoss.palomino.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    
    Flux<Product> findAll();

    Mono<Product> findById(Long id);

    Mono<Product> save(Product product);

    Mono<Product> update(Long id, Product product);

    Mono<Void> delete(Long id);

    Mono<Void> restore(Long id);

}
