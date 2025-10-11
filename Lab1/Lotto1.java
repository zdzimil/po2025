import java.util.Random;

public class Lotto1 {
    public static void main(String[] args) {
        int[] Numery = new int[6];
        Random random = new Random();
        Numery[0] = random.nextInt(49) + 1;
        Numery[1] = random.nextInt(49) + 1;
        Numery[2] = random.nextInt(49) + 1;
        Numery[3] = random.nextInt(49) + 1;
        Numery[4] = random.nextInt(49) + 1;
        Numery[5] = random.nextInt(49) + 1;

        for(int i=0;i<Numery.length-1;i++){
            for(int k=i+1;k<Numery.length;k++) {
                while(Numery[i]==Numery[k]){
                    Numery[k]= random.nextInt(49) + 1;
                }

            }


        }

        System.out.println("Lotto: " + Numery[0] + " " + Numery[1] + " " + Numery[2] + " " + Numery[3] + " " + Numery[4] + " " + Numery[5]);
    }
}