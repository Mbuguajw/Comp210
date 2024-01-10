package a5;


public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new EmptyBST<Integer>();
    bst = bst.insert(80);
    bst = bst.insert(72);
    bst = bst.insert(75);
    bst = bst.insert(111);
    bst = bst.insert(93);
    bst = bst.insert(9);
    bst = bst.insert(97);
    bst = bst.insert(94);
    bst = bst.insert(78);
    bst = bst.insert(140);
    bst = bst.insert(92);

    bst.printPreOrderTraversal();
    System.out.println("\n");
    bst.printPostOrderTraversal();
    System.out.println("\n");
    bst.printInOrderTraversal();
    System.out.println("\n");
    bst.printBreadthFirstTraversal();




  }

}
