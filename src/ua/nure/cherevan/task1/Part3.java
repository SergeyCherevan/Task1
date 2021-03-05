package ua.nure.cherevan.task1;

public class Part3 {

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int gcd = Gcd(a, b);

        System.out.println("Gcd(" + a + ", " + b + ") = " + gcd);

        System.out.println("Gcm(" + a + ", " + b + ") = " + (a * b / gcd) );
    }

    public static int Gcd(int a, int b) {
        while (true) {
            int r = a % b;

            if (r == 0) return b;

            int t = b;
            b = r;
            a = t;
        }
    }
}
