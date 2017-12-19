public class Zip {
    private String city;
    private String code;

    Zip() {
        this.code = this.city = "";
    }

    Zip(String a, String b) throws ZipException {
        this.city = a;
        if (b.toCharArray().length == 6 || b.toCharArray().length == 9) {
            this.code = b;
        } else {
            this.code = "";
            throw new ZipException();
        }
    }

    public void setIme(String a) {
        this.city = a;
    }

    public void setZip(String a) throws ZipException {
        if (a.toCharArray().length == 6 || a.toCharArray().length == 9) {
            this.code = a;
        } else {
            this.code = "";
            throw new ZipException();
        }
    }

    public void show() {
        System.out.println("Zipcode for " + this.city + " is " + this.code);
    }

}