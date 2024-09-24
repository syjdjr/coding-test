package boj_0924_11478;

import java.io.*;
import java.util.*;

public class Main {
    private static String str;
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }

    private static void solve() {
        for (int i = 0; i < str.length(); i++) {            //시작점
            for (int j = 1; j <= str.length(); j++) {        //길이
                if (i + j > str.length())
                    break;

                set.add(str.substring(i, i + j));
            }
        }

        System.out.println(set.size());
    }
}
