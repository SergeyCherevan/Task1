package ua.nure.cherevan.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;

public class Part7 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);


        int[] primeNumbers = getPrimeNumbers1stToNth(n);

        int maxSum = -1, countOfMaxSum = 0;

        for (int i = 0; i < primeNumbers.length; i++)
        {
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



    public static int[] getPrimeNumbers1stToNth(int Nth) {

        /* Пусть n - размеры решета Эратосфена, Nth - количество необходимых простых чисел.
         * Тогда, из теоремы распределения простых чисел:
         * Nth == n / Math.log(n)
         *
         * Наша задача - решить данное уравнение для n
         * Для этого используем метод Ньютона:
         * f(n) = n / Math.log(n) - Nth    <-    функция, возвращающая 0, при нахождении верного решения уравнения
         * f'(n) = ( Math.log(n) - 1 ) / ( Math.log(n) * Math.log(n) )    <-    производная функции f(n)
         *  */

        int n = Nth < 4 ? 6 :               /* Если Nth < 4, то формула распределения простых чисел неприменима. */
                (int)(
                        newton(
                                x -> x / Math.log(x) - Nth,                                  /* f(n) */
                                x -> ( Math.log(x) - 1 ) / ( Math.log(x) * Math.log(x) ),    /* f'(n) */
                                25                                                        /* начальное значение 25 */
                              )             /* Вычисляем решение уравнения методом Ньютона */
                        * 1.05              /* Докидываем к полученному результату 5% на
                                             * случай отрицательных отклонений */
                     );

        boolean[] isNumbersPrime = new boolean[n];

        for (int i = 2; i <= n; i++)
        {
            isNumbersPrime[i - 1] = true;
        }

        for (int div = 2; div < n/2; div++)
        {
            for (int num = div*div; num  <= n; num += div)
            {
                isNumbersPrime[num - 1] = false;
            }
        }

        List<Integer> primeNumbers = new ArrayList<Integer>(n/2 + 1);

        for (int i = 1, count = 0; i <= n; i++)
        {
            if (isNumbersPrime[i - 1] == true)
            {
                primeNumbers.add(i);

                count++;
            }

            if (count == Nth) break;
        }

        return primeNumbers.stream().mapToInt(i->i).toArray();
    }




    public static double newton(DoubleFunction<Double> F, DoubleFunction<Double> F_, double x)
    {
        int i = 0;

        while (Math.abs(F.apply(x) / F_.apply(x)) > 0.001)
        {
            x -= F.apply(x) / F_.apply(x);
        }


        return x;
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
