package ua.nure.cherevan.task1;

public class Part1 {

    public static void main(String[] args) {

        int sum = 0;
        for (String str : args) {
            sum += Integer.parseInt(str);
        }

        System.out.println("sum = " + String.join(" + ", args) + " = " + sum);
    }
}