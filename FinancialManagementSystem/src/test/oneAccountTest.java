package test;
import main.oneAccount;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
// 测试 oneAccount 类
public class oneAccountTest {
    @Test
    public void testOneAccountCreation() {
        oneAccount account = new oneAccount(1, 20241001, "收入", "餐饮", 100.0);
        assertEquals(1, account.getNo());
        assertEquals(20241001, account.getDate());
        assertEquals("收入", account.getIOtype());
        assertEquals("餐饮", account.getType());
        assertEquals(100.0, account.getPrice(), 0.001);
    }
}