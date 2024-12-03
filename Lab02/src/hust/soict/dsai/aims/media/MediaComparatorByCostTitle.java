package hust.soict.dsai.aims.media;
import java.util.Comparator;

// gia tien truoc rồi den tiêu đề
public class MediaComparatorByCostTitle implements Comparator<Media> {

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media m1, Media m2) {
		int costComparison = Double.compare(m2.getCost(), m1.getCost());
        if (costComparison != 0) {
            return costComparison; 
        }
        
        return m1.getTitle().compareTo(m2.getTitle());
	}

}
