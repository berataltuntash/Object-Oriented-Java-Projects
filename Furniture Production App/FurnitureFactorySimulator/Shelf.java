package FurnitureFactorySimulator;

public class Shelf extends Furniture{
	private FurnitureNames name;
	@Override
	public int calculateQuality() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void nameAssessor(String name) {
		switch(name) {
		case "WS2201":
			this.name = FurnitureNames.LAVINIA;
			break;
		case "WS2202":
			this.name = FurnitureNames.LOKI;
			break;
		case "WS2203":
			this.name = FurnitureNames.ATLAS;
			break;
		default:
			System.out.println("OPSIESS");
			System.exit(0);
		}
	}
	
}
