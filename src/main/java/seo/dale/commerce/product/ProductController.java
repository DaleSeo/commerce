package seo.dale.commerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody Product product) {
        service.create(product);
        return product.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modify(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        service.modify(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product detail(@PathVariable Long id) {
        return service.detail(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {
        return service.list();
    }

}
