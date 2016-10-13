package seo.dale.commerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void create(Product product) {
        repository.save(product);
    }

    public void modify(Long id, Product product) {
        Product found = repository.findOne(id);
        found.setName(product.getName());
        found.setDescription(product.getDescription());
        found.setPrice(product.getPrice());
        found.setStock(product.getStock());
        repository.save(product);
    }

    public void remove(Long id) {
        repository.delete(id);
    }

    public Product detail(Long id) {
        return repository.findOne(id);
    }

    public List<Product> list() {
        return repository.findAll();
    }

}
