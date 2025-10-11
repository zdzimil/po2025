
public class Main {
    public static void main(String[] args) {

                System.out.println("Hello, World!");


                String gwiazda = "";
                int wysokosc = Integer.parseInt(args[0]);
                for(int i=1;i<=wysokosc ;i++) {
                    for (int j = 1; j <= wysokosc - i; j++) {
                    System.out.print(" ");
                    }
                    for (int k = 1; k <= 2 * i - 1; k++) {
                    gwiazda = "*";
                    System.out.print(gwiazda);
                    }
                System.out.println();

                }



    }
}