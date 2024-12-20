package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static void main(String[] args) {
        // Tạo store
        Store store = new Store();
        Media cd1 = new CompactDisc(1, "Lang e vo", "Hai", 210f, "Chien Thang", 245, "Trinh Thang Binh");
        Media dvd1 = new DigitalVideoDisc(1, "Gia", "Hai", 290f, "Chien Thang", 245);
        Media book1 = new Book(2, "Cha giau cha ngheo", "Tien", 200f);
        Media cd2 = new CompactDisc(3, "Lang e vo 2", "Hai", 250f, "Chien Thang", 245, "Trinh Thang Binh");
        Media dvd2 = new DigitalVideoDisc(4, "Gia 2", "Hai", 240f, "Chien Thang", 245);
        Media book2 = new Book(5, "Cha giau cha ngheo 2", "Tien", 220f);
		store.addMedia(new Book(8, "Dac nhan tam", "Dao ly", 36, new ArrayList<>(List.of("Dale Carnegie"))));
		store.addMedia(new Book(9, "Dac nhan tam 2", "Dao ly", 21, new ArrayList<>(List.of("Dale Carnegie", "Dale Carnegie 2"))));
		ArrayList<Track> trackList = new ArrayList<Track>();
		Track newTrack1 = new Track("track1", 60);
		Track newTrack2 = new Track("track2", 30);
		Track newTrack3= new Track("track3", 20);
    	trackList.add(newTrack1);
    	trackList.add(newTrack2);
    	trackList.add(newTrack3);
		store.addMedia(new CompactDisc(7, "Ngắm hoa anh đào", "Tình yêu", 45, "Chí Phèo", trackList, "Director"));
        store.addMedia(cd1);
        store.addMedia(dvd1);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd2);
        store.addMedia(dvd2);

        // Tạo cart rỗng
        Cart cart = new Cart();
