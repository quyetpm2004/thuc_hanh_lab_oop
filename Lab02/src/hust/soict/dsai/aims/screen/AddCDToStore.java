package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCDToStore extends AddMediaToStore {

    public AddCDToStore(Cart cart, Store store) {
        super(cart, store);
        setTitle("Add CD to Store");
    }

    @Override
    JPanel createCenter(Cart cart) {
        JPanel centerPanel = new JPanel(new GridLayout(8, 2, 5, 5));

        JLabel idLabel = new JLabel("ID:");
        JTextField idField = new JTextField();
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();
        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();
        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField();
        JLabel artistLabel = new JLabel("Artist:");
        JTextField artistField = new JTextField();
        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField();
        JLabel tracksLabel = new JLabel("Tracks (separated by ';'):");
        JTextField tracksField = new JTextField();

        centerPanel.add(idLabel);
        centerPanel.add(idField);
        centerPanel.add(titleLabel);
        centerPanel.add(titleField);
        centerPanel.add(categoryLabel);
        centerPanel.add(categoryField);
        centerPanel.add(costLabel);
        centerPanel.add(costField);
        centerPanel.add(artistLabel);
        centerPanel.add(artistField);
        centerPanel.add(directorLabel);
        centerPanel.add(directorField);
        centerPanel.add(tracksLabel);
        centerPanel.add(tracksField);

        JButton addButton = new JButton("Add");
        centerPanel.add(new JPanel()); // Placeholder for layout alignment
        centerPanel.add(addButton);

        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText().trim();
                String category = categoryField.getText().trim();
                float cost = Float.parseFloat(costField.getText());
                String artist = artistField.getText().trim();
                String director = directorField.getText().trim();
                String[] tracksArray = tracksField.getText().split(";");

                ArrayList<Track> trackList = new ArrayList<>();
                for (String track : tracksArray) {
                    String[] trackDetails = track.split("/");
                    if (trackDetails.length == 2) {
                        String trackTitle = trackDetails[0].trim();
                        int trackLength = Integer.parseInt(trackDetails[1].trim());
                        trackList.add(new Track(trackTitle, trackLength));
                    }
                }

                store.addMedia(new CompactDisc(id, title, category, cost, artist, trackList, director));
                JOptionPane.showMessageDialog(this, "CD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                idField.setText("");
                titleField.setText("");
                categoryField.setText("");
                costField.setText("");
                artistField.setText("");
                directorField.setText("");
                tracksField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please check your data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return centerPanel;
    }
}
