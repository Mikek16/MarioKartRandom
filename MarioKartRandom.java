import java.util.Random;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MarioKartRandom{

	
	public static final String [] SMALL_PLAYERS = {"Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy", "Toad", "Toadette", "Koopa Troopa", "Dry Bones"};
	public static final String [] MEDIUM_PLAYERS = {"Mario", "Luigi", "Peach", "Daisy", "Yoshi", "Birdo", "Diddy Kong", "Bowser Jr"};
	public static final String [] LARGE_PLAYERS = {"Wario", "Waluigi", "Donkey Kong", "Bowser", "King Boo", "Rosalina", "Funky Kong", "Dry Bowser"};
	public static final String [] SMALL_VEHICLES = {"Standard Kart S", "Standard Bike S", "Booster Seat", "Bullet Bike", "Mini Beast", "Bit Bike", "Cheep Charger", "Quaker", "Tiny Titan", "Magikruiser", "Blue Falcon", "Jet Bubble"};
	public static final String [] MEDIUM_VEHICLES = {"Standard Kart M", "Standard Bike M", "Classic Dragster", "Mach Bike", "Wild Wing", "Sugarscoot", "Super Blooper", "Zip Zip", "Daytripper", "Sneakster", "Sprinter", "Dolphin Dasher"};
	public static final String [] LARGE_VEHICLES = {"Standard Kart L", "Standard Bike L", "Offroader", "Flame Runner", "Flame Flyer", "Wario Bike", "Piranha Prowler", "Shooting Star" , "Jetsetter", "Spear", "Honey Coupe", "Phantom"};


	 public static String generateRandom(){
        Random r = new Random();
        int size, player, vehicle;
        size = r.nextInt(3);
        player = r.nextInt(8);
        vehicle = r.nextInt(12);
        String ret = "";

        switch(size){
        case 0: 
            ret += SMALL_PLAYERS[player] + " in the " + SMALL_VEHICLES[vehicle];
            break;
        case 1:
            ret += MEDIUM_PLAYERS[player] + " in the " + MEDIUM_VEHICLES[vehicle];
            break;
        case 2:
            ret += LARGE_PLAYERS[player] + " in the " + LARGE_VEHICLES[vehicle];
            break;
        }
        return ret;
    }


	public static void main(String [] args){
		for(int i = 0; i < Integer.parseInt(args[0]); i++){
			String temp = generateRandom();
			System.out.println("PLAYER " + (i + 1) + " is " + temp);
			BufferedImage image = null;
    try {
      image = ImageIO.read(new File("gallery/"+temp+".png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Create a panel to draw the image
    JPanel panel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
      }
    };

    // Create a frame to hold the panel
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    frame.setSize(image.getWidth(), image.getHeight());
    frame.setVisible(true);
			
		}
		  


	}
}