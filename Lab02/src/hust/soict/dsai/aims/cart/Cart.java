package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("Gio hang da day!");
			return;
		}
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered += 1;
		System.out.println("Dia" + disc.getTitle() +  "da duoc them!");
	}
	// Overloading 
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for(DigitalVideoDisc disc:dvdList) {
			if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
				System.out.println("Gio hang da day!");
				return;
			} 
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("Dia moi da duoc them!");
		}
	}
	
	// Overloading
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(qtyOrdered + 2 < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("Hai dia da duoc them!");
			return;
		} else if(qtyOrdered + 1 < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("Dia 1 duoc them va gio hang da day");
			return;
		} 
		System.out.println("Gio hang da day!");
		return;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int check = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].equals(disc)) {
				for(int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
	            System.out.println("Dia da duoc xoa!");
	            break;
			}
		}
		if(check == 0) System.out.println("Khong tim thay dia de xoa!");
	}
	
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");

		for (int i = 0; i < qtyOrdered; i++)
			System.out.println((i + 1) + ". " + itemsOrdered[i].toString());

		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************\n");
	}

	public float totalCost() {
		float sum = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
	public void searchById(int id) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println("Found: " + itemsOrdered[i].toString());
				found = true;
				break;
			}
		}

		if (!found)
			System.out.println("Can't found this id!");
	}

	public void searchByTitle(String title) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println("Found: " + itemsOrdered[i].toString());
				found = true;
				break;
			}
		}

		if (!found)
			System.out.println("Can't found this title!");
	}
	
}
