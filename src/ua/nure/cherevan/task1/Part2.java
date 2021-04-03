package ua.nure.cherevan.task1;

public class Part2 {

    public static void main(String[] args) {

        StringBuffer outStr = new StringBuffer("");

        for (int i = args.length - 1; ; i--) {
            outStr.append(args[i]);

            if (i == 0) break;

            outStr.append(" ");
        }

        System.out.println(outStr);
    }
}
