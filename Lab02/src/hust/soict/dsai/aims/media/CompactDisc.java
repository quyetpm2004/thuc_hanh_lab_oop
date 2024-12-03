package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	public CompactDisc(int id, String title, String category,  float cost, String director, int length, String artist) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost, director, length);
		this.artist = artist;
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
	@Override
    public String toString() {
        return "CD - " + "id: "  + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
	@Override
	public void play() {
		System.out.println("Playing CD: " + getTitle() + " by " + artist);
        System.out.println("Total length: " + getLength() + " mins");

        // Lặp qua mỗi track và gọi method play của Track
        for (Track track : tracks) {
            track.play();  // Gọi method play của từng track
        }
	}
}
