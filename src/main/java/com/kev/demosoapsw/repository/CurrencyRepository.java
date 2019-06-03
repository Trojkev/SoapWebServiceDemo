package com.kev.demosoapsw.repository;

import com.kev.demosoapsw.entity.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    @Query("SELECT c FROM Currency c WHERE c.id = :id")
    Currency getItemByCurrencyId(long id);
}
