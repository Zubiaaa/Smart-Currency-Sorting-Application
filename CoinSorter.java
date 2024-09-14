/*

*	Assignment Part A
*	The purpose is to implement the CoinSorter class for Assignment.

*	*/


import java.util.*;
public class CoinSorter {
	
	private String currency;
	private int minCoinIn;
	private int maxCoinIn;
	private ArrayList<Integer> coinList = new ArrayList <Integer>();
	
	public CoinSorter(String currencyIn, int minCoin,int maxCoin, ArrayList<Integer> coinListIn) {
		currency = currencyIn;
		minCoinIn = minCoin;
		maxCoinIn = maxCoin;
		coinListIn.add(200);
		coinList.add(coinListIn.get(0));
		coinListIn.add(100);
		coinList.add(coinListIn.get(1));
		coinListIn.add(50);
		coinList.add(coinListIn.get(2));
		coinListIn.add(20);
		coinList.add(coinListIn.get(3));
		coinListIn.add(10);
		coinList.add(coinListIn.get(4));
	}
	
	public CoinSorter() {
		currency = "Pound sterling";
		minCoinIn = 0;
		maxCoinIn = 10000;
		coinList.add(200);
		coinList.add(100);
		coinList.add(50);
		coinList.add(20);
		coinList.add(10);
	}
	
	public void setCurrency(String currencyIn) {
		currency = currencyIn;
	}
	
	public void setMinCoinIn(int minCoin) {
		minCoinIn = minCoin;
	}
	
	public void setMaxCoinIn(int maxCoin) {
		maxCoinIn = maxCoin;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public int getMinCoinIn() {
		return minCoinIn;
	}
	
	public int getMaxCoinIn() {
		return maxCoinIn;
	}
	
	public String printCoinList() {
		
		int index = coinList.size()-1;
		while(index >= 0)  
		{
			coinList.get(index);
			index--;
			}
		return coinList.toString().replace('[', ' ').replace(']', ' ').strip() + " are the current coin denominations in circulation.";
		
	}
	
	public String coinCalculator(int totalValue, int coinType) {
		int result=0, mod=0;
		
		if ((totalValue >= minCoinIn) && (totalValue <= maxCoinIn)) {
			result = totalValue / coinType;
			mod = totalValue % coinType;
		}
		
		return "A total of " + result + " x " + coinType + "p coins can be exchanged, with a remainder of " + mod + "p";
	}
	
	public String multiCoinCalculator(int totalValue, int coinType) {
		
		int resultIn, minus;
		ArrayList<Integer> result = new ArrayList <Integer>();
		if ((totalValue >= minCoinIn) && (totalValue <= maxCoinIn)) {
			minus = totalValue;
			for(Integer index : coinList) {
				if(index != coinType) {
					resultIn = minus / index;
					result.add(resultIn);
					minus = totalValue % index;
					
				}
				else { 
					result.add(0);
				}
				
				index++;
				
			}
			
		}
		
		return "The coins exchanged are: " + result.get(0) + " x " + coinList.get(0) + "p, " + result.get(1) + " x " + coinList.get(1) + "p, " + result.get(2) + " x " + coinList.get(2) + "p, " + result.get(3) + " x " + coinList.get(3) + "p, " + result.get(4) + " x " + coinList.get(4) + "p, " + " with a remainder of " + totalValue % coinList.get(coinList.size()-1) + "p";
	}
	
	public String displayProgramConfigs() {
		return "The Current Currency : " + currency + ", The Current Minimum Coin to Exchange : " + minCoinIn + ", The Current Maximum Coin to Exchange : " + maxCoinIn;
	}
	
}
