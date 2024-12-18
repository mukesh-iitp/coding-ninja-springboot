package com.cn.trademaster.service;

import com.cn.trademaster.dto.TradeDto;
import com.cn.trademaster.model.Trade;
import com.cn.trademaster.repository.TradeRepo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TradeService {

    @Autowired
    private TradeRepo tradeRepo;

    Logger logger = LoggerFactory.getLogger(TradeService.class);

    /**
     1. Create a variable "getTradeHistoryCounter" of data type Counter
        and make it null initially as shown in the problem statement.
     **/
    
    private Counter getTradeHistoryCounter = null;
    
    /**
     2. Modify the constructor as shown in the problem statement.
     **/
    
    public TradeService(CompositeMeterRegistry meterRegistry) {
    	getTradeHistoryCounter = meterRegistry.counter("tradeHistory.call.counter");
	}
    
    public TradeService(){
    }

    public void executeTrade(TradeDto tradeDto) {
        Trade trade = new Trade();
        trade.setStockHolderUserName(tradeDto.getStockHolderUserName());
        trade.setBuyTrade(tradeDto.isBuyTrade());
        trade.setStockId(tradeDto.getStockId());
        trade.setQuantity(tradeDto.getQuantity());
        trade.setPrice(tradeDto.getPrice());
        trade.setStockName(tradeDto.getStockName());
        if (tradeDto.getQuantity() > 1500) {
            logger.error("Trade quantity exceeds the maximum allowed quantity : 1500");
        } else {
            logger.warn("Remember your unique username!!");
            tradeRepo.save(trade);
            logger.info("Success: Stock with id '{}' added in portfolio for '{}'", tradeDto.getStockId(), trade.getStockHolderUserName());
        }
    }

    public List<Trade> getTradeHistory(String username) {
        List<Trade> tradesByUsername = tradeRepo.findByStockHolderUserName(username);

        if (tradesByUsername.isEmpty()){
            logger.error("No trades found for the username : '{}'", username);
        }
        else {
        logger.info("Fetching trade history for '{}'", username);
        }
        /**
         3. Increment the variable in the method getTradeHistory(String username) such that
            whenever a user tries to access the "/tradeMasterApp/tradeHistory/{username}”
            API, the value of the Count variable increases by 1
         **/
        getTradeHistoryCounter.increment();
        return tradesByUsername;
        }
}
