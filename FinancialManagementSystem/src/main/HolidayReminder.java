package main;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HolidayReminder {

    public static class Holiday {
        public String name;
        public LocalDate date;
        public double budget;

        public Holiday(String name, LocalDate date, double budget) {
            this.name = name;
            this.date = date;
            this.budget = budget;
        }
    }

    // 系统默认节日
    private static final List<Holiday> holidays = Arrays.asList(
        new Holiday("春节", LocalDate.of(2025, 1, 29), 2000),
        new Holiday("中秋节", LocalDate.of(2025, 9, 6), 800),
        new Holiday("国庆节", LocalDate.of(2025, 10, 1), 1500)
    );

    // 加载用户自定义节日
    public static List<Holiday> loadUserHolidays(String filepath) {
        List<Holiday> userHolidays = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0];
                    LocalDate date = LocalDate.parse(parts[1]);
                    double budget = parts.length == 3 ? Double.parseDouble(parts[2]) : 0;
                    userHolidays.add(new Holiday(name, date, budget));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userHolidays;
    }

    // 检查所有节日提醒
    public static void checkAllReminders(LocalDate today, double spending, String userHolidayFile) {
        List<Holiday> all = new ArrayList<>(holidays);
        all.addAll(loadUserHolidays(userHolidayFile));
        for (Holiday h : all) {
            long days = ChronoUnit.DAYS.between(today, h.date);
            if (days >= 0 && days <= 7) {
                String msg = (spending > h.budget && h.budget > 0)
                    ? "⚠️ " + h.name + " 快到了，支出已超预算 ¥" + h.budget
                    : "🎉 " + h.name + " 即将到来，请注意支出";
                JOptionPane.showMessageDialog(null, msg);
            }
        }
    }

    // 示例测试方法
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        double sampleSpending = 1200;
        String userHolidayPath = "user_holidays.txt";
        checkAllReminders(today, sampleSpending, userHolidayPath);
    }
}
