package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TradingCardService {
    @Autowired
    private JdbcTradingCardRepository tradingCardRepository;

    public List<TradingCard> getAllTradingCards() {
        return tradingCardRepository.getAllTradingCards();
    }
    
    public TradingCard getTradingCardByCardNo(Long cardNo) {
        return tradingCardRepository.getTradingCardByCardNo(cardNo);
    }
    
    public void saveTradingCard(TradingCard tradingCard) {
        tradingCardRepository.saveTradingCard(tradingCard);
    }
    
    public void updateTradingCard(TradingCard tradingCard) {
        tradingCardRepository.updateTradingCard(tradingCard);
    }
    
    public void deleteTradingCardByCardNo(Long cardNo) {
        tradingCardRepository.deleteTradingCardByCardNo(cardNo);
    }
}





