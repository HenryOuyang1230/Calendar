package test;

import model.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {

    private Date testDate;

    @BeforeEach
    public void init() {
        testDate = new Date(7, 22, 2021);
    }

    @Test
    public void testConstructor() {
        assertEquals(testDate.getMonth(), 7);
        assertEquals(testDate.getDay(), 22);
        assertEquals(testDate.getYear(), 2021);
    }

    @Test
    public void testGetShortFormat() {
        assertEquals(testDate.getShortFormat(), "07/22/2021");
    }

    @Test
    public void testGetLongFormat() {
        assertEquals(testDate.getLongFormat(), "July 22nd, 2021");
    }
}
