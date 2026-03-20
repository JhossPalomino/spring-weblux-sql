package ap1.jhoss.palomino.service.impl;

import ap1.jhoss.palomino.model.Product;
import ap1.jhoss.palomino.repository.ProductRepository;
import ap1.jhoss.palomino.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> findAll() {
        log.info("Finding all products");
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(Long id) {
        log.info("Encontrando producto por id: {}", id);
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        log.info("Guardar producto: {}", product);
        product.setActive(true);
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Long id, Product product) {
        log.info("Actualizando producto con id: {}", id);
        return productRepository.findById(id)
                .flatMap(existing -> {
                    existing.setName(product.getName());
                    existing.setDescription(product.getDescription());
                    existing.setPrice(product.getPrice());
                    existing.setStock(product.getStock());
                    existing.setCategory(product.getCategory());
                    existing.setBrand(product.getBrand());
                    existing.setSku(product.getSku());
                    existing.setActive(product.getActive());
                    return productRepository.save(existing);
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.info("Eliminando producto: {}", id);
        return productRepository.findById(id)
                .flatMap(product -> {
                    product.setActive(false);
                    return productRepository.save(product);
                })
                .then();
    }

    @Override
    public Mono<Void> restore(Long id) {
        log.info("Restaurando producto: {}", id);
        return productRepository.findById(id)
                .flatMap(product -> {
                    product.setActive(true);
                    return productRepository.save(product);
                })
                .then();
    }
}