//
//        // Xử lý chương trình
//        boolean running = true;
//        Menu menu = new Menu();
//        Scanner sc = new Scanner(System.in);
//
//        while (running) {
//            clearConsole();
//            menu.showMenu();
//            int option = promptInt(sc, "Vui lòng chọn: ");
//
//            switch (option) {
//                case 1:
//                    handleViewStore(store, sc, cart);
//                    break;
//                case 2:
//                    handleUpdateStore(store, sc);
//                    break;
//                case 3:
//                    handleSeeCart(cart, sc);
//                    break;
//                case 0:
//                    System.out.println("Goodbye!");
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Lựa chọn không hợp lệ!");
//            }
//        }
//        sc.close();
        // Mở chương trình
        new StoreScreen(store, cart);
    }

    // Xóa console (nếu hệ điều hành hỗ trợ)
    public static void clearConsole() {
        for (int i = 0; i < 1; i++) {
            System.out.println(); // In dòng trống để đẩy nội dung cũ ra khỏi màn hình
        }
    }

    // Phương thức đọc số nguyên từ người dùng
    public static int promptInt(Scanner sc, String message) {
        int result = -1;
        while (true) {
            try {
                System.out.print(message);
                result = sc.nextInt();
                sc.nextLine(); // Xóa dấu xuống dòng
                return result;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                sc.nextLine(); // Xóa dữ liệu không hợp lệ
            }
        }
    }

    // Xử lý khi xem store
    public static void handleViewStore(Store store, Scanner sc, Cart cart) {
        boolean inStoreMenu = true;
        Menu menu = new Menu();
        store.printStore();
        while (inStoreMenu) {
            clearConsole();
            menu.storeMenu();
            int option = promptInt(sc, "Vui lòng chọn: ");

            switch (option) {
                case 1:
                    handleSeeMediaDetail(store, sc, menu);
                    break;
                case 2:
                    handleAddMediaToCart(store, sc, cart);
                    break;
                case 3:
                    handlePlayMedia(store, sc);
                    break;
                case 4:
                	cart.print();
                	break;
                case 0:
                    inStoreMenu = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Xử lý khi xem chi tiết media
    public static void handleSeeMediaDetail(Store store, Scanner sc, Menu menu) {
        System.out.print("Nhập tên media bạn muốn tìm: ");
        String inputTitle = sc.nextLine();
        Media media = store.checkTitleInStore(inputTitle);

        if (media == null) {
            System.out.println("Không tìm thấy media: " + inputTitle);
        } else {
            System.out.println("Chi tiết media:");
            System.out.println(media);
            menu.mediaDetailsMenu(media);
            System.out.println("Xin lỗi!! Chức năng này chưa được sử dụng....");
        }
    }

    // Xử lý thêm media vào cart
    public static void handleAddMediaToCart(Store store, Scanner sc, Cart cart) {
        System.out.print("Nhập tên media bạn muốn thêm: ");
        String inputTitle = sc.nextLine();
        Media media = store.checkTitleInStore(inputTitle);

        if (media == null) {
            System.out.println("Không tìm thấy media: " + inputTitle);
        } else {
            cart.addMedia(media);
            System.out.println("Thêm thành công. Cart hiện tại có: " + cart.getQuantityMediaInCart() + " media.");
            cart.print();
        }
    }

    // Xử lý khi play media
    public static void handlePlayMedia(Store store, Scanner sc) {
        System.out.print("Nhập tên media muốn play: ");
        String inputTitle = sc.nextLine();
        Media media = store.checkTitleInStore(inputTitle);

        if (media instanceof Disc) {
            System.out.println("Playing: " + media.getTitle());
            System.out.println("Chúc bạn thưởng thức bài hát vui vẻ!!!");
        } else {
            System.out.println("Media không phải dạng Disc!");
        }
    }

    // Xử lý khi update store
    public static void handleUpdateStore(Store store, Scanner sc) {
        System.out.println("Cập nhật store...");
        System.out.println("1. Thêm media");
        System.out.println("2. Xóa media");

        int option = promptInt(sc, "Chọn hành động: ");
        if (option == 1) {
        	String type, title, category, artist, director;
        	int id, length;
        	float cost;
            System.out.println("Thêm media mới vào store...");
            // Tính năng được tự động thêm...
            System.out.print("Nhập loại media: ");
            type = sc.next();
            if(type.equals("CD")) {
            	System.out.print("Nhập id: ");
            	id = sc.nextInt();
            	sc.nextLine();
            	System.out.print("Nhập title: ");
            	title = sc.nextLine();
            	System.out.print("Nhập category: ");
            	category = sc.nextLine();
            	System.out.print("Nhập director: ");
            	director = sc.nextLine();
            	System.out.print("Nhập length: ");
            	length = sc.nextInt();
            	sc.nextLine();
            	System.out.print("Nhập cost: ");
            	cost = sc.nextFloat();
            	sc.nextLine();
            	System.out.print("Nhập artist: ");
            	artist = sc.nextLine();
            	Media newMedia = new CompactDisc(id, title, category, cost, director, length, artist);
            	store.addMedia(newMedia);
            } else if (type.equals("Book")) {
            	System.out.print("Nhập id: ");
            	id = sc.nextInt();
            	sc.nextLine();
            	System.out.print("Nhập title: ");
            	title = sc.nextLine();
            	System.out.print("Nhập category: ");
            	category = sc.nextLine();
            	System.out.print("Nhập cost: ");
            	cost = sc.nextFloat();
            	Media newMedia = new Book(id, title, category, cost);
            	store.addMedia(newMedia);
            } else if (type.equals("DVD") ) {
            	System.out.print("Nhập id: ");
            	id = sc.nextInt();
            	sc.nextLine();
            	System.out.print("Nhập title: ");
            	title = sc.nextLine();
            	System.out.print("Nhập category: ");
            	category = sc.nextLine();
            	System.out.print("Nhập director: ");
            	director = sc.nextLine();
            	System.out.print("Nhập length: ");
            	length = sc.nextInt();
            	sc.nextLine();
            	System.out.print("Nhập cost: ");
            	cost = sc.nextFloat();
            	Media newMedia = new DigitalVideoDisc(id, title, category, cost, director, length);
            	store.addMedia(newMedia);
            } else {
            	System.out.println("Nhập sai type");
            }
            System.out.println("Tính năng được tự động thêm...");
            System.out.println("Thêm thành công!");
        } else if (option == 2) {
            System.out.print("Nhập tên media muốn xóa: ");
            String inputTitle = sc.nextLine();
            Media media = store.checkTitleInStore(inputTitle);

            if (media == null) {
                System.out.println("Không tìm thấy media!");
            } else {
                store.removeMedia(media);
                System.out.println("Xóa thành công!");
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    // Xử lý khi xem cart
    public static void handleSeeCart(Cart cart, Scanner sc) {
        boolean inCartMenu = true;
        Menu menu = new Menu();
        cart.print();
        while (inCartMenu) {
            clearConsole();
            menu.cartMenu();
            int option = promptInt(sc, "Vui lòng chọn: ");

            switch (option) {
                case 1:
                    handleFilterCart(cart, sc);
                    break;
                case 2:
                    handleSortCart(cart, sc);
                    break;
                case 5:
                    handlePlaceOrder(cart);
                    break;
                case 0:
                    inCartMenu = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Xử lý lọc cart
    public static void handleFilterCart(Cart cart, Scanner sc) {
        System.out.println("Lọc cart...");
        System.out.println("1. Theo ID");
        System.out.println("2. Theo Title");

        int option = promptInt(sc, "Chọn cách lọc: ");
        if (option == 1) {
            int id = promptInt(sc, "Nhập ID: ");
            cart.filterById(id).forEach(System.out::println);
        } else if (option == 2) {
            System.out.print("Nhập Title: ");
            String title = sc.nextLine();
            cart.filterByTilte(title).forEach(System.out::println);
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    // Xử lý sắp xếp cart
    public static void handleSortCart(Cart cart, Scanner sc) {
        System.out.println("Sắp xếp cart...");
        System.out.println("1. Theo giá, rồi tên");
        System.out.println("2. Theo tên, rồi giá");

        int option = promptInt(sc, "Chọn cách sắp xếp: ");
        if (option == 1) {
            cart.sortByCostTitle();
        } else if (option == 2) {
            cart.sortByTitleCost();
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
        cart.print();
    }

    // Xử lý đặt hàng
    public static void handlePlaceOrder(Cart cart) {
        System.out.println("Đặt hàng thành công!");
        cart.removeCart();
    }
}
