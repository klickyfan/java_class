package edu.kimjones.advancedjava.stock;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * This class is for testing the class StockQuote.
 *
 * @author Kim Jones
 */

public class StockQuoteTest {

    private String stockSymbol = "AAPL";
    private BigDecimal stockPrice = BigDecimal.valueOf(100.0);
    private Date dateRecorded;
    private Date dateNotRecorded; // for negative test

    private StockQuote stockQuote;

    @Before
    public void setUp() throws Exception {

        LocalDate localDate0 = LocalDate.of(2018, 9, 16);
        this.dateRecorded = java.sql.Date.valueOf(localDate0);

        LocalDate localDate1 = LocalDate.of(2017, 1, 1);
        this.dateNotRecorded = java.sql.Date.valueOf(localDate1);

        this.stockQuote = new StockQuote(this.stockSymbol, this.stockPrice, this.dateRecorded);
    }

    @Test
    public void testSymbolPositive() {
        assertEquals("symbol matches", this.stockSymbol, this.stockQuote.getStockSymbol());
    }

    @Test
    public void testSymbolNegative() {
        assertFalse("symbol does not match", "BMY" == this.stockQuote.getStockSymbol());
    }

    @Test
    public void testPricePositive() {
        assertEquals("price matches", this.stockPrice, this.stockQuote.getStockPrice());
    }

    @Test
    public void testPriceNegative() {
        assertFalse("price does not match", BigDecimal.valueOf(1.0) == this.stockQuote.getStockPrice());
    }

    @Test
    public void testDatePositive() {
        assertEquals("date matches", this.dateRecorded, this.stockQuote.getDateRecorded());
    }

    @Test
    public void testDateNegative() {
        assertFalse("date does not match", this.dateNotRecorded == this.stockQuote.getDateRecorded());

    }
}
