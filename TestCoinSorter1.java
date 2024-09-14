/*

*	Assignment Part A
*	The purpose is to implement the TestCoinSorter1 class for Assignment.

*	*/

import java.util.*;

public class TestCoinSorter1 {

	public static void main(String[] args) {

		int choice1 = 0, choiceSub1 = 0, totalValue1 = 0, coinType1 = 0;
		String choice = "", choiceSub = "", totalValue = "", coinType = "", minCoin = "", maxCoin = "";
		Scanner sc = new Scanner(System.in);

		// Declaring and Initializing CoinSorter's Object, minCoinIn, maxCoinIn, and currencyIn
		CoinSorter c1 = new CoinSorter();
		int minCoinIn = c1.getMinCoinIn();
		int maxCoinIn = c1.getMaxCoinIn();
		String currencyIn = c1.getCurrency();
		
		do {

			System.out.println("\n");
			System.out.println("***Coin Sorter - Main Menu***");
			System.out.println("1 - Coin calculator");
			System.out.println("2 - Multiple coin calculator");
			System.out.println("3 - Print coin list");
			System.out.println("4 - Set details");
			System.out.println("5 - Display program configurations");
			System.out.println("6 - Quit the program");
			choice = sc.nextLine();

			try {
				choice1 = Integer.parseInt(choice);

				// Option 1 and Option 2
				if (choice1 == 1 || choice1 == 2) 
				{
					System.out.println("Enter the total value to exchange : ");
					totalValue = sc.nextLine();
					System.out.println("Enter the Coin Type : ");
					coinType = sc.nextLine();
					try {
						totalValue1 = Integer.parseInt(totalValue);
						coinType1 = Integer.parseInt(coinType);

						if (totalValue1 < 0 || coinType1 <= 0) {
							System.out.println("Error: Invalid Value");
						}
						
						else if (totalValue1 < minCoinIn || totalValue1 > maxCoinIn) {
							System.out.println("Error: Invalid Value");
						}
						
						else {

							if (choice1 == 1) {
								System.out.print(c1.coinCalculator(totalValue1, coinType1));
							}

							else {
								System.out.print(c1.multiCoinCalculator(totalValue1, coinType1));
							}
						}
					} catch (NumberFormatException e) {
						System.out.println("Error cannot convert " + totalValue + " and " + coinType + " to integers.");
					}
				}

				// Option 3
				if (choice1 == 3) {
					System.out.println(c1.printCoinList());
				}

				// Option 4
				if (choice1 == 4) {

					do {
						System.out.println("***Set Details Sub-Menu***");
						System.out.println("1 - Set currency");
						System.out.println("2 - Set minimum coin input value");
						System.out.println("3 - Set maximum coin input value");
						System.out.println("4 - Return to main menu");
						choiceSub = sc.nextLine();

						try {
							choiceSub1 = Integer.parseInt(choiceSub);

							if (choiceSub1 == 1) {
								System.out.println("Enter the Currency: ");
								currencyIn = sc.nextLine();
								if(currencyIn.isEmpty()) {
									System.out.println("Error: A currency should be entered");
								}
								c1.setCurrency(currencyIn);

							}

							else if (choiceSub1 == 2) {
								System.out.println("Enter the Minimum Value for Exchange in Pennies: ");
								minCoin = sc.nextLine();
								try {
									minCoinIn = Integer.parseInt(minCoin);
									
									if (minCoinIn < 0) {
										System.out.println("Error: Invalid Value");
									}
									else {
										c1.setMinCoinIn(minCoinIn);
									}
									
								} catch (NumberFormatException e) {
									System.out.println("Error cannot convert " + minCoin + "to integer.");
								}

							}

							else if (choiceSub1 == 3) {
								System.out.println("Enter the Maximum Value for Exchange in Pennies: ");
								maxCoin = sc.nextLine();
								try {
									maxCoinIn = Integer.parseInt(maxCoin);	
									if (maxCoinIn < 0 || maxCoinIn > 10000) {
										System.out.println("Error: Invalid Value");
									}
									else {
										c1.setMaxCoinIn(maxCoinIn);
									}
									
								} catch (NumberFormatException e) {
									System.out.println("Error cannot convert " + maxCoin + "to integer.");
								}

							}
						} catch (NumberFormatException e) {
							System.out.println("Error cannot convert " + choiceSub + "to integer.");
						}

					} while (choiceSub1 != 4);

				}

			} catch (NumberFormatException e) {
				System.out.println("Error cannot convert " + choice + "to integer.");
			}

			// Option5
			if (choice1 == 5) {
				System.out.println(c1.displayProgramConfigs());
			}

		} while (choice1 != 6);
		

	}

}
