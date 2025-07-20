package com.dorado.service.repository;

import com.dorado.service.model.Sale;
import com.dorado.service.model.SaleItem;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class SaleRepository {
    private final Map<Long, Sale> sales = new HashMap<>();
    private Long nextId = 1L;

    public SaleRepository() {
        save(new Sale(1L, LocalDateTime.now(), "JOSE PEREZ PAREDES", "964578123", List.of(new SaleItem(1L, "Papas fritas", 1, 28.0, 28.0)), 28.0, 5.04, 33.4, "EFECTVO", 1L, 1L));
        save(new Sale(2L, LocalDateTime.now(), "ERNESTO ROMERO LAZO", "914578622", List.of(new SaleItem(1L, "Papas fritas", 1, 28.0, 28.0)), 28.0, 5.04, 33.4, "EFECTVO", 1L, 1L));
        save(new Sale(3L, LocalDateTime.now(), "FERNANDO LOPE BELTRAN", "974512368", List.of(new SaleItem(1L, "Papas fritas", 1, 28.0, 28.0)), 28.0, 5.04, 33.4, "EFECTVO", 1L, 1L));
        save(new Sale(4L, LocalDateTime.now(), "RAÚL QUISPE HUAMÁN", "931573468", List.of(new SaleItem(1L, "Papas fritas", 1, 28.0, 28.0)), 28.0, 5.04, 33.4, "EFECTVO", 1L, 1L));
        save(new Sale(5L, LocalDateTime.now(), "PEDRO ALEXANDER ROJAS MORENO", "997548123", List.of(new SaleItem(1L, "Papas fritas", 1, 28.0, 28.0)), 28.0, 5.04, 33.4, "EFECTVO", 1L, 1L));
    }

    public Sale save(Sale sale) {
        if (sale.getId() == null) {
            sale.setId(nextId++);
        }
        return sales.put(sale.getId(), sale);
    }

    public List<Sale> findAll() {
        return new ArrayList<>(sales.values());
    }

    public Optional<Sale> findById(Long id) {
        return Optional.ofNullable(sales.get(id));
    }

    public void deleteById(Long id) {
        sales.remove(id);
    }
}
