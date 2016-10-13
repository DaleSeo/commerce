package seo.dale.commerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void create(Product product) {
        repository.save(product);
    }

    public void modify(Product product) {
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
