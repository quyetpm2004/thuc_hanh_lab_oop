package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "A", 145);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction",  19.95f, "A", 145);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Animation", "Aladin",  19.95f, "A", 145);

		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);

		store.removeMedia(dvd2);
		store.removeMedia(dvd3);
	}
}
