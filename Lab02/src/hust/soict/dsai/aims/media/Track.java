package hust.soict.dsai.aims.media;

public class Track implements Playable {
	
	private String title;
	private int length;

	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		this.length = length;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track other = (Track) obj; 
            return super.equals(other) && this.length == other.length;
        }
        return false;
    }

}
