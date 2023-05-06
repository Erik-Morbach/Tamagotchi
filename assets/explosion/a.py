from PIL import Image

# Open the GIF file
with Image.open("explosion.gif") as im:

    # Iterate over each frame in the GIF
    for i in range(im.n_frames):
        
        # Select the current frame
        im.seek(i)
        
        # Save the current frame as a PNG file
        filename = f"explosionF{i}.png"
        im.save(filename, "PNG")
        
        print(f"Saved {filename}")

