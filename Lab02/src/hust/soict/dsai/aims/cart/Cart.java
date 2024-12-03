package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private static int quantityMedia = 0;
	
	public void addMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			System.out.println("Media nay da ton tai");
		} else {
			itemsOrdered.add(media);
			quantityMedia++;
		}
	}
	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			quantityMedia--;
		} else {
			System.out.println("Media nay khong ton tai");
		}
	}

	public float totalCost() {
		float sum = 0;
		for(Media media: itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}
	public void print() {
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		int i = 0;
		for (Media media: itemsOrdered) {
			i++;
			System.out.println(i + ". " + media.toString());
		}
			
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************\n");
	}
	// sort theo tien den ten
	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	// sort theo ten den tien
	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}	

	
	public void searchById(int id) {
		boolean found = false;
		for (Media media: itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found: " + media.toString());
				found = true;
				break;
			}
		}

		if (!found)
			System.out.println("Can't found this id!");
	}
	public void searchByTitle(String title) {
		boolean found = false;
		for (Media media: itemsOrdered) {
			if (media.isMatch(title)) {
				System.out.println("Found: " + media.toString());
				found = true;
				break;
			}
		}

		if (!found)
			System.out.println("Can't found this title!");
	}
	public int getQuantityMediaInCart() {
		return quantityMedia;
	}
	public void removeCart() {
		itemsOrdered.clear();
	}
	
	// Filter theo tên
	public ArrayList<Media> filterByTilte(String title) {
		ArrayList<Media> filteredList = new ArrayList<Media>();
		for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().equals(title.toLowerCase())) {
                filteredList.add(media);
            }
        }
		return filteredList;
	}
	// Filter theo id
	public ArrayList<Media> filterById(int id) {
		ArrayList<Media> filteredList = new ArrayList<Media>();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                filteredList.add(media);
            }
        }
        return filteredList;
    }

}
