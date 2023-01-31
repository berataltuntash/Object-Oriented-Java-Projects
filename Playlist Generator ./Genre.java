
public class Genre {
	private String name;
	private int id;
	Bag tracks = new Bag();
	
	public Genre(String name, int id) {
		this.name = name;
		this.id = id;
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public Bag getTracks() {
		return tracks;
	}
	public void setTracks(Bag tracks) {
		this.tracks = tracks;
	}
	
	
	
	
	
	
	//[1] Sleeping → [2, 1, 5]
	//[2] Workout → [4, 3, 6] 
	//[3] Dining → [5, 1, 2]
	//[4] Meditation → [2, 1, 5]
	//[5] Road Trip → [3, 6, 1]
	
}
