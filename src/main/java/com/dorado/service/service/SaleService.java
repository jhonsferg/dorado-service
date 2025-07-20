package com.dorado.service.service;

import com.dorado.service.model.Sale;
import com.dorado.service.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long id, Sale sale) {
        sale.setId(id);
        return saleRepository.save(sale);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
