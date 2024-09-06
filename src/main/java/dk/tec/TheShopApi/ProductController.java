package dk.tec.TheShopApi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public int createTodo (@RequestBody Product product){
        repository.save(product);
        return product == null ? -1 : product.getId();
    }

    @GetMapping()
    public List<Product> getAllTodo(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product getTodoById(@PathVariable int id){
        return repository.findById(id).get();
    }

    @PutMapping()
    public void updateTodo(@RequestBody Product product){
        repository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable int id){
        repository.deleteById(id);
    }
}
