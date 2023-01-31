package FurnitureFactorySimulator;

public class Table extends Furniture {
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
		case "TB1401":
			this.name = FurnitureNames.OBSIDIAN;
			break;
		case "TB1402":
			this.name = FurnitureNames.PEARL;
			break;
		case "TB1501":
			this.name = FurnitureNames.ELEGANT;
			break;
		case "TB1502":
			this.name = FurnitureNames.WALNUT;
			break;
		case "TB1403":
			this.name = FurnitureNames.GARDEN;
			break;
		default:
			System.out.println("OOPSIES");
			System.exit(0);
		}
	}
	
}
