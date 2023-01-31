package FurnitureFactorySimulator;

public class Material {
	private String code;
	private float length;
	private float height;
	private float cost;
	
	public Material() {
		this.code = "";
		this.length = 0;
		this.height = 0;
		this.cost = 0;
		}
	public Material(String code,float length,float height,float cost) {
		this.code = code;
		this.length = length;
		this.height = height;
		this.cost = cost;
	}
	
	public String getCode() {
		return this.code;
	}
	public float getLength() {
		return this.length;
	}
	public float getCost() {
		return this.cost;
	}
	
	
}