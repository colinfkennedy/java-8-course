package com.java_8_training.problems.streams;


import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import com.java_8_training.answers.streams.Trader;
import com.java_8_training.answers.streams.Transaction;

public class TransactionsAndTradesPart1Test {

    private List<Transaction> transactions = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    public void findSortedTransactionsFrom2011() {
        //TODO: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> transactionsYear2011 = transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(comparing(Transaction::getValue))
            .collect(toList());

        assertEquals(300, transactionsYear2011.get(0).getValue());
        assertEquals(2011, transactionsYear2011.get(0).getYear());

        assertEquals(400, transactionsYear2011.get(1).getValue());
        assertEquals(2011, transactionsYear2011.get(1).getYear());

        assertEquals(2, transactionsYear2011.size());
    }

    @Test
    public void findUniqueCitiesWhereTradersWork() {
        //TODO: What are all the unique cities where the traders work?
        List<String> cities = transactions.stream()
            .map(t -> t.getTrader().getCity())
            .distinct()
            .collect(toList());


        assertEquals(2, cities.size());
        assertTrue(cities.contains("Cambridge"));
        assertTrue(cities.contains("Milan"));

    }

    @Test
    public void findTradersFromCambridgeSortedByName() {
        //TODO: Find all traders from Cambridge and sort them by name.
        List<Trader> traders = transactions.stream()
            .map(Transaction::getTrader)
            .distinct()
            .filter(trader -> "Cambridge".equals(trader.getCity()))
            .sorted(comparing(Trader::getName))
            .collect(toList());


        assertEquals(3, traders.size());
        assertEquals("Alan", traders.get(0).getName());
        assertEquals("Brian", traders.get(1).getName());
        assertEquals("Raoul", traders.get(2).getName());
    }

    @Test
    public void formatTradersNamesSorted() {
        //TODO: Return a string of all traders’ names sorted alphabetically.
        String result = transactions.stream()
            .map(Transaction::getTrader)
            .distinct()
            .sorted(comparing(Trader::getName))
            .map(Trader::getName)
            .collect(Collectors.joining());

        assertEquals("AlanBrianMarioRaoul", result);
    }

    @Test
    public void findMilaneseTraders() {
        //TODO: Are there any trader based in Milan?
        boolean milan = transactions.stream()
            .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));


        assertTrue(milan);
    }

    @Test
    public void moveMilaneseTradersToCambridge() {
        //TODO: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
            .forEach(transaction -> transaction.getTrader().setCity("Cambridge"));

        assertTrue(transactions.stream().allMatch(t -> "Cambridge".equals(t.getTrader().getCity())));

    }

    @Test
    public void findHighestValueTransaction() {
        //TODO: What's the highest value in all the transactions?
        int highestValue = transactions.stream()
            .map(Transaction::getValue)
            .max(Integer::compare)
            .get();

        assertEquals(1000, highestValue);
    }

    @Test
    public void findLowestValueTransaction() {
        //TODO: What's the transaction with lowest value?
        Transaction smallestTransaction = transactions.stream()
            .min(comparing(Transaction::getValue))
            .get();

        assertEquals(transactions.get(0), smallestTransaction);
    }

}
