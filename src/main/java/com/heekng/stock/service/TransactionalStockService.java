package com.heekng.stock.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionalStockService {

    private final StockService stockService;

    public void decrease(Long id, Long quantity) {
        startTransaction();

        stockService.decrease(id, quantity); // 10 : 00

        endTransaction(); // 10 : 05
    }

    public void startTransaction(){}

    public void endTransaction(){}

}
