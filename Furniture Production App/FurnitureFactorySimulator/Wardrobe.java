package FurnitureFactorySimulator;

public class Wardrobe extends Furniture{
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
		case "SH5001":
			this.name = FurnitureNames.CORNER;
			break;
		case "SH5002":
			this.name = FurnitureNames.HARMONY;
			break;
		case "SH5003":
			this.name = FurnitureNames.LUNA;
			break;
		case "SH5101":
			this.name = FurnitureNames.HITTITE;
			break;
		default:
			System.out.println("OPSIESS");
			System.exit(0);
		}
		
	}

}
