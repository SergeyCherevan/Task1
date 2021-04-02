package ua.nure.cherevan.task1;

import java.util.ArrayList;
import java.util.List;

public class Part7 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);


        int[] primeNumbers = get_N_PrimeNumbers(n);

        int maxSum = -1, countOfMaxSum = 0;

        for (int i = 0; i < primeNumbers.length; i++) {

            int sum = sumOfSymb(primeNumbers[i]);

            if (maxSum < sum)
            {
                maxSum = sum;

                countOfMaxSum = 1;
            }
            else if (maxSum == sum)
            {
                ++countOfMaxSum;
            }
        }

        System.out.println(maxSum + " " + countOfMaxSum);
    }



    public static int[] get_N_PrimeNumbers(int n) {

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



    public static int sumOfSymb(int n) {

        int sum = 0;

        for (int i = 1; i < n; i *= 10) {

            int d = n / i % 10;

            sum += d;
        }

        return sum;
    }
}
