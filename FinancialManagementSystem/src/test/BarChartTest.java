package test;

import main.BarChart;
import main.oneAccount;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BarChartTest {

    @Test
    public void testBarChartData() {
        ArrayList<oneAccount> list = new ArrayList<>();
        list.add(new oneAccount(1, 20240401, "收入", "工资", 3000));
        list.add(new oneAccount(2, 20240402, "支出", "购物", 1000));

        BarChart chart = new BarChart(list);
        DefaultCategoryDataset dataset = chart.getDataset();

        assertEquals(3000.0, dataset.getValue("收入", "工资"));
        assertEquals(1000.0, dataset.getValue("支出", "购物"));
    }
}