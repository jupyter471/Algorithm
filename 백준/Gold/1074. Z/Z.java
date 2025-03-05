import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();

        System.out.println(divide(N,R,C));
    }

    static int divide(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        //4개씩 계속 쪼개기
        //15 = divide(3번칸) * 4 + 사분면
        return divide(n-1, r / 2, c / 2) * 4 + ((r % 2) * 2 + (c % 2)) ;

        //0번 : r % 2 = 0, c % 2 = 0
        //1번 : r % 2 = 0, c % 2 = 1
        //2번 : r % 2 = 1, c % 2 = 0  -> r은 두번째 줄 * 2
        //3번 : r % 2 = 1, c % 2 = 1
    }
}
