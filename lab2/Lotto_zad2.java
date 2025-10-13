import java.util.Random;
import java.util.ArrayList;

public class Lotto_zad2 {
    public static void main(String[] args) {



        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random random = new Random();
        ArrayList<Integer> user_numbers = new ArrayList<Integer>();


        while(numbers.size()<6) {
            int n = random.nextInt(49) +1;
            if(!numbers.contains(n)) {
                numbers.add(n);
            }

        }

        for(int i = 0; i < numbers.size(); i++) {
            int a = Integer.parseInt(args[i]);
            if(a >= 1 && a<=49) {
                user_numbers.add(a);
            }
        }

        int Liczba_trafien = 0;
        for(int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < user_numbers.size(); j++) {
                if (numbers.get(i) == user_numbers.get(j)) {
                    Liczba_trafien++;
                }
            }
        }

        System.out.println(numbers);
        System.out.println(user_numbers);
        System.out.println(Liczba_trafien);

    }
}