package ua.nure.cherevan.task1;

import java.util.ArrayList;
import java.util.List;

public class Part9 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);


        int[] primeNumbers = getPrimeNumbersLessN(n);

        String[] strArr = new String[primeNumbers.length];

        for (int i = 0; i < primeNumbers.length; i++)
        {
            strArr[i] = primeNumbers[i] + "";
        }

        System.out.println(String.join(" ", strArr));
    }



    public static int[] getPrimeNumbersLessN(int n) {

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
