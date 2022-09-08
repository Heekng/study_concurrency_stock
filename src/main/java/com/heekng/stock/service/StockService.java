package com.heekng.stock.service;

import com.heekng.stock.domain.Stock;
import com.heekng.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

//    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        // get stock
        Stock stock = stockRepository.findById(id).orElseThrow();
        // 재고감소
        stock.decrease(quantity);
        // 저장
        stockRepository.saveAndFlush(stock);
    }
}
