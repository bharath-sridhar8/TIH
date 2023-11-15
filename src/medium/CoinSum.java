package medium;

public class CoinSum {

	public static void main(String[] args) {
		CoinSum coinSum = new CoinSum();
		System.out.println(coinSum.coinChange(new int[]{186,419,83,408}, 166));
	}

	public int coinChange(int[] coins, int amount) {
		// int[10001] minCoins;
		// int minCoinDenom;
		// for i = 0; i < minCoinDenom; i++ -> minCoins[i] = -1;
		// for i = 0; i < coins.length; i++ -> minCoins[coins[i]] = 1;
		// for i = minCoinDenom + 1; i <= amount; i++ 
		//      minNumOfCoins = Integer.MAX_VALUE;
		//      for j = 0; j < coins.length; j++
		//          minNumOfCoins = min(minNumOfCoins, minCoins[coins[j]]);
		// return minCoins[amount];

		if (amount <= 0)
			return 0;
		
		int[] minCoins = new int[amount + 1];
		int minCoinDenom = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= amount)
				minCoins[coins[i]] = 1;
			minCoinDenom = Math.min(minCoinDenom, coins[i]);
		}
		
		for (int i = 0; i < minCoinDenom && i <= amount; i++) {
			minCoins[i] = -1;
		}
		if (minCoinDenom <= amount) {
			for (int i = minCoinDenom + 1; i <= amount; i++) {
				if (minCoins[i] == 1)
					continue;
				int minNumOfCoins = Integer.MAX_VALUE;
				for (int j = 0; j < coins.length; j++) {
					if (i > coins[j] && minCoins[i - coins[j]] != -1) {
						minNumOfCoins = Math.min(minNumOfCoins, minCoins[i - coins[j]] + 1);
					}
				}
				minCoins[i] = minNumOfCoins == Integer.MAX_VALUE ? -1 : minNumOfCoins;
			}	
		}
		return minCoins[amount];
	}

}
