package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks, int length, String director) {
		super(id, title, category, cost, director, length);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks, String director) {
		super(id, title, category, cost, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(int i, String string, String string2, float f, String string3, int j, String string4) {
		super(i, string, string2, f, string3, j);
		this.artist = string4;
	}

	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track da xoa thanh cong");
		} else {
			System.out.println("Track khong ton tai");
		}
	}
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Track da ton tai");
		} else {
			tracks.add(track);
			System.out.println("Track da duoc them");
		}
	}
	public String getArtist() {
		return artist;
	}
	public ArrayList<Track> getTracks() {
		return this.tracks;
	}
	@Override
    public String toString() {
        return "CD - " + "id: "  + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
	@Override
	public void play() throws PlayerException {
	    if (this.getLength() <= 0) {
	        throw new PlayerException("ERROR: CD length is non-positive.");
	    }

	    System.out.println("Playing CD: " + this.getTitle());
	    System.out.println("Artist: " + this.getArtist());

	    for (Track track : tracks) {
	        try {
	            track.play();
	        } catch (PlayerException e) {
	            throw new PlayerException("Error playing track: " + track.getTitle());
	        }
	    }
	}
}
