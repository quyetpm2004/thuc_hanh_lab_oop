package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MediaStore extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MediaStore(Media media, Cart cart) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAdd = new JButton("Add to cart");
        container.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
            }
        });
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
            container.add(playButton);

            // Add ActionListener for Play button
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	JDialog playDialog = createPlayDialog(media);
                    playDialog.setVisible(true);
                    playDialog.setSize(300,200);
                    playDialog.pack();
                }
            });
		}
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
	
	static JDialog createPlayDialog(Media media) {
	    JDialog playDialog = new JDialog();
	    Container container = playDialog.getContentPane();
	    playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
	    container.add(Box.createRigidArea(new Dimension(10, 10)));

	    if (media instanceof DigitalVideoDisc dvd) {
	        container.add(new JLabel("Playing DVD: " + dvd.getTitle()));
	        container.add(new JLabel("DVD Length: " + dvd.getLength() + " min"));
	    } else if (media instanceof CompactDisc cd) {
	        container.add(new JLabel("Playing CD: " + cd.getTitle()));
	        container.add(new JLabel("Artist: " + cd.getArtist()));
	        container.add(Box.createRigidArea(new Dimension(5, 5)));

	        if (!cd.getTracks().isEmpty()) {
	            for (Track track : cd.getTracks()) {
	                try {
	                    track.play();
	                    container.add(new JLabel("Playing Track: " + track.getTitle()));
	                    container.add(new JLabel("Track Length: " + track.getLength() + " min"));
	                } catch (PlayerException e) {
	                    container.add(new JLabel("Error playing track: " + track.getTitle()));
	                }
	            }
	        } else {
	            container.add(new JLabel("No tracks available to play."));
	        }
	    }

	    playDialog.setTitle("Play " + media.getTitle());
	    playDialog.setSize(400, 300);
	    playDialog.setLocationRelativeTo(null);
	    return playDialog;
	}
}