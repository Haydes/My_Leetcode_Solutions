package Easy;

/**
 * 
 * 121. Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 *
 */
public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = { 7, 6, 4, 1 };
		System.out.println(maxProfit(prices));
	}

	/**
	 * faster than 98.04%
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int max = 0;
		int buy = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < buy) {
				buy = prices[i];
			}
			max = Math.max(prices[i]-buy, max);
		}
		return max;
	}
}
