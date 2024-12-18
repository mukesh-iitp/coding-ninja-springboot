package com.cn.trademaster.service;

import com.cn.trademaster.dto.TradeDto;
import com.cn.trademaster.model.Trade;
import com.cn.trademaster.repository.TradeRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private TradeRepo tradeRepo;

    /**

     1. Create a logger object here from LoggerFactory and pass tradeService class
       as parameter for the getLogger() method.

     2. Implement logger in the methods below wherever required.

     **/
    
    Logger logger = LoggerFactory.getLogger(TradeService.class);
    

    public void executeTrade(TradeDto tradeDto) {
        Trade trade = new Trade();
    /**
     1. First map the tradeDto object with the trade entity object before saving.

     2. After mapping tradeDto write the logic for printing an "ERROR" level log
        with an appropriate message whenever the quantity of stock exceeds the value
        of 1500 thus ending the execution of executeTrade() method.

     3. If quantity is in required range i.e. (less than 1500 ) then provide a "WARN"
        level log asking user to remember their unique username.
    **/
        trade.setStockId(tradeDto.getStockId());
        trade.setStockName(tradeDto.getStockName());
        trade.setQuantity(tradeDto.getQuantity());
        trade.setStockHolderUserName(tradeDto.getStockHolderUserName());
        trade.setPrice(tradeDto.getPrice());
        trade.setBuyTrade(tradeDto.isBuyTrade());
        
        if(trade.getQuantity() >1500)
        	logger.error("quantity of stock exceeds the value of 1500: level = ERROR");
        else
        {
        	logger.warn("please remember your unique username: level = WARN");
        
        	tradeRepo.save(trade);
    /**
     4. Lastly, provide an "INFO" level log displaying a success message after the trade
        is successfully executed/saved.
        
    **/
        	logger.info("the trade is successfully executed/saved: level = INFO");
        }
        
        }


    public List<Trade> getTradeHistory(String username) {
        List<Trade> tradesByUsername;

        /**

         1. Use the findByStockHolderUserName() method of TradeRepo for fetching
            the list of Trade by username and save the returned value from this method
            to the tradesByUsername object declared above.

         2. Implement an "ERROR" level log if no trades are found by the username.

         3. Provide a simple "INFO" level log with a meaningful message if trades are found.

         4. Lastly, return tradesByUsername object.

         **/
        tradesByUsername = tradeRepo.findByStockHolderUserName(username);
        
        if(tradesByUsername.isEmpty())
        	logger.error("no trade are found by the username "+username);
        else
        	logger.info("trade found with username "+username);

        return tradesByUsername;
        
        }
}
