package test;

import main.getDataFromTxt;
import main.oneAccount;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class getDataFromTxtTest {
    @Test
    public void testGetData() {
        getDataFromTxt dataFetcher = new getDataFromTxt();
        ArrayList<oneAccount> list = new ArrayList<>();
        dataFetcher.getData(list);
        // 验证是否成功读取数据
        assertFalse(list.isEmpty(), "数据列表不应为空");
    }
}