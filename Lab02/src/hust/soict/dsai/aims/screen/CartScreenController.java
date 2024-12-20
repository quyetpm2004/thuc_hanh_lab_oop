package hust.soict.dsai.aims.screen;

import java.util.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CartScreenController {
     private Cart cart;
     private Store store;
     @FXML
     private TableView<Media> tblMedia;

    @FXML
     private TableColumn<Media, String> colMediaTitle;

     @FXML
     private TableColumn<Media, String> colMediacategory;

     @FXML
     private TableColumn<Media, Float> colMediaCost;
     
     @FXML
     private Button btnPlay;
     
     @FXML
     private Button btnRemove;
     
     @FXML
     private TextField tfFilter;
     
     @FXML
     private RadioButton radioBtnFilterId;
     
     @FXML
     private RadioButton radioBtnFilterTitle;
     
     @FXML
     private ToggleGroup filterCategory;
     
     @FXML 
     private Label totalCost;
     
     
     public CartScreenController(Cart cart, Store store) {
         super();
         this.cart = cart;
         this.store = store;
     }

     @FXML
     private void initialize() {
    	 colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
         colMediacategory.setCellValueFactory(new PropertyValueFactory<Media,String>("category"));
         colMediaCost.setCellValueFactory(new PropertyValueFactory<Media,Float>("cost"));
         tblMedia.setItems(FXCollections.observableList(this.cart.getItemsOrdered()));
         
         btnPlay.setVisible(false);
         btnRemove.setVisible(false);
         
         tblMedia.getSelectionModel().selectedItemProperty().addListener(
        		 new ChangeListener<Media>() {
        			 @Override
        			 public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
        				 if(newValue != null) {
        					 updateButtonBar(newValue);
        				 }
        			 }
        		 }
         );
         tfFilter.textProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observableValue, String s, String newValue) {
                 showFilterMedia(newValue);
             }
         });
         updateTotalCost();
     }

     @FXML
     void showFilterMedia(String newValue) {
         FilteredList<Media> filteredList = new FilteredList<>(FXCollections.observableList(this.cart.getItemsOrdered()), media -> true);

         filteredList.setPredicate(media -> {
             if (newValue == null || newValue.isEmpty()) {
                 return true;
             }

             String lowerCaseFilter = newValue.toLowerCase();

             if (radioBtnFilterId.isSelected()) {
                 return String.valueOf(media.getId()).toLowerCase().contains(lowerCaseFilter); 
             } else if (radioBtnFilterTitle.isSelected()) {
                 return media.getTitle().toLowerCase().contains(lowerCaseFilter);
             }
             return false; 
         });

         tblMedia.setItems(filteredList);
     }
     
     @FXML
     void viewStore(ActionEvent event) {
    	 new StoreScreen(store, cart);
     }

     void updateButtonBar(Media media) {
		// TODO Auto-generated method stub
		 btnRemove.setVisible(true);
		 if(media instanceof Playable) {
			 btnPlay.setVisible(true);
		 } else {
			 btnPlay.setVisible(false);
		 }
	 }
	
	void updateTotalCost() {
	    if (cart != null && totalCost != null) {
	        String formattedCost = String.format("%.2f", cart.totalCost());
	        totalCost.setText(formattedCost + " $");
	    } else {
	        System.err.println("Lỗi label không có");
	    }
	}
	 
	 @FXML
	 void btnRemovePressed(ActionEvent event) {
		 Media media = tblMedia.getSelectionModel().getSelectedItem();
		 cart.removeMedia(media);
		 updateTotalCost();
	 }
	 
	 @FXML
	 void placeOrder(ActionEvent event) {
		 if (cart == null || cart.getItemsOrdered().isEmpty()) {
		        Alert alert = new Alert(Alert.AlertType.WARNING);
		        alert.setTitle("Lỗi giỏ hàng");
		        alert.setHeaderText(null);
		        alert.setContentText("Giỏ hàng bị trống hãy order thêm!");
		        alert.showAndWait();
		        return;
		 }
	     // Xóa giỏ hàng
	     cart.removeCart();
	     
	     Alert alert = new Alert(Alert.AlertType.INFORMATION);
	     alert.setTitle("Đặt hàng thành công");
	     alert.setHeaderText(null);
	     alert.setContentText("Bạn đã đặt hàng thành công!");
	     alert.showAndWait();
	     
	     updateTotalCost();
	     tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
	     
	 }
	 
	 @FXML
	 void btnPlayDisc(ActionEvent event) {
	     // Lấy mục được chọn từ TableView
	     Media media = tblMedia.getSelectionModel().getSelectedItem();

	     // Kiểm tra nếu không có mục nào được chọn
	     if (media == null) {
	         Alert alert = new Alert(Alert.AlertType.WARNING);
	         alert.setTitle("Thông báo");
	         alert.setHeaderText(null);
	         alert.setContentText("Vui lòng chọn một mục để phát!");
	         alert.showAndWait();
	         return; // Dừng phương thức nếu không có mục được chọn
	     }

	     // Tạo cửa sổ phát Media
	     Stage playDialog = new Stage();
	     playDialog.setTitle("Play " + media.getTitle());

	     // Tạo container
	     VBox container = new VBox(10); // Khoảng cách giữa các phần tử là 10px
	     container.setStyle("-fx-padding: 10; -fx-alignment: top-left;");

	     if (media instanceof DigitalVideoDisc dvd) {
	         container.getChildren().addAll(
	             new Label("Playing DVD: " + dvd.getTitle()),
	             new Label("DVD length: " + dvd.getLength() + " min")
	         );
	     } else if (media instanceof CompactDisc cd) {
	         container.getChildren().addAll(
	             new Label("Title: " + cd.getTitle()),
	             new Label("Artist: " + cd.getArtist())
	         );

	         for (Track track : cd.getTracks()) {
	             container.getChildren().add(
	                 new Label("Play: " + track.getTitle() + ". Length: " + track.getLength() + " min")
	             );
	         }
	     }

	     // Đặt Scene cho Stage
	     Scene scene = new Scene(container);
	     playDialog.setScene(scene);

	     // Hiển thị cửa sổ
	     playDialog.show();
	 }

	 
 }
