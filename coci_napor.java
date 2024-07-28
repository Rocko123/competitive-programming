import java.util.*;
import java.io.*;
public class coci_napor {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = readLine();
            boolean start = false, zero = false;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (Character.isDigit(s.charAt(j)) && start) {
                    sb.append(s.charAt(j));
                } else if (Character.isDigit(s.charAt(j))) {
                    if (s.charAt(j) == '0') {
                        zero = true;
                    } else {
                        start = true; zero = false;
                        sb.append(s.charAt(j));
                    }
                }
                if (j == s.length()-1 || !Character.isDigit(s.charAt(j))) {
                    if (start) {
                        String num = sb.toString();
                        ans.add(num);
                        sb = new StringBuilder(); 
                    }else if (zero) {
                        ans.add("0");
                    }
                    start = false; zero = false;
                }
            }
        }
        Collections.sort(ans, new comparator());
        for (String i: ans) System.out.println(i);
    }
    static class comparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return Integer.compare(s1.length(), s2.length());
            }
        }
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }  
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}