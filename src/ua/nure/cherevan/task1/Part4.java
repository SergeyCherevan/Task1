package ua.nure.cherevan.task1;

import java.util.LinkedList;
import java.util.List;

public class Part4 {

    public static void main(String[] args) {

        String argString = String.join(" ", args);

        List<String> numStrList = new LinkedList<String>();

        int sum = 0;

        for (int i = 0; i < argString.length(); i++) {

            char c = argString.charAt(i);

            if ('0' <= c && c <= '9') {
                sum += c - '0';

                numStrList.add("" + c);
            }
        }

        System.out.println("sum = " + String.join(" + ", numStrList) + " = " + sum);
    }
}