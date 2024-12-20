package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author da ton tai.");
        } else {
            authors.add(authorName);
            System.out.println("Author them thanh cong: " + authorName);
        }
	}
	public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author xoa thanh cong: " + authorName);
        } else {
            System.out.println("Author khong ton tai: " + authorName);
        }
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	@Override
    public String toString() {
        return "BOOK - " + "id: "  + this.getId() + " - " + this.getTitle() + " - " + this.getCategory()  + ": " + this.getCost() + " $";
    }

}
