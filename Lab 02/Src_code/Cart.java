package src;

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
		System.out.println("Dia da duoc them!");
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int check = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].equals(disc)) {
				check = 1;
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
	public float totalCost() {
		float sum = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
}
