package ua.nure.cherevan.task1;

import java.util.ArrayList;
import java.util.List;

public class Part6 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        int nextP = nextPrime(n);

        System.out.println("next prime = " + nextP + "\n");

        int[] divisors = primeDivisors(n);

        List<String> strList = new ArrayList<>(divisors.length);
        for (int e : divisors) {
            strList.add(String.valueOf(e));
        }

        System.out.println("prime divisors: " + String.join(" * ", strList) + "\n");
    }

    public static int nextPrime(int n) {
        while(true) {
            int c = 1;
            n++;

            for (int i = 2; i <= n; i++)
                if (n % i == 0)
                    c++;

            if (c == 2)
                return n;
        }
    }

    public static boolean isPrime(int n) {

        for (int i = 2; i < n/2; i++){
            if (n % i == 0) return false;
        }

        return true;
    }

    public static int[] primeDivisors(int n) {

        List<Integer> divisors = new ArrayList<Integer>(n / 2);

        int div = 2;

        while (n != 1) {
            if (n % div == 0) {
                n /= div;

                divisors.add(div);
            }
            else
            {
                div++;
            }
        }

        return divisors.stream().mapToInt(i->i).toArray();
    }
}
