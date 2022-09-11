import java.util.ArrayList;
import java.util.LinkedList;

public class Albums {
	
	private String name;
	private String artist;
	private ArrayList<Songs> songs;
	
	public Albums(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Songs>();
	}
	
	public Albums() {
		
	}
	
	public Songs findSong(String title) {
		for(Songs checkedSongs : songs) {
			if(checkedSongs.getTitle().equals(title)) {
				return checkedSongs ;
			}
		}
		return null;
		
	}
	
	public boolean addSong(String title, double duration) {
		if(findSong(title) == null) {
			songs.add(new Songs(title,duration));
			return true;
		}else {
			return false;
		}
	}
	
	public boolean addToPlayList(int trackNumber, LinkedList<Songs> PlayList) {
		int index = trackNumber - 1;
		if(index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}
		return false;
	}
	
	public boolean addToPlayList(String title, LinkedList<Songs> PlayList) {
		for(Songs checkedSongs : this.songs) {
			
			if(checkedSongs.getTitle().equals(title)) {
				PlayList.add(checkedSongs);
				return true;
				
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	

}
