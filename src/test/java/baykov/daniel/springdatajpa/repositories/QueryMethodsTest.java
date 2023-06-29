package baykov.daniel.springdatajpa.repositories;

import baykov.daniel.springdatajpa.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByName() {
        Product product = productRepository.findByName("product 1");
        System.out.println(product.getId());
        System.out.println(product);
    }

    @Test
    void findById() {
        Product product = productRepository.findById(1L).get();
        System.out.println(product);
    }

    @Test
    void findByNameOrDescription() {
        List<Product> products = productRepository.findByNameOrDescription("product 1", "product 1 description");
        products.forEach(System.out::println);
    }

    @Test
    void findByNameAndDescription() {
        List<Product> products = productRepository.findByNameAndDescription("product 1", "product 1 description");
        products.forEach(System.out::println);
    }

    @Test
    void findDistinctByName() {
        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product);
    }

    @Test
    void findByPriceGreaterThan() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach(System.out::println);
    }

    @Test
    void findByPriceLessThan() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(300));
        products.forEach(System.out::println);
    }

    @Test
    void findByNameContaining() {
        List<Product> products = productRepository.findByNameContaining("prod");
        products.forEach(System.out::println);
    }

    @Test
    void findByNameLike() {
        List<Product> products = productRepository.findByNameLike("product 1");
        products.forEach(System.out::println);
    }

    @Test
    void findByPriceBetween() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));
        products.forEach(System.out::println);
    }

    @Test
    void findByDateCreatedBetween() {
        List<Product> products = productRepository.findByDateCreatedBetween(LocalDateTime.of(2023, 6, 29, 11, 16, 55), LocalDateTime.of(2023, 6, 29, 11, 17, 20));
        products.forEach(System.out::println);
    }

    @Test
    void findByNameIn() {
        List<Product> products = productRepository.findByNameIn(List.of("product 1", "product 2"));
        products.forEach(System.out::println);
    }

    @Test
    void findTop2ByOrderByNameAsc() {
        List<Product> products = productRepository.findTop2ByOrderByNameAsc();
        products.forEach(System.out::println);
    }

    @Test
    void findTop3ByOrderByPriceDesc() {
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();
        products.forEach(System.out::println);
    }
}
