package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		if(itemsInStore.contains(media)) {
			System.out.println("Media nay da ton tai");
		} else {
			itemsInStore.add(media);
		}
	}
	public void removeMedia(Media media) {
		if(itemsInStore.contains(media)) {
			itemsInStore.remove(media);
		} else {
			System.out.println("Media nay khong ton tai");
		}
	}
	public void printStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Danh sach media co trong store la: ");
		for(Media m: itemsInStore) {
			System.out.println(m.toString());
		}
		System.out.println("***************************************************\n");
	}
	public Media checkTitleInStore(String title) {
		for(Media m: itemsInStore) {
			if(m.isMatch(title)) {
				return m;
			}
		}
		return null;
	}
}
