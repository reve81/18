package test;

import main.oneAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class oneAccountTest {

    private oneAccount account;

    @BeforeEach
    public void setUp() {
        account = new oneAccount(1, 20240523, "收入", "工资", 5000.0);
    }

    @Test
    public void testGetNo() {
        assertEquals(1, account.getNo());
    }

    @Test
    public void testSetNo() {
        account.setNo(2);
        assertEquals(2, account.getNo());
    }

    @Test
    public void testGetDate() {
        assertEquals(20240523, account.getDate());
    }

    @Test
    public void testSetDate() {
        account.setDate(20240601);
        assertEquals(20240601, account.getDate());
    }

    @Test
    public void testGetIOtype() {
        assertEquals("收入", account.getIOtype());
    }

    @Test
    public void testSetIOtype() {
        account.setIOtype("支出");
        assertEquals("支出", account.getIOtype());
    }

    @Test
    public void testGetType() {
        assertEquals("工资", account.getType());
    }

    @Test
    public void testSetType() {
        account.setType("购物");
        assertEquals("购物", account.getType());
    }

    @Test
    public void testGetPrice() {
        assertEquals(5000.0, account.getPrice(), 0.0001);
    }

    @Test
    public void testSetPrice() {
        account.setPrice(1234.56);
        assertEquals(1234.56, account.getPrice(), 0.0001);
    }
}
