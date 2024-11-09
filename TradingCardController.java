package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tradingCards")
public class TradingCardController {
    @Autowired
    private TradingCardService tradingCardService;

    @GetMapping
    public ResponseEntity<List<TradingCard>> getAllTradingCards() {
        List<TradingCard> tradingCard = tradingCardService.getAllTradingCards();
        return ResponseEntity.ok(tradingCard);
    }

    @GetMapping("/{cardNo}")
    public ResponseEntity<TradingCard> getTradingCardByCardNo(@PathVariable Long cardNo) {
        TradingCard tradingCard = tradingCardService.getTradingCardByCardNo(cardNo);
        if (tradingCard != null) {
            return ResponseEntity.ok(tradingCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createTradingCard(@RequestBody TradingCard tradingCard) {
        tradingCardService.saveTradingCard(tradingCard);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cardNo}")
    public ResponseEntity<Void> updateTradingCard(@PathVariable Long cardNo, @RequestBody TradingCard tradingCard) {
        TradingCard existingTradingCard = tradingCardService.getTradingCardByCardNo(cardNo);
        if (existingTradingCard != null) {
            tradingCard.setCardNo(cardNo);
            tradingCardService.updateTradingCard(tradingCard);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{cardNo}")
    public ResponseEntity<Void> deleteTradingCard(@PathVariable Long cardNo) {
        TradingCard existingTradingCard = tradingCardService.getTradingCardByCardNo(cardNo);
        if (existingTradingCard != null) {
            tradingCardService.deleteTradingCardByCardNo(cardNo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}










