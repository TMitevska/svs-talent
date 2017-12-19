import java.util.Scanner;

public class ZipCode {


    public static void main(String[] argc) {
        Scanner s = new Scanner(System.in);
        Zip temp;
        tuka:
        while (true) {
            System.out.println("Enter city name");
            String city = s.next();
            System.out.println("Enter zipcode");
            String code = s.next();

            try {
                temp = new Zip(city, code);
                temp.show();
                break tuka;
            } catch (ZipException z) {
                System.out.println("ZipCode lenght is not equal to six or nine!");
            }
        }

        try {
            temp.setZip("234785");
            temp.show();
        } catch (ZipException z) {
            System.out.println("ZipCode lenght is not equal to six or nine!");
        }
        try {
            temp.setZip("12");
            temp.show();
        } catch (ZipException z) {
            System.out.println("ZipCode lenght is not equal to six or nine!");
        }

    }
}
