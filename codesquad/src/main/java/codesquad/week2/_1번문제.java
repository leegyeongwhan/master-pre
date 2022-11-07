package codesquad.week2;

public class _1번문제 {
    public static void main(String[] args) {
        char[] arr = new char[26];
        int j = 0;
        for (int i = 'A'; i <= 'Z'; i++) {
            arr[j] = (char) i;
            j++;
        }
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }
}

