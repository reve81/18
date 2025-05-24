package test;

import main.getDataFromTxt;
import main.oneAccount;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class getDataFromTxtTest {

    private final String testFile = "TestData.txt";

    @BeforeEach
    public void setUp() throws Exception {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(testFile), "GBK") // ✅ 写入为 GBK 编码
        );
        writer.write("1\t20240501\t收入\t工资\t5000.0\n");
        writer.write("2\t20240502\t支出\t购物\t300.0\n");
        writer.write("3\t20240503\t支出\t交通\t50.0\n");
        writer.close();
    }

    @AfterEach
    public void tearDown() throws Exception {
        File file = new File(testFile);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (!deleted) {
                System.err.println("⚠️ 警告：测试文件删除失败");
            }
        }
    }

    @Test
    public void testGetData() {
        getDataFromTxt reader = new getDataFromTxt();
        ArrayList<oneAccount> list = new ArrayList<>();
        reader.getData(list, testFile); // 使用测试路径

        assertEquals(3, list.size()); // ✅ 现在应能读取出 3 条数据（前提是读取时也使用 GBK）
        assertEquals("收入", list.get(0).getIOtype());
        assertEquals("购物", list.get(1).getType());
        assertEquals("交通", list.get(2).getType());
    }

    @Test
    public void testEmptyFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(testFile), "GBK"));
        writer.write("");
        writer.close();

        getDataFromTxt reader = new getDataFromTxt();
        ArrayList<oneAccount> list = new ArrayList<>();
        reader.getData(list, testFile);

        assertTrue(list.isEmpty(), "读取空文件应返回空列表");
    }

    @Test
    public void testInvalidFormat() throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(testFile), "GBK"));
        writer.write("1\t20240501\t收入\t工资\n"); // 缺少金额字段
        writer.close();

        getDataFromTxt reader = new getDataFromTxt();
        ArrayList<oneAccount> list = new ArrayList<>();
        reader.getData(list, testFile);

        assertEquals(0, list.size(), "格式错误的记录不应被添加");
    }
}