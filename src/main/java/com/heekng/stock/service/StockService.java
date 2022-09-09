package com.heekng.stock.service;

import com.heekng.stock.domain.Stock;
import com.heekng.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW) //부모의 트랜잭션과 별도로 실행되어야 함
    public synchronized void decrease(Long id, Long quantity) {
        // get stock
        Stock stock = stockRepository.findById(id).orElseThrow();
        // 재고감소
        stock.decrease(quantity);
        // 저장
        stockRepository.saveAndFlush(stock);
    }
}
