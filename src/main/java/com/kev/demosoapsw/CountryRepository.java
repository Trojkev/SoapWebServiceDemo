package com.kev.demosoapsw;

import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    /*
    * This method initializes the available Country data in the system
    * For this demo, we will hardcode the Countries, but in the future
    * we will connect to an actual database to retrieve legit records.
    * */
    @PostConstruct
    public void initData(){
        Country kenya = new Country();
        kenya.setName("Kenya");
        kenya.setCapital("Nairobi");
        kenya.setCurrency(Currency.KES);
        kenya.setPopulation(45513251);
        countries.put(kenya.getName(), kenya);

        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);
        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);
        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);
        countries.put(uk.getName(), uk);
    }

    /*
    * This method will query a our Countries records
    * It will take a Country name as parameter and return the country matching the name
    * @param name: Name of the Country we are interested in.
    * @paramType name: String
    * @return: Country matching the name provided
    * @returnType: Country
    * */
    public Country findCountry(String name){
        Assert.notNull(name, "Country's name must not be null.");
        return countries.get(name);
    }
}
