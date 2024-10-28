package src;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
//		Tạo đĩa dvd4 để test removeDigital
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Vivo", "Animation", 25.99f);
		
		System.out.print("Total Cose is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.removeDigitalVideoDisc(dvd4); 
		anOrder.removeDigitalVideoDisc(dvd3); 
		
		System.out.print("Total Cose after removed is: ");
		System.out.println(anOrder.totalCost());
	}
}
