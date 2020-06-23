import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ICStockMaxProfit {

    public static int getMaxProfit(int[] stockPrices) {

        // calculate the max profit
        int len= stockPrices.length;
        if (len <=1){
            throw new IllegalArgumentException("You need to purchase atleast 2 stocks to evaluate profit");
        }

        //int[] array =
        //Arrays.sort(stockPrices);
        //System.Out.Println(stockPrices[length-1] -stockPrices[0]);
        //1, 5, 3, 2 >> 1-5 =4;
        //int windowLeftStock =0;
        int stockProfit = Integer.MIN_VALUE;
        int currentProfit=0;
        int windowRightStock =1;

        for (int windowLeftStock =0;windowLeftStock<len;windowLeftStock++){
            for (windowRightStock=windowRightStock;windowRightStock<len;windowRightStock++){
                currentProfit = stockPrices[windowRightStock] - stockPrices[windowLeftStock];
                //System.out.println("Current Profit "+ currentProfit);
                stockProfit = Math.max(currentProfit, stockProfit);
                //System.out.println("Stock Profit " + stockProfit);
            }
            windowRightStock++;

        }

        return stockProfit;
    }


















    // tests

    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[] {1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[] {7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        //-2,
        final int actual = getMaxProfit(new int[] {9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[] {5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[] {});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ICStockMaxProfit.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}