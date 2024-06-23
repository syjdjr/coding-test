package boj_0621_10828;

import java.util.*;
import java.io.*;

public class Main {
    public static StringTokenizer st ;
    public static List<Integer> stack = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();


    public static int size() {
        int size = 0;
        for (Integer i : stack) {
            size++;
        }
        return size;
    }

    public static void push(int x) {
        stack.add(x);
    }

    public static int pop() {
        int size = size();
        if (size != 0) {
            int result = stack.get(size - 1);
            stack.remove(size -1 );
            return result;
        }else{
            return -1;
        }
    }

    public static int empty() {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.get(size() -1 );
        }
    }

    public static void setCase(String token) {
        switch (token) {
            case "empty" -> {
                sb.append(empty());
                sb.append("\n");
            }
            case "size" -> {
                sb.append(size());
                sb.append("\n");
            }
            case "top" -> {
                sb.append(top());
                sb.append("\n");
            }
            case "pop" -> {
                sb.append(pop());
                sb.append("\n");
            }
            default -> {
                int x = Integer.parseInt(st.nextToken());
                push(x);
            }
        }
    }

    public static void main(String[] args) throws IOException,NullPointerException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            setCase(st.nextToken());
        }
        System.out.println(sb);
    }
}