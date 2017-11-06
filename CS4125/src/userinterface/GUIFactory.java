package userinterface;

public class GUIFactory {

	public static GUIFactory factInstance;
	
	private GUIFactory()
	{
		
	}
	
	public static synchronized GUIFactory createGUIFactory()
	{
		if(GUIFactory.factInstance==null)
		{
			return new GUIFactory();
		}
		else
		{
			return GUIFactory.factInstance;
		}
	}
	
	public StockChange createStockChange(String input)
	{
		switch(input)
		{
		case "addItem":
			return new StockAdd();
		case "removeItem":
			return new StockRemove();
		case "registerItem":
			return new StockRegister();
		case "deleteItem":
			return new StockDelete();
		case "updateItem":
			return new StockUpdate();
		default:
			return null;
		}
	}
	
}
