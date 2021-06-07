package com.test.markettest.domain.service;

import com.test.markettest.domain.Purchase;
import com.test.markettest.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId).filter(purchases -> !purchases.isEmpty());
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
