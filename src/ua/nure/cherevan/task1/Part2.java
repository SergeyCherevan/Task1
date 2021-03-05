package ua.nure.cherevan.task1;

public class Part2 {

    public static void main(String[] args) {

        String outStr = "";

        for (int i = args.length - 1; ; i--) {
            outStr += args[i];

            if (i == 0) break;

            outStr += " ";
        }

        System.out.println(outStr);
    }
}
