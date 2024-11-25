package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
        // Tạo hai DVD
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Gọi phương thức swap (chỉ thay đổi tham chiếu cục bộ, không ảnh hưởng thực tế)
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        // Gọi phương thức changeTitle
//        changeTitle(jungleDVD, cinderellaDVD.getTitle());
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Phương thức swap sau khi sửa
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String tmp = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(tmp);
	}

    // Phương thức changeTitle
//    public static void changeTitle(DigitalVideoDisc dvd, String title) {
//        String oldTitle = dvd.getTitle();
//        dvd.setTitle(title);
//        dvd = new DigitalVideoDisc(oldTitle);
//    }
}
