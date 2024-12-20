package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.CartScreen;

public class CartTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Media dvd1 = new DigitalVideoDisc(1, "The Lion King 1", "Animation", 19.95f , "Roger Allers" , 87);
		Media dvd2 = new DigitalVideoDisc(2, "The Lion King 2", "Animation", 19.95f , "Roger Allers" , 87);
		Media dvd3 = new DigitalVideoDisc(3, "The Lion King 3", "Animation", 19.95f , "Roger Allers" , 87);
		Media dvd4 = new DigitalVideoDisc(4, "The Lion King 4", "Animation", 19.95f , "Roger Allers" , 87);
		Media cd1 = new CompactDisc(1, "The CD", "Compact", 14.2f, "Chien Thang", 145, "Linh Can");
		Media book1 = new Book(1, "Rich father poor father", "Money", 20.45f);
		Media book2 = new Book(2, "Rich father poor father 2", "Money", 20.45f);
		Media book3 = new Book(3, "Rich father poor father 3", "Money", 20.45f);
//		cart.addMedia(cd1);
//		cart.addMedia(dvd1);
//		cart.addMedia(dvd2);
//		cart.addMedia(dvd3);
//		cart.addMedia(dvd4);
//		cart.addMedia(book1);
//		cart.addMedia(book2);
//		cart.addMedia(book3);
	}
}
