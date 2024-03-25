package com.patika.kredinbizdeservice.repository;


import com.patika.kredinbizdeservice.model.CreditCard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CreditCardRepository {
    private List<CreditCard> creditCardList = new ArrayList<>();

    public CreditCard save(CreditCard creditCard)
    {
        creditCardList.add(creditCard);
        return creditCard;
    }

    public List<CreditCard> findAll() {
        return creditCardList;
    }
}
