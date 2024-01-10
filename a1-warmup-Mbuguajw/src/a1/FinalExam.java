package a1;

public class FinalExam {
    public static void main(String[] args) {
        String first = "Aaron";
        String last = null;
        printInitials(first, last);
    }

    public static void printInitials(String first, String last) {
        System.out.println("Your intials are " + first.charAt(0) + last.charAt(0));
    }
}
