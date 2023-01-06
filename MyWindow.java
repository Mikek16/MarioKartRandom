import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.net.URL;


public class MyWindow extends JFrame {

    public  final String [] SMALL_PLAYERS = {"Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy", "Toad", "Toadette", "Koopa Troopa", "Dry Bones","Small Mii"};
    public  final String [] MEDIUM_PLAYERS = {"Mario", "Luigi", "Peach", "Daisy", "Yoshi", "Birdo", "Diddy Kong", "Bowser Jr","Medium Mii"};
    public  final String [] LARGE_PLAYERS = {"Wario", "Waluigi", "Donkey Kong", "Bowser", "King Boo", "Rosalina", "Funky Kong", "Dry Bowser","Large Mii"};
    public  final String [] SMALL_VEHICLES = {"Standard Kart S", "Standard Bike S", "Booster Seat", "Bullet Bike", "Mini Beast", "Bit Bike", "Cheep Charger", "Quacker", "Tiny Titan", "Magikruiser", "Blue Falcon", "Jet Bubble"};
    public  final String [] MEDIUM_VEHICLES = {"Standard Kart M", "Standard Bike M", "Classic Dragster", "Mach Bike", "Wild Wing", "Sugarscoot", "Super Blooper", "Zip Zip", "Daytripper", "Sneakster", "Sprinter", "Dolphin Dasher"};
    public  final String [] LARGE_VEHICLES = {"Standard Kart L", "Standard Bike L", "Offroader", "Flame Runner", "Flame Flyer", "Wario Bike", "Piranha Prowler", "Shooting Star" , "Jetsetter", "Spear", "Honey Coupe", "Phantom"};

    public MyWindow() throws IOException{
        // Set the window title
        super("My Window");
         
        // Replace YOUR_SEARCH_QUERY with the search query you want to use
        
        // Set the window size
        setSize(800, 300);

        // Set the window layout
        setLayout(new FlowLayout());

        // Create a label with some text
        JLabel label = new JLabel("Random Generator!");

        // Create an image icon
        ImageIcon icon = new ImageIcon("download.jpg");

         // Set the default close operation to exit the program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label to display the image
        JLabel imageLabel = new JLabel(icon);

        // Create a button with some text
        JButton button = new JButton("Generate a new Random");

        // Add the button to the window
        add(button);

        // Add the label and image label to the window
        add(label);
        add(imageLabel);

        // Display the window
        setVisible(true);


        button.addActionListener(event -> {
        String str = generateRandom();

        label.setText(str);
        str = str.replaceAll("\\s", "");
        str += ".png";
        System.out.println(str);
        imageLabel.setIcon(new ImageIcon("gallery/"+str));

        repaint();
    });

    }

    public String generateRandom(){
        Random r = new Random();
        int size, player, vehicle;
        size = r.nextInt(3);
        player = r.nextInt(9);
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

    public static void main(String[] args) {
        try {
    new MyWindow();
}
catch(IOException e) {
  e.printStackTrace();
}
    }
}
