package test;

import main.ModifyPwdFrame;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class ModifyPwdFrameTest {

    @Test
    public void testModifyPassword() throws IOException {
        String username = "tom";
        String newPassword = "newpass123";

        ModifyPwdFrame frame = new ModifyPwdFrame(username);
        frame.modify(newPassword);

        BufferedReader reader = new BufferedReader(new FileReader("pwd.txt"));
        String line1 = reader.readLine(); // username
        String line2 = reader.readLine(); // password
        reader.close();

        assertEquals(username, line1);
        assertEquals(newPassword, line2);
    }
}
