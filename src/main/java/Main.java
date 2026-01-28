import javax.imageio.ImageIO; /* Image formats management. Its main purpose is read and write image formats.
Image input/output utilities */
import javax.swing.*; /* GUI Toolkit. provides different tools for desktop Java apps.
JFrame (Main window), JLabel (Displays image), LOptionPane (displays error dialogs), Image Icon (Wraps an image, Swing renders it)*/
import java.awt.*; /* Graphics, usually represent visual properties, not full components.
Image, Color, BorderLayout*/
import java.io.IOException; //signals failures when reading streams or images.
import java.io.InputStream; /* Move data into and out program. Usually specially streams. Useful managing HTTP image data which arrives as a stream.
Stream-based I/O classes*/
import java.net.URI; /* Basic networking like URLs. Useful when used for URI. (API endpoint)
Network addressing and identifiers*/
import java.net.http.HttpClient; //Sends HTTP request
import java.net.http.HttpRequest; //Represents the HTTP request
import java.net.http.HttpResponse; /* Represents the HTTP response with a streamed body
HTTP communication classes*/

//This main is a method, the "static" here is not necessary cause the modern Java. The void indicates that nothing is returned.similar to "none" in python.
void main() {
//Like in python each program requires a main function that is the "body" of the program and is where is compiled the code that make the program run.
    try {
        var avatarStream = getRandomAvatarStream(); //getRandomAvatarStream() is the call method, returns an InputStream. "   avatarStream" a reference type.
        showAvatar(avatarStream); //showAvatar() call avatarStream and returns void. avatarStream is a reference and the method receives a copy of the reference.
    } catch (IOException | InterruptedException e) { /* Exception subtype in a reference type that represents the failure that occurred.
    the catch exception works similar than an "except" block in python */
        JOptionPane.showMessageDialog(null, "Failed to load avatar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } //inside this exception we find code that displays an error dialog. Return void. showMessageDialog is the static class method from the JOptionPane class.
      //getMessage is an instance method and "e" is the instance. The error message is a class variable (static)
}

InputStream getRandomAvatarStream() throws IOException, InterruptedException {
    /* Its purpose is fetch data as a stream
    IOException to manage stream failures and InterruptedException to request interruption.
     */
    // Pick a random style
    String[] styles = { "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral", "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps", "personas", "pixel-art", "pixel-art-neutral" };
    //String variable that contains a list of valid avatar styles that are actually more strings.
    var style = styles[(int)(Math.random() * styles.length)]; /* Style variable. random is the class method in the Math class.
    styles.lenght where style is an array object and length an instance variable in an int type.
    Finally, the variable contains a valid random array index. */

    // Generate a random seed
    var seed = (int)(Math.random() * 10000); //random is the class method in the Math class.
    //seed variable that contains a valid random seed. same idea than above.

    // Create an HTTP request for a random avatar
    var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed)); /*create is the class method in the URI class. Represents the API endpoint as a structured object.
    formatted is an instance method. The call method returns a new string with %s and %d replaced */
    var request = HttpRequest.newBuilder(uri).build(); /*newBuilder is the class method in the HttpRequest class.
    build was called on builder instance. It is an instance method.*/

    // Send the request
    try (var client = HttpClient.newHttpClient()) { /*try block to handle error where newHttpClient is class method of the HttpClient class
    Constructor call that creates an HTTP client with default configuration in the client var*/
        var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream()); /* send is the instance method in the instance client which returns an InputStream.
        ofInputStream is the class method in the BodyHandlers class. */
        return response.body(); //body is the instance method in the response instance. The call method returns an InputStream. Works as a live stream of PNG bytes.
    }
}

void showAvatar(InputStream imageStream) {
    //InputStream that is a reference type. Its purpose is to be the source of image bytes. Argument reference


    JFrame frame = new JFrame("PNG Viewer"); //constructor call. Creates a window object and also allocates native GUI resources.
    //PNG Viewer is reference argument
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //instance method in the instance frame. EXIT_ON_CLOSE is the class variable
    //JFrame.EXIT_ON_CLOSE is primitive argument
    frame.setResizable(false); //reference type which represents the window object that will display the avatar. setResizable is the instance method in the frame instance. Argument primitive
    frame.setSize(200, 200); //setSize is the instance method in the frame instance. Sets the initial pixels size. Argument primitive.
    frame.getContentPane().setBackground(Color.BLACK); /*frame.getContentPane() is an instance method which returns a container.
    setBackground is an instance method where Color.BLACK is the class variable*/

    try {
        // Load the PNG image
        Image image = ImageIO.read(imageStream); //read is the class method in the ImageIO class. A call method which reads bytes from stream
        //returns an Image object. reference argument

        // Create a JLabel to display the image
        JLabel imageLabel = new JLabel(new ImageIcon(image)); /* new ImageIcon(image) is a constructor call. Wraps image and Swing paints it.
        All the arguments are references: imageLabel references a JLabel, the JLabel references an ImageIcon and the ImageIcon references the Image.*/
        frame.add(imageLabel, BorderLayout.CENTER); //frame.add is and instance method. BorderLayout.CENTER is the class variable.

    } catch (IOException e) {
        JOptionPane.showMessageDialog(frame, "Failed to load image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    /* showMessageDialog is the class method (static) in the JOptionPane class.
    no value is returned (void). This exception displays a message that informs the user that the image failed to load.
     reference arguments except for JOptionPane.ERROR_MESSAGE that is primitive */

    frame.setVisible(true); // setVisible is the instance method in the frame instance
    // It makes the frame appear on the screen. The argument is boolean, means that is primitive.
}
