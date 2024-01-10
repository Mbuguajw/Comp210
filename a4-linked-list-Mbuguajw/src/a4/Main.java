package a4;


public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        LinkedList lists = new LinkedList<Integer>();
        lists.add(5);
        lists.add(6);
        lists.add(7);
        lists.add(8);
        lists.add(9);
        lists.add(19);
        lists.reverse();
        System.out.println(lists);
        list.reverse();
        System.out.println(list);
    }
}
