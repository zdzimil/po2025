public class CodingBat {

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        }
        return false;
    }

    public boolean startHi(String str) {
        if(str(0)="h" && str(1)="i") {
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args) {
         CodingBat a = new CodingBat();
         a.sleepIn(false, false);
    }





}
