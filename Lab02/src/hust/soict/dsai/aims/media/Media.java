package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public Media(int id, String title, String category, float cost)  {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean isMatch(String matchTitle) {
        return this.getTitle().toLowerCase().contains(matchTitle.toLowerCase());
    }
	
	@Override
    public String toString() {
        return "Media - " + "id: " + " - " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + " $";
    }
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	

	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media other = (Media) obj; 
            return this.title != null && this.title.equals(other.title);
        }
        return false; 
    }

}
