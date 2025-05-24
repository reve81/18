package test;

import main.PieChart;
import main.oneAccount;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PieChartTest {

    @Test
    public void testDatasetTotal() {
        ArrayList<oneAccount> data = new ArrayList<>();
        data.add(new oneAccount(1, 20240501, "收入", "工资", 5000));
        data.add(new oneAccount(2, 20240502, "支出", "购物", 1000));
        data.add(new oneAccount(3, 20240503, "支出", "购物", 500));

        PieChart chart = new PieChart(data);
        DefaultPieDataset dataset = chart.getNewData(20240501, 20240503);

        assertEquals(5000.0, dataset.getValue("工资"));
        assertEquals(1500.0, dataset.getValue("购物"));
    }
}
