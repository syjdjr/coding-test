package boj_0808_10799;

import java.io.*;
import java.util.*;

public class Main {
    private static int count;
    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        setting();
    }

    static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();

                if (st.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

