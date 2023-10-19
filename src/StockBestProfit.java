public class StockBestProfit {

	
//	7,1,5,3,6,4
//
//	nth day gives you (n-1) additional buy-sell combinations, but buying on min(1 to n-1) days is going to be the most profitable.
//
//	T(n) = max(T(n-1), a[n]-minBuy)
//	max(a[n] - a[i]) will be for i where a[i] = min(a[0] to a[n-1])
//
//	minBuy = INT_MAX;
//	maxProfit = INT_MIN;
//
//  for i = 0 < n; i++
//	  minBuy = min(minBuy, price[i])
//	  maxProfit = max(maxProfit, price[i] - minBuy)
	
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7,6,4,3,1}));
	}

	public static int maxProfit(int[] prices) {
		int minBuy = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;
		
		for ( int i : prices) {
			minBuy = Math.min(minBuy, i);
			maxProfit = Math.max(maxProfit, i - minBuy);
		}
		
		return maxProfit;
	}
}
