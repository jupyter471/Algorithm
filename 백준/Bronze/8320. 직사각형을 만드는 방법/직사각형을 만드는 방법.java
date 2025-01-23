import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j*i <= n; j++) {
                result += 1;
            }
        }

        System.out.println(result);


        sc.close();
    }
}
