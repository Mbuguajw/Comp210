package a2;


public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(-55);
        list.add(-40);
        list.add(-30);
        list.add(-20);
        list.add(-10);
        System.out.println(list.toString());
        System.out.println(list.mean());

    }
}
