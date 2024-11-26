package com.czy;
import java.math.BigDecimal;
import java.util.Scanner;

public class SumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // just make some change in code
        try (scanner) {
            System.out.println("请输入第一个数字：");
            String input1 = scanner.nextLine();
            System.out.println("请输入第二个数字：");
            String input2 = scanner.nextLine();
            // 尝试将输入转换为BigDecimal（适用于小数和大数）
            BigDecimal num1 = new BigDecimal(input1);
            BigDecimal num2 = new BigDecimal(input2);

            // 计算两数之和
            BigDecimal sum = num1.add(num2);

            // 输出结果
            System.out.println("两数之和是：" + sum);
        } catch (NumberFormatException e) {
            System.out.println("输入无效，请确保输入的是有效的数字。");
        } catch (Exception e) {
            System.out.println("出现错误：" + e.getMessage());
        }
    }
}
