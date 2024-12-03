package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Media> mediae = new ArrayList<Media>();
		Media book = new Book(1, "Cha giau cha ngheo", "Tien", 10.4f);
		Media cd = new CompactDisc(1, "Tuyet doi dien anh", "Giai tri", 10.5f, "DUC", 224, "QUYET");
		Media dvd = new DigitalVideoDisc(1, "Lang e vo", "Hai", 20.4f, "DUC", 124);
				
		mediae.add(book);
		mediae.add(dvd);
		mediae.add(cd);
		for(Media m: mediae) {
			System.out.println(m.toString());
		}
	}

}
