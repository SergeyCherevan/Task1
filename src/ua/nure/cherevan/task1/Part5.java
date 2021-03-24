package ua.nure.cherevan.task1;

import java.util.ArrayList;
import java.util.List;

public class Part5 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int[] primeNumbers = getPrimeNumbers(n);

        String outStr = "";
        for (int i = 0; i < primeNumbers.length; i++) {
            outStr += primeNumbers[i];

            if (i == primeNumbers.length - 1) break;

            outStr += " ";
        }

        System.out.println(outStr);
    }

    public static boolean isPrime(int n) {

        for (int i = 2; i < n/2; i++){
            if (n % i == 0) return false;
        }

        return true;
    }

    public static int[] getPrimeNumbers(int n) {
        boolean[] isNumbersPrime = new boolean[n];

        for (int i = 2; i <= n; i++){
            isNumbersPrime[i - 1] = true;
        }

        for (int div = 2; div < n/2; div++) {
            for (int num = div*div; num  <= n; num += div) {
                isNumbersPrime[num - 1] = false;
            }
        }

        List<Integer> primeNumbers = new ArrayList<Integer>(n/2 + 1);

        for (int i = 1; i <= n; i++){
            if(isNumbersPrime[i - 1] == true) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers.stream().mapToInt(i->i).toArray();
    }
}
