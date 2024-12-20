package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		Media dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "A", 145);
		Media dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction",  19.95f, "A", 145);
		Media dvd3 = new DigitalVideoDisc(3, "Animation", "Aladin",  19.95f, "A", 145);
		Media book1 = new Book(1, "Rich father poor father", "Money", 20.45f);
		Media book2 = new Book(2, "Rich father poor father 2", "Money", 20.45f);
		
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(book1);
		store.addMedia(book2);

		new StoreScreen(store, cart);
		
	}
}
