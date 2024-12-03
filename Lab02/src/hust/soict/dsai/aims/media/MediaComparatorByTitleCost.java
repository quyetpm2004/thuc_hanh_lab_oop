package hust.soict.dsai.aims.media;

import java.util.Comparator;

// tieu de truoc gia sau anphabet
public class MediaComparatorByTitleCost implements Comparator<Media> {

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compare(Media m1, Media m2) {
		int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison; 
        }
        
        return Double.compare(m2.getCost(), m1.getCost());
	}

}
