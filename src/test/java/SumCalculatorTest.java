
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class SumCalculatorTest {

    // 测试两个正数的和
    @Test
    public void sumOfTwoPositiveNumbers() {
        BigDecimal num1 = new BigDecimal("10"); // 第一个正数
        BigDecimal num2 = new BigDecimal("20"); // 第二个正数
        BigDecimal expected = new BigDecimal("35"); // 预期结果
        assertEquals(expected, num1.add(num2)); // 验证计算结���是否与预期一致
    }

    // 测试一个正数和一个负数的和
    @Test
    public void sumOfPositiveAndNegativeNumber() {
        BigDecimal num1 = new BigDecimal("10"); // 正数
        BigDecimal num2 = new BigDecimal("-5"); // 负数
        BigDecimal expected = new BigDecimal("5"); // 预期结果
        assertEquals(expected, num1.add(num2)); // 验证计算结果是否与预期一致
    }

    // 测试两个负数的和
    @Test
    public void sumOfTwoNegativeNumbers() {
        BigDecimal num1 = new BigDecimal("-10"); // 第一个负数
        BigDecimal num2 = new BigDecimal("-20"); // 第二个负数
        BigDecimal expected = new BigDecimal("-30"); // 预期结果
        assertEquals(expected, num1.add(num2)); // 验证计算结果是否与预期一致
    }

    // 测试零和一个数的和
    @Test
    public void sumOfZeroAndNumber() {
        BigDecimal num1 = new BigDecimal("0"); // 零
        BigDecimal num2 = new BigDecimal("20"); // 一个正数
        BigDecimal expected = new BigDecimal("20"); // 预期结果
        assertEquals(expected, num1.add(num2)); // 验证计算结果是否与预期一致
    }

    // 测试两个大数的和
    @Test
    public void sumOfTwoLargeNumbers() {
        BigDecimal num1 = new BigDecimal("1000000000000000000000000"); // 第一个大数
        BigDecimal num2 = new BigDecimal("2000000000000000000000000"); // 第二个大数
        BigDecimal expected = new BigDecimal("3000000000000000000000000"); // 预期结果
        assertEquals(expected, num1.add(num2)); // 验证计算结果是否与预期一致
    }

    // 测试无效输入是否抛出NumberFormatException
    @Test
    public void invalidInputThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            new BigDecimal("invalid"); // 无效输入
        }); // 验证是否抛出NumberFormatException
    }
}