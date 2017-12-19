package imagecapturingdevice;

import java.util.Scanner;

public class ImageCapturingDevice implements ImageCapturingdevice{
    private Scanner scanner;
    public ImageCapturingDevice (){this.scanner=new Scanner(System.in);}
@Override
public String capture()
{
   System.out.println("Enter byte array");
   String byteArray= scanner.nextLine();
   return byteArray;
}

}
