package com.dorado.service.repository;

import com.dorado.service.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final Map<Long, Product> products = new HashMap<>();
    private Long nextId = 1L;

    public ProductRepository() {
        save(new Product(1L, "Pollo a la Brasa 1/4", "POLLO", "CUARTO", 15.0, 50, ""));
        save(new Product(2L, "Pollo a la Brasa 1/2", "POLLO", "MEDIO", 28.0, 30, ""));
        save(new Product(3L, "Pollo a la Brasa Entero", "POLLO", "ENTERO", 55.0, 20, ""));
        save(new Product(4L, "Papas Fritas", "COMPLEMENTO", "REGULAR", 8.0, 100, ""));
        save(new Product(5L, "Ensalada Rusa", "COMPLEMENTO", "REGULAR", 6.0, 80, ""));
        save(new Product(6L, "Inca Kola 1.5L", "BEBIDA", "GRANDE", 7.0, 60, ""));
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++);
        }
        return products.put(product.getId(), product);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> findByCategory(String category) {
        return products.values().stream()
                .filter(p -> p.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        products.remove(id);
    }

    public List<Product> findLowStock(Integer minStock) {
        return products.values().stream()
                .filter(p -> p.getStock() <= minStock)
                .collect(Collectors.toList());
    }
}
