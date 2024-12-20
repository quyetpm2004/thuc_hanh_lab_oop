package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable   {
	// Tạo id cho đĩa
	public DigitalVideoDisc(int id, String title, String category,  float cost, String director, int length) {
		super(id, title, category, cost, director, length);
	}
	@Override
    public String toString() {
        return "DVD - " + "id: " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }

	@Override
	public void play() throws PlayerException {
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive.");
		}
		
	}
}
