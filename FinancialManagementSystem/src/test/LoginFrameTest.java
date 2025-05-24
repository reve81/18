package test;

import main.LoginFrame;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginFrameTest {

    @Test
    public void testReadPasswordFromFile() throws IOException {
        // 准备模拟 pwd.txt
        BufferedWriter writer = new BufferedWriter(new FileWriter("pwd.txt"));
        writer.write("tom\n");
        writer.write("t123\n");
        writer.close();

        // 调用 LoginFrame 的密码读取方法
        String pwd = LoginFrame.getPwd();
        assertEquals("t123", pwd);
    }
}