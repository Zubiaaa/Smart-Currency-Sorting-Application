/*

*	Assignment Part B
*	The purpose is to implement the CoinSorterGUI class for Assignment.

*	*/
import javafx.application.Application;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextArea; 
import javafx.scene.control.TextField; 
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font; 
import javafx.scene.text.Text;
import javafx.stage.Stage; 
import javafx.geometry.Pos;
import javafx.geometry.Orientation;

public class CoinSorterGUI extends Application {
	// Declare and initial CoinSorter object and get the minCoinIn and maxCoinIn using it's methods
	private CoinSorter c = new CoinSorter();
	private int minCoinIn = c.getMinCoinIn();
	private int maxCoinIn = c.getMaxCoinIn();
	
	@Override
	public void start(Stage stage1) 
	{
		// Create and configure the text
		Text caption = new Text(68, -100, "***Coin Sorter - Main Menu***");         
		caption.setFill(Color.BLUE);         
		caption.setFont(Font.font ("Verdana", 15));
		 
		// create & configure a non-editable text area to display the results
		 TextArea display = new TextArea();        
		 display.setEditable(false);         
		 display.setMinSize(750,50);         
		 display.setMaxSize(750,50);
		 
		// Create a button for Option 1 (Coin calculator)        
		Button coinCalculator = new Button("Coin Calculator");
		// Create a button for Option 2 (Multiple Coin calculator)
		Button multipleCoinCalculator = new Button("Multiple Coin Calculator");
		// Create a button for Option 3 (Print coin list)
		Button printCoinList = new Button("Print Coin List");
		// Create a button for Option 4 (Set details)
		Button setDetails = new Button("Set Details");
		// Create a button for Option 5 (Display program configurations)
		Button displayConfigurations = new Button("Display program configurations");
		
		// create and configure an HBox for the labels and text inputs                       
		HBox hComponents = new HBox(10);
		hComponents.setAlignment(Pos.CENTER);
		//adding components to HBox
		hComponents.getChildren().addAll(coinCalculator, multipleCoinCalculator, printCoinList, setDetails, displayConfigurations);
		
		// create and configure a vertical container to hold all the components         
		VBox root = new VBox(25);         
		root.setAlignment(Pos.CENTER);        
		//adding components to VBox
		root.getChildren().addAll(caption, hComponents, display); 
					
		
					
		//setting the action the coinCalculator will take when pressed		
		coinCalculator.setOnAction(e -> 
		{
			display.clear();
			//To display title
			Text caption1 = new Text(70, -100, "Coin Calculator");
			caption1.setFont(Font.font ("Verdana", 15));
			//create and configure text fields for input or user entry(text input component)
			TextField totalValueField = new TextField();         
			totalValueField.setMaxWidth(50);
			TextField coinTypeField = new TextField();         
			coinTypeField.setMaxWidth(50);
			
			// create and configure Labels for the text fields
			Label totalValueLabel = new Label("Total Value");         
			totalValueLabel.setTextFill(Color.RED);         
			totalValueLabel.setFont(Font.font("Arial", 20));
			Label coinTypeLabel = new Label("CoinType");         
			coinTypeLabel.setTextFill(Color.RED);         
			coinTypeLabel.setFont(Font.font("Arial", 20));
			
			//Button enter
			Button enter = new Button("Enter");
			
			//setting the action the enter will take when pressed	
			enter.setOnAction(f ->
			{
				//operation throws a NumberFormatException
				try { 
					int totalValue, coinType;
					totalValue = Integer.parseInt(totalValueField.getText());
					coinType = Integer.parseInt(coinTypeField.getText());
					if ( totalValue < 0 || coinType <= 0) 
					{
						display.setText("Error: Invalid Value");
						}
					
					else if (totalValue < minCoinIn || totalValue > maxCoinIn) {
						display.setText("Error: Invalid Value");
						}
					
					else 
					{ display.setText(c.coinCalculator(totalValue, coinType));
					}
					
				}
				catch (NumberFormatException n)
				{
					display.setText("Error cannot convert " + totalValueField.getText() + " and " + coinTypeField.getText() + " to integers.");
				}
			
				
				
			});
			
			// button for returning back to the main-menu
			Button back = new Button("Back");
			
			//setting the action the back will take when pressed	
			back.setOnAction(y ->
			{
				display.clear();
				//clearing and adding new components to HBox
				hComponents.getChildren().clear();
				hComponents.getChildren().addAll(coinCalculator, multipleCoinCalculator, printCoinList, setDetails, displayConfigurations);
				
				//clearing and adding new components to VBox
				root.getChildren().clear();
				root.getChildren().addAll(caption, hComponents, display); 
			});
			
			//clearing and adding new components to VBox
			root.getChildren().clear();
			root.getChildren().addAll(caption1, back, totalValueLabel, totalValueField, coinTypeLabel, coinTypeField, display, enter);
			
			
		});
		 
		//setting the action the multipleCoinCalculator will take when pressed		
		multipleCoinCalculator.setOnAction(e -> 
		{
			display.clear();
			//To display title
			Text caption2 = new Text(70, -100, "Multiple Coin Calculator");
			caption2.setFont(Font.font ("Verdana", 15));
			//create and configure text fields for input or user entry(text input component)
			TextField totalValueField = new TextField();         
			totalValueField.setMaxWidth(50);
			TextField coinTypeField = new TextField();         
			coinTypeField.setMaxWidth(50);
			
			// create and configure Labels for the text fields
			Label totalValueLabel = new Label("Total Value");         
			totalValueLabel.setTextFill(Color.RED);         
			totalValueLabel.setFont(Font.font("Arial", 20));
			Label coinTypeLabel = new Label("CoinType");         
			coinTypeLabel.setTextFill(Color.RED);         
			coinTypeLabel.setFont(Font.font("Arial", 20));
			
			Button enter = new Button("Enter");
			
			//setting the action the enter will take when pressed	
			enter.setOnAction(f ->
			{
				try { 
					int totalValue, coinType;
					//operation throws a NumberFormatException
				    totalValue = Integer.parseInt(totalValueField.getText());
					coinType = Integer.parseInt(coinTypeField.getText());
					
					if ( totalValue < 0 || coinType <= 0) {
						display.setText("Error: Invalid Value");
						}
					
					else if (totalValue < minCoinIn || totalValue > maxCoinIn) {
						display.setText("Error: Invalid Value");
						}
					
					else 
					{ display.setText(c.multiCoinCalculator(totalValue, coinType));
					}
					
					}
				catch (NumberFormatException n)
				{
					display.setText("Error cannot convert " + totalValueField.getText() + " and " + coinTypeField.getText() + " to integers.");
				}
			
				
				
			});
			
			// button for returning back to the main-menu
			Button back = new Button("Back");
			
			//setting the action the back will take when pressed	
			back.setOnAction(y ->
			{
				display.clear();
				//clearing and adding new components to HBox
				hComponents.getChildren().clear();
				hComponents.getChildren().addAll(coinCalculator, multipleCoinCalculator, printCoinList, setDetails, displayConfigurations);
				
				//clearing and adding new components to VBox
				root.getChildren().clear();
				root.getChildren().addAll(caption, hComponents, display); 
			});
			
			//clearing and adding new components to VBox
			root.getChildren().clear();
			root.getChildren().addAll(caption2, back, totalValueLabel, totalValueField, coinTypeLabel, coinTypeField, display, enter);
			
			
		});
	
		//setting the action the printCoinList will take when pressed		
		printCoinList.setOnAction(e -> 
		{
			display.clear();
			display.setText(c.printCoinList());
			
		});
		
		
		// Create and configure FlowPane for the alignment of the contents in the Sub-Menu
		FlowPane pane = new FlowPane(Orientation.VERTICAL);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(25);
		
		//setting the action the setDetails will take when pressed		
		setDetails.setOnAction(e -> 
		{
			display.clear();
			// Create and configure the text
			Text captionSub = new Text(70, -100, "***Set Details Sub-Menu***");    
			captionSub.setFill(Color.BLUE);         
			captionSub.setFont(Font.font ("Verdana", 15));
			 
			// Sub Option 1
			Button currency = new Button("Set Currency");
			currency.setAlignment(Pos.CENTER_LEFT);
			// Sub Option 2
			Button minCoin = new Button("Set Minimum Coin Value");
			minCoin.setAlignment(Pos.CENTER);
			// Sub Option 3
			Button maxCoin = new Button("Set Maximum Coin Value");
			maxCoin.setAlignment(Pos.CENTER_RIGHT);
			
			// create & configure another non-editable text area to display the results
			TextArea displaySub = new TextArea();        
			displaySub.setEditable(false);         
			displaySub.setMinSize(200,50);         
			displaySub.setMaxSize(200,50);
			
			// create and configure another HBox for the labels and text inputs of sub-menu
			HBox hComponentSub = new HBox(10);
			hComponentSub.setAlignment(Pos.CENTER);        
			//adding new components to 2nd HBox
			hComponentSub.getChildren().addAll(currency, minCoin, maxCoin);
			//adding new components to FlowPane
			pane.getChildren().addAll(captionSub, hComponentSub);
			
			//setting the action the currency will take when pressed	
			currency.setOnAction(f -> 
			{
				displaySub.clear();
				//To display title
				Text caption3 = new Text(70, -100, "Setting Currency");
				caption3.setFont(Font.font ("Verdana", 15));
				//create and configure text fields for input or user entry(text input component)
				TextField currencyField = new TextField();         
				currencyField.setMaxWidth(50);
				currencyField.setAlignment(Pos.CENTER);
				
				// create and configure Labels for the text fields
				Label currencyLabel = new Label("Currency");  
				currencyLabel.setAlignment(Pos.CENTER_LEFT);
				currencyLabel.setTextFill(Color.RED);         
				currencyLabel.setFont(Font.font("Arial", 20));
				
				//button to enter the input
				Button enter = new Button("Enter");
				enter.setAlignment(Pos.BOTTOM_CENTER);
				
				//setting the action the enter will take when pressed	
				enter.setOnAction(g ->
				{
					if (currencyField.getText().isEmpty()) {
						displaySub.setText("Error: Invalid Value");
						}
					else 
					{ 
						c.setCurrency(currencyField.getText());
						displaySub.setText("Input Set!");
						}
					
				});
				
				//Button to return back to Sub-Menu
				Button back2 = new Button("Back");
				back2.setAlignment(Pos.TOP_LEFT);
				
				//setting the action the back2 will take when pressed	
				back2.setOnAction(y ->
				{
					displaySub.clear();
					//clearing and adding new components to 2nd HBox
					hComponentSub.getChildren().clear();
					hComponentSub.getChildren().addAll(currency, minCoin, maxCoin);
					
					//clearing and adding new components to FlowPane
					pane.getChildren().clear();
					pane.getChildren().addAll(captionSub, hComponentSub);
					
				});
				
				//clearing and adding new components to 2nd HBox
				hComponentSub.getChildren().clear();
				hComponentSub.getChildren().addAll(currencyLabel, currencyField);
				//clearing and adding new components to FlowPane
				pane.getChildren().clear();
				pane.getChildren().addAll(caption3, back2, hComponentSub, enter, displaySub);
					
			});
			
			
			minCoin.setOnAction(f -> 
			{
				displaySub.clear();
				//To display title
				Text caption4 = new Text(70, -100, "Setting Min Coin Value");
				caption4.setFont(Font.font ("Verdana", 15));
				//create and configure text fields for input or user entry(text input component)
				TextField minCoinField = new TextField();         
				minCoinField.setMaxWidth(50);
				minCoinField.setAlignment(Pos.CENTER);
				
				// create and configure Labels for the text fields
				Label minCoinLabel = new Label("Minimum Coin Input Value");         
				minCoinLabel.setTextFill(Color.RED);         
				minCoinLabel.setFont(Font.font("Arial", 20));
				minCoinLabel.setAlignment(Pos.CENTER_LEFT);
				
				//button to enter the input
				Button enter = new Button("Enter");
				enter.setAlignment(Pos.BOTTOM_CENTER);
				
				//setting the action the enter will take when pressed	
				enter.setOnAction(g ->
				{
					//operation throws a NumberFormatException
					try {
						
						minCoinIn = Integer.parseInt(minCoinField.getText());
						
						if ( minCoinIn < 0 ) {
							displaySub.setText("Error: Invalid Value");
							}
					else 
					{ 
						c.setMinCoinIn(minCoinIn);
						displaySub.setText("Input Set!");
					};
					
					}
					catch (NumberFormatException n)
					{
						displaySub.setText("Error cannot convert " + minCoinField.getText() + " to integer.");}
					});
				
				//Button to return back to Sub-Menu
				Button back2 = new Button("Back");
				back2.setAlignment(Pos.TOP_LEFT);
				
				//setting the action the back2 will take when pressed	
				back2.setOnAction(y ->
				{
					displaySub.clear();
					//clearing and adding new components to 2nd HBox
					hComponentSub.getChildren().clear();
					hComponentSub.getChildren().addAll(currency, minCoin, maxCoin);
					
					//clearing and adding new components to FlowPane
					pane.getChildren().clear();
					pane.getChildren().addAll(captionSub, hComponentSub); 
					
				});
				
				//clearing and adding new components to 2nd HBox
				hComponentSub.getChildren().clear();
				hComponentSub.getChildren().addAll(minCoinLabel, minCoinField);
				//clearing and adding new components to FlowPane
				pane.getChildren().clear();
				pane.getChildren().addAll(caption4, back2, hComponentSub, enter, displaySub);
			});
			
			maxCoin.setOnAction(f -> 
			{
				displaySub.clear();
				//To display title
				Text caption5 = new Text(70, -100, "Setting Max Coin Value");
				caption5.setFont(Font.font ("Verdana", 15));
				//create and configure text fields for input or user entry(text input component)
				TextField maxCoinField = new TextField();         
				maxCoinField.setMaxWidth(50);
				maxCoinField.setAlignment(Pos.CENTER);
				
				// create and configure Labels for the text fields
				Label maxCoinLabel = new Label("Maximum Coin Input Value");         
				maxCoinLabel.setTextFill(Color.RED);         
				maxCoinLabel.setFont(Font.font("Arial", 20));
				maxCoinLabel.setAlignment(Pos.CENTER_LEFT);
				
				//button to enter the input
				Button enter = new Button("Enter");
				enter.setAlignment(Pos.BOTTOM_CENTER);
				
				//setting the action the enter will take when pressed	
				enter.setOnAction(g ->
				{
					//operation throws a NumberFormatException
					try {
						maxCoinIn = Integer.parseInt(maxCoinField.getText());
						
						if ( maxCoinIn < 0 || maxCoinIn > 10000) {
							displaySub.setText("Error: Invalid Value");
							}
						
						else 
						{ 
							c.setMaxCoinIn(maxCoinIn);
							displaySub.setText("Input Set!");
							}
					
					} 
					catch (NumberFormatException n)
					{
						displaySub.setText("Error cannot convert " + maxCoinField.getText() + " to integer.");}
					});
				
				//Button to return back to Sub-Menu
				Button back2 = new Button("Back");
				back2.setAlignment(Pos.TOP_LEFT);
				
				//setting the action the back2 will take when pressed	
				back2.setOnAction(y ->
				{
					displaySub.clear();
					//clearing and adding new components to 2nd HBox
					hComponentSub.getChildren().clear();
					hComponentSub.getChildren().addAll(currency, minCoin, maxCoin);
					
					//clearing and adding new components to FlowPane
					pane.getChildren().clear();
					pane.getChildren().addAll(captionSub, hComponentSub);
					
				});
				
				//clearing and adding new components to 2nd HBox
				hComponentSub.getChildren().clear();
				hComponentSub.getChildren().addAll(maxCoinLabel, maxCoinField);
				
				//clearing and adding new components to FlowPane
				pane.getChildren().clear();
				pane.getChildren().addAll(caption5, back2, hComponentSub, enter, displaySub);
			});
			
			// create a new scene (for Sub-Menu) and add it to the new stage   
			//operation throws an Illegal Argument Exception
			try {
				Stage stage2 = new Stage();
				Scene scene2 = new Scene(pane, 800, 500);        
				stage2.setScene(scene2);         
				stage2.setTitle("Coin Sorter GUI Sub-Menu");        
				stage2.show();  
				
				} catch(IllegalArgumentException exception) 
				{
					display.setText("Error! Run the program again");
					}
			
					
		});
		
		//setting the action the displayConfiguration will take when pressed		
		displayConfigurations.setOnAction(e -> 
		{
			display.clear();
			display.setText(c.displayProgramConfigs());
			
		});
			

		
		// create a new scene (for main menu) and add it to the stage        
		Scene scene1 = new Scene(root, 800, 500);         
		stage1.setScene(scene1);         
		stage1.setTitle("Coin Sorter GUI Main Menu");        
		stage1.show();  
		
		
		
		
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		}
	
		
	
		
	
	}
	

