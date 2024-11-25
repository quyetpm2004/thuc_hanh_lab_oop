package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

	public void addDVD(DigitalVideoDisc dvd) {
		if (dvd != null && dvd.getLength() > 0) {
			itemsInStore.add(dvd);
			System.out.println("Added DVD: " + dvd.getTitle());
		} else if (dvd.getLength() <= 0)
			System.out.println("The DVD \"" + dvd.getTitle() + "\" cannot add because its length is zero or less.");
		else
			System.out.println("Cannot add a null DVD!");
	}

	public void removeDVD(DigitalVideoDisc dvd) {
		if (itemsInStore.contains(dvd)) {
			itemsInStore.remove(dvd);
			System.out.println("Removed DVD: " + dvd.getTitle());
		} else
			System.out.println("DVD not found in the store.");
	}
}
