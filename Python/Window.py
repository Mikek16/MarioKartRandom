import tkinter as tk
import random as r
CHARACTERS = [
 ["Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy", "Toad", "Toadette", "Koopa Troopa", "Dry Bones","Small Mii"]
,["Mario", "Luigi", "Peach", "Daisy", "Yoshi", "Birdo", "Diddy Kong", "Bowser Jr","Medium Mii"]
,["Wario", "Waluigi", "Donkey Kong", "Bowser", "King Boo", "Rosalina", "Funky Kong", "Dry Bowser","Large Mii"]
]
VEHICLES = [
["Standard Kart S", "Standard Bike S", "Booster Seat", "Bullet Bike", "Mini Beast", "Bit Bike", "Cheep Charger", "Quacker", "Tiny Titan", "Magikruiser", "Blue Falcon", "Jet Bubble"]
 ,["Standard Kart M", "Standard Bike M", "Classic Dragster", "Mach Bike", "Wild Wing", "Sugarscoot", "Super Blooper", "Zip Zip", "Daytripper", "Sneakster", "Sprinter", "Dolphin Dasher"]
,["Standard Kart L", "Standard Bike L", "Offroader", "Flame Runner", "Flame Flyer", "Wario Bike", "Piranha Prowler", "Shooting Star" , "Jetsetter", "Spear", "Honey Coupe", "Phantom"]
]
# Create the main window
window = tk.Tk()

# Set the window title
window.title("My Window")

# Set the window size
window.geometry("300x200")

image = tk.PhotoImage(file="MarioKart.ppm")
picture_label = tk.Label(window, image=image)

def button_clicked():
	rand = r.randint(0,2)
	words = (str(r.sample(CHARACTERS[0],1) + r.sample(VEHICLES[0],1)))
	words = words.replace("[","")
	words = words.replace("]","")
	words = words.replace(",","")
	words = words.replace("'","")
	label.config(text = words)
	words = words.replace(" ","")
	words = words.lower()
	image.config(file=str(words+".ppm"))

	print(words)

# Create a button
button = tk.Button(window, text="Generate Random", command=button_clicked)

#label
label = tk.Label(window, text="This is a label")


# Pack the button (display it on the window)
button.pack()
# Pack the label (display it on the window)
label.pack()
picture_label.pack()
# Run the Tkinter event loop
window.mainloop()