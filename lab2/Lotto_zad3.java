import java.util.Random;
import java.util.ArrayList;

public class Lotto_zad3 {
    public static void main(String[] args) {




        Random random = new Random();

        int powtorzenia = 0;
        while(true) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            ArrayList<Integer> user_numbers = new ArrayList<Integer>();
            while (numbers.size() < 6) {
                int n = random.nextInt(49) + 1;
                if (!numbers.contains(n)) {
                    numbers.add(n);
                }

            }

            for (int i = 0; i < numbers.size(); i++) {
                int a = Integer.parseInt(args[i]);
                if (a >= 1 && a <= 49) {
                    user_numbers.add(a);
                }
            }

            numbers.retainAll(user_numbers);
            powtorzenia++;
            if(numbers.size()==6) {
                System.out.println(powtorzenia);
                break;
            }


        }




    }
}