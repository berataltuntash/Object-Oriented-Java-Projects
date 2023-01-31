
public class Playlist {
	
	private String name;
	private int minDuration;
	private int[] selectedGenres;
	private Genre[] availableGenres;
	private int currentDuration = 0;
	private int totalPopularity = 0;
	private int numberOfTracks = 0;
	
	
	
	
	public Playlist(String name, int minDuration, int[] selectedGenres, Genre[] availableGenres) {
		
		this.name = name;
		this.minDuration = minDuration;
		this.selectedGenres = selectedGenres;
		this.availableGenres = availableGenres;
		createPlaylist();
	}




	private void createPlaylist() {
		while(currentDuration < minDuration) {
			for (int i = 0; i < selectedGenres.length; i++) {
				Genre priorityGenre = availableGenres[selectedGenres[i]-1];
				Object[] theTracks = priorityGenre.getTracks().getArray();
				for (int j = 0; j < theTracks.length; j++) {
					if(currentDuration < minDuration) {
						String mostPopularTrack = (String) theTracks[j];
						if(mostPopularTrack != null) {
							String[] trackInfo = mostPopularTrack.split(",");
							numberOfTracks++;
							currentDuration += Integer.parseInt(trackInfo[2]);
							totalPopularity += Integer.parseInt(trackInfo[3]);
						}
					}
					else {break;}
				}
			}
		}
		if(currentDuration >= minDuration) {
			System.out.println("Total number of tracks " + numberOfTracks);
			System.out.println("Duration " + currentDuration + " seconds");
			System.out.println("Average popularity " + (totalPopularity/numberOfTracks));
		}
		
		
	}
	
	
}



	