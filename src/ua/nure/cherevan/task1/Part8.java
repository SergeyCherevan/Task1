package ua.nure.cherevan.task1;

public class Part8 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        int[][] pascalPyramid = pascal(n);

        printPyramid(pascalPyramid);
    }

    public static int[][] pascal(int n) {

        int arr[][] = new int[n][];

        for (int i = 0; i < n; ++i)
        {
            arr[i] = new int[i + 1];

            arr[i][0] = arr[i][i] = 1;

            for (int j = 1; j < i; ++j)
            {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }

        return arr;
    }

    public static void printPyramid(int[][] arr) {

        for (int i = 0; i < arr.length; ++i)
        {
            String strArr[] = new String[arr[i].length];

            int j = 0;

            for (; j < arr[i].length; ++j)
            {
                strArr[j] = String.valueOf(arr[i][j]);
            }

            for (; j < arr.length; ++j)
            {
                System.out.print(" ");
            }

            System.out.println(String.join(" ", strArr));
        }
    }
}
