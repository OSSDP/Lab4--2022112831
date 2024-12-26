
import org.junit.Before;
import org.junit.Test;
import com.czy.SumCalculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SumCalculatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    // 测试基本功能：两个正数的和
    @Test
    public void testBasicAddition() {
        provideInput("10\n20\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("两数之和是：30"));
    }

    // 测试小数计算
    @Test
    public void testDecimalAddition() {
        provideInput("10.5\n20.7\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("两数之和是：31.2"));
    }

    // 测试负数计算
    @Test
    public void testNegativeNumbers() {
        provideInput("-10\n-20\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("两数之和是：-30"));
    }

    // 测试一个正数一个负数
    @Test
    public void testMixedNumbers() {
        provideInput("10\n-5\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("两数之和是：5"));
    }

    // 测试零的处理
    @Test
    public void testZeroHandling() {
        provideInput("0\n0\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("两数之和是：0"));
    }

    // 测试科学计数法
    @Test
    public void testScientificNotation() {
        provideInput("1E10\n2E10\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("两数之和是：30000000000"));
    }

    // 测试超大数字
    @Test
    public void testLargeNumbers() {
        provideInput("1000000000000000000000000\n2000000000000000000000000\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("两数之和是：3000000000000000000000000"));
    }

    // 测试精度
    @Test
    public void testPrecision() {
        provideInput("1.123456789\n2.987654321\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("两数之和是：4.11111111"));
    }

    // 测试无效输入 - 非数字
    @Test
    public void testInvalidInput() {
        provideInput("abc\n20\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("输入无效"));
    }

    // 测试无效输入 - 空输入
    @Test
    public void testEmptyInput() {
        provideInput("\n20\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains("输入无效"));
    }

    // 测试边界值 - 最大值
    @Test
    public void testMaxValue() {
        String maxValue = "1" + "0".repeat(100);
        provideInput(maxValue + "\n1\n");
        SumCalculator.main(new String[]{});
        assertTrue(outContent.toString().contains(new BigDecimal(maxValue).add(BigDecimal.ONE).toString()));
    }

    // 辅助方法：模拟用户输入
    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
