/**
 * Created by Admin on 2016/8/8.
 */

/**
 * best-time-to-buy-and-sell-stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction (ie, buy one and sell one share
 of the stock), design an algorithm to find the maximum profit.

 解题思路：
 对应每一个当前价格先找到之前的最低价格，当前价-最低价=利润，不断更新利润即可！
 */
public class BestTimeToBuyAndSellSock_121 {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)
            return 0;
        int n = prices.length;
        int min = prices[0]; //当前位置前面的最低价
        int profit = 0;      //利润
        for(int i=1;i<n;i++)
        {
            if(prices[i]>=min)
                profit = Math.max(profit,prices[i]-min);
            else
                min = prices[i];
        }
        return profit;
    }

    public static void main(String[] args){
//        int[] array = {8,9,10,11,7,5,10};
//        int[] array = {8,9,9};
        int[] array = {9,9};
        System.out.println(maxProfit(array));
    }
}
