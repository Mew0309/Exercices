import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter milliseconds please: ");
        long millis =  input.nextLong();
    }
    public static String convertMillis(long millis) {
        millis /= 1000;

        String currentMinuteAndSecond = " ";
        for (int i = 0; i < 2; i++){
            currentMinuteAndSecond = ":" + millis % 60 + currentMinuteAndSecond;
            millis /=60;
        }
        return millis + currentMinuteAndSecond;
    }
}