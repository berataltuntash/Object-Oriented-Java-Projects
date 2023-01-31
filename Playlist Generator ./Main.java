import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		File file = new File("data\\tracks.txt");
		Bag tracksData = new Bag();
		
		Genre[] genres = new Genre[6];
		genres[0] = new Genre("Acoustic", 1);
		genres[1] = new Genre("Instrumental", 2);
		genres[2] = new Genre("Rock", 3);
		genres[3] = new Genre("Rap", 4);
		genres[4] = new Genre("Jazz", 5);
		genres[5] = new Genre("Pop", 6);
		
		//genres[0].setTracks();
		
		
		Bag popularitySorter = new Bag();
		
		Bag playlistCreator = new Bag();
		
		Bag tracksSorted = new Bag();
		
		
		
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				tracksData.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Program terminated");
			e.printStackTrace();
		}
		
		
		for (int i =0; i<tracksData.size();i++) {       // I have sorted the genres to make it easy to sort by popularity
			String track = (String) tracksData.getArray()[i];      
			String[] info = track.split(",");
		 
			switch(Integer.parseInt(info[0])) {
				case 1: genres[0].getTracks().add(track);
					break;
				case 2: genres[1].getTracks().add(track);
					break;
				case 3: genres[2].getTracks().add(track);
					break;
				case 4: genres[3].getTracks().add(track);
					break;
				case 5: genres[4].getTracks().add(track);
					break;
				case 6: genres[5].getTracks().add(track);
					break;
			}
		}
		
		for ( int i = 0; i < genres.length; i++) {
			Object[] thetracks = genres[i].getTracks().getArray();     // Sorting by popularity
			String[] tracksToBeSorted = new String[thetracks.length];
			System.arraycopy(thetracks,0,tracksToBeSorted,0,thetracks.length);
			for(int j = 0; j < tracksToBeSorted.length; j++) {
				int maxPopularity = 0;
				int maxIndex = 0;
				for(int k = 0; k < tracksToBeSorted.length; k++) {
					if(tracksToBeSorted[k] != null) {
						String[] hey = tracksToBeSorted[k].split(",");
						int popularity = Integer.parseInt(hey[3]);
						if(popularity  > maxPopularity ) {
							maxPopularity = popularity;
							maxIndex = k;
						}
					}
					
				}
				tracksSorted.add(tracksToBeSorted[maxIndex]);
				tracksToBeSorted[maxIndex] = null;
			}
		}
		genres[0] = new Genre("Acoustic", 1);
		genres[1] = new Genre("Instrumental", 2);    
		genres[2] = new Genre("Rock", 3);
		genres[3] = new Genre("Rap", 4);
		genres[4] = new Genre("Jazz", 5);
		genres[5] = new Genre("Pop", 6);
		
		for (int i =0; i<tracksSorted.size(); i++) {
			String track = (String) tracksSorted.getArray()[i]; // Once again sorting by genres
			String[] info = track.split(",");
	
			switch(Integer.parseInt(info[0])) {
				case 1: genres[0].getTracks().add(track);
					break;
				case 2: genres[1].getTracks().add(track);
					break;
				case 3: genres[2].getTracks().add(track);
					break;
				case 4: genres[3].getTracks().add(track);
					break;
				case 5: genres[4].getTracks().add(track);
					break;
				case 6: genres[5].getTracks().add(track);
					break;
			}
		}
		for (int i = 0; i < genres.length; i++) {
			Genre theGenre = genres[i];
			int totalDuration = 0;
			for (int j = 0; j < theGenre.getTracks().size(); j++) {
				String trackInfo = (String) theGenre.getTracks().getArray()[j];
				totalDuration += Integer.parseInt(trackInfo.split(",")[2]);
			}
			System.out.println(theGenre.getName() + ": Number of tracks: " + theGenre.getTracks().size() + " Total duration: " + totalDuration);
			
		}	
		
		String type = "1";
		
		while (!type.equals("0")) {
			Playlist playlist;
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter the type of playlist you want! Type 0 to exit");
			type = userInput.nextLine();
			int[] selectedGenres;
			switch (type) {
			case "1": 
				selectedGenres = new int[] {2,1,5};
				playlist = new Playlist("Sleeping", 45*60,selectedGenres , genres ) ;
				break;
				
			case "2":
				selectedGenres = new int[] {4,3,6};
				playlist = new Playlist("Workout", 60*60,selectedGenres , genres ) ;
				break;
				
			case "3":
				selectedGenres = new int[] {5,1,2};
				playlist = new Playlist("Dining", 90*60,selectedGenres , genres ) ;
				break;
				
			case "4":
				selectedGenres = new int[] {2,1,5};
				playlist = new Playlist("Meditation", 120*60,selectedGenres , genres ) ;
				break;
				
			case "5":
				selectedGenres = new int[] {3,6,1};
				playlist = new Playlist("Road Trip", 180*60,selectedGenres , genres ) ;
				break;
				
			}
			
		}//[1] Sleeping → [2, 1, 5]
		//[2] Workout → [4, 3, 6] 
		//[3] Dining → [5, 1, 2]
		//[4] Meditation → [2, 1, 5]
		//[5] Road Trip → [3, 6, 1]
		
			
			
			
			
		}
	}
	
	


