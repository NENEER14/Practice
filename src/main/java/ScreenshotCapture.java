import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ScreenshotCapture {
	public static final long serialVersionUID = 1L;

	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.print("Enter any alpha to continue (x to exit): ");
            if(!input.hasNextInt()) {
                if(input.next().equals("x")) {
                    break;
                } else {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssa");
                    try {
                        Thread.sleep(120);
                        Robot r = new Robot();
                        String path = "C://Users//Neeraj.KUMAR//Downloads//Shot"+formatter.format(Calendar.getInstance().getTime())+".jpg";

                        Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                        BufferedImage Image = r.createScreenCapture(capture);
                        ImageIO.write(Image, "jpg", new File(path));



                        System.out.println("Screenshot saved");
                    } catch (AWTException | IOException | InterruptedException ex) {
                        System.out.println(ex);
                    }
                }  
            }
        }
        input.close();
	}
}
