package a2;

import java.util.ArrayList;

public class LinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    /**
     * Remove the node at index i of the list.
     * Note that the first element is at index 0
     * If i is larger than the size of the list, throw an IndexOutOfBounds Exception
     *
     * ex: list: 1 -> 2 -> 3 -> 4
     *     i: 1
     *     list after removeAtIndex: 1 -> 3 -> 4
     *
     * @param i    - index of node to remove
     */
    public void removeAtIndex(int i) {
        if(i > this.size()) {
            throw new IndexOutOfBoundsException("Too long");
        }
        else {
            for(int j=0; j < this.size(); j++){
                if(i == j) {
                    int object = this.get(i);
                    this.remove(object);
                }
            }
        }

    }

    /**
     * Compute and return the average of all the numbers in the linked list rounded down to the nearest integer
     * @return an int that is the floor of the mean of the list.
     */
    public int mean() {
        if(this.head == null) {
            return 0;
        }
        else {
            int counter = 0;
            for(int j=0; j < this.size(); j++){
                counter += this.get(j);
            }
            double mean = counter / this.size();
            if(mean < 0) {
                return (int) Math.floor(mean) - 1;
            }
            else {
                return (int) Math.ceil(mean);
            }
        }
    }

    /**
     * Return true if this linked list is equal to the list argument, false otherwise.
     * Two lists are equal if they have the same size, and the same
     * elements in the same order.
     * ex:  list: 1 -> 4 -> 2
     *      list2: 1 -> 4 -> 2
     *      return: true
     *
     *      list: 1 -> 5
     *      list2: 2 -> 5
     *      return false;
     *
     * @return true if the lists have the same elements in the same order, false otherwise
     */
    public boolean isEqual(LinkedList list2) {
        int i = 0;
        boolean equal = false;
        if(this.isEmpty() || list2.isEmpty()) {
            equal = false;
        }
        if(this.isEmpty() && list2.isEmpty()) {
            equal = true;
        }
        if(this.size() == list2.size()){
            while(i < this.size()){
                if (this.get(i) == list2.get(i)) {
                    equal = true;
                    i += 1;
                }
                else {
                    equal = false;
                    break;
                }
            }
        }
        return equal;    }

    /**
     * Remove all the nodes at odd indices from the list. Remember that the first Node is at index 0
     *
     * ex: list: 1 -> 3 -> 4 -> 2 -> 8
     *     list after removeOdds: 1 -> 4 -> 8
     */
    public void removeOdds() {
        int[] removeTerm = new int[(int) Math.floor(this.size() / 2)];
        int counter = 0;
        for(int j=0; j < this.size(); j++){
            if(j % 2 == 1) {
                removeTerm[counter] = (this.get(j));
                counter ++;
            }
        }
        for(int i=0; i < removeTerm.length; i++) {
            int oddNumber = removeTerm[i];
            this.remove(oddNumber);
        }
    }

    /**
     * Return true if the list is symmetrical, false otherwise
     * ex: list: 1 -> 2 -> 3 -> 2 -> 1
     *     return: true
     *
     *     list: 1 -> 2 -> 3 -> 4 -> 5
     *     return: false
     *
     * @return true if the list is symmetrical, false otherwise
     */

    public boolean isSymmetrical() {
        boolean symmetry = false;
        if(this.isEmpty()) {
            symmetry = true;
        }
        else{
            int i = 0;
            int j = (this.size() - 1);
            if(this.size() % 2 != 0) {
                while(i != j) {
                    if(this.get(i) == this.get(j)) {
                        i += 1;
                        j -= 1;
                        symmetry = true;
                    } else {
                        symmetry = false;
                        break;
                    }
                }
            }
            else {
                while(i + 1 != j) {
                    if (this.get(i) == this.get(j)) {
                        i += 1;
                        j -= 1;
                        symmetry = true;
                    } else {
                        symmetry = false;
                        break;
                    }
                }
            }
        }
        return symmetry;
    }


    /**
     * Stretch the list so that each element in the list is represented factor times
     * If the factor is 0 the list should be cleared (have 0 nodes)
     * ex: list: 1 -> 2 -> 3
     *     factor: 3
     *     list after multiply: 1 -> 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 3
     *
     * @param factor the amount to multiply the number of occurrences of each element by
     */
    public void multiply(int factor) {
        if(factor == 0) {
            this.clear();
        }
        if(factor == 1) {
            int i = 0;
        }
        else {
            ArrayList newLinkedList = new ArrayList<>();
            int i = 0;
            while(i < this.size()) {
                for(int l=0; l < factor; l++) {
                    newLinkedList.add(this.get(i));
                }
                i += 1;
            }
            this.clear();
            for(int m=0; m < newLinkedList.size(); m++) {
                this.add((Integer) newLinkedList.get(m));
            }
        }
    }

    /**
     * Reverse the list
     *
     * ex list:  10 -> 9 -> 8 -> 7
     *    list after reverse: 7 -> 8 -> 9 -> 10
     *
     */
    public void reverse() {
        ArrayList original = new ArrayList<>();
        if(this.isEmpty()) {
            this.clear();
        }
        else {
            int i = 0;
            while(i < this.size()) {
                original.add(this.get(i));
                i += 1;
            }
            i = 0;
            for(int j=(original.size() - 1); !(j == -1); j--) {
                this.set(i, (Integer) original.get(j));
                i += 1;
            }
        }
    }

    /**
     * Given a sorted linked list, remove the duplicate values from the list
     * ex: list: 5 -> 6 -> 7 -> 7 -> 7 -> 8 -> 8 -> 9
     *     list after removeRepeats: 5 -> 6 -> 7 -> 8 -> 9
     *
     */
    public void removeRepeats() {
        boolean noDupli = true;
        for(int i=0; i < (this.size()); i++) {
            int l = i;
            while(l < this.size()) {
                if((this.get(i) == this.get(l)) && (i != l)) {
                    noDupli = false;
                }
                else {
                    noDupli = true;
                    l += 1;
                }
                if(!noDupli) {
                    this.removeAtIndex(l);
                }
            }
        }
    }


    /**
     * Return true if the list contains a cycle, false otherwise
     * ex: list: 1 -> 2 -> 3 - > 4 --       (4 points to 2)
     *                ^              |
     *                |              |
     *                ---------------
     *      return: true
     *
     *      list: 1 -> 2 -> 3 -> 4
     *      return: false
     *
     * @return true if the list contains a cycle, false otherwise
     */
    public boolean containsCycle() {
        boolean cycle = false;
        int i = 0;
        Node data = this.head;
        while(i < 100) {
            if (data.hasNext()) {
                cycle = true;
                data = data.getNext();
                i += 1;
            }
            else {
                cycle = false;
                break;
            }
        }
        return cycle;    }

    /**
     * Merge the given linked list into the current list. The 2 lists will always be
     * either the same size, or the current list will be longer than list2.
     * The examples below show how to handle each case.
     *
     * Note: Do NOT create and return a new list, merge the second list into the first one.
     *
     * ex: list: 1 -> 2 -> 3
     *     list2: 4 -> 5 -> 6
     *     return: 1 -> 4 -> 2 -> 5 -> 3 -> 6
     *
     *     list: 1 -> 2 -> 3 -> 4
     *     list2: 5 -> 6
     *     return 1 -> 5 -> 2 -> 6 -> 3 -> 4
     *
     * @param list2
     */
    public void merge(LinkedList list2) {
        ArrayList firstList = new ArrayList<>();
        ArrayList secondList = new ArrayList<>();
        for(int k=0; k < this.size(); k++) {
            firstList.add(this.get(k));
        }
        for(int j=0; j < list2.size(); j++) {
            secondList.add(list2.get(j));
        }
        if(this.isEmpty() || list2.isEmpty()) {
            if(this.isEmpty()) {
                for(int x=0; x < list2.size(); x++) {
                    this.add((Integer) secondList.get(x));
                }
            }
        }
        else if(firstList.size() > secondList.size()) {
            this.clear();
            while(!secondList.isEmpty()) {
                this.add((Integer) firstList.get(0));
                firstList.remove(0);
                this.add((Integer) secondList.get(0));
                secondList.remove(0);
            }
            while(!firstList.isEmpty()) {
                this.add((Integer) firstList.get(0));
                firstList.remove(0);
            }
        }
        else if(firstList.size() < secondList.size()) {
            this.clear();
            while(!firstList.isEmpty()) {
                this.add((Integer) firstList.get(0));
                firstList.remove(0);
                this.add((Integer) secondList.get(0));
                secondList.remove(0);
            }
            while(!secondList.isEmpty()) {
                this.add((Integer) secondList.get(0));
                secondList.remove(0);
            }
        }
        else {
            this.clear();
            int i = 0;
            while(i < firstList.size()) {
                this.add((Integer) firstList.get(i));
                this.add((Integer) secondList.get(i));
                i += 1;
            }
        }
    }


    /* Implementation given to you. Do not modify below this. */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
    Returns true if the list contains a node whose value matches the element parameter, false otherwise
     */
    public boolean contains(int element) {
        Node current = head;
        while(current != null) {
            if(current.getValue() == element) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /*
    converts the linked list into an array
     */
    public int[] toArray() {
        int[] arr =  new int[size()];
        Node current = head;
        int i = 0;
        if(isEmpty()) {
            return arr;
        }
        while(current != null){
            arr[i] = current.getValue();
            current = current.getNext();
            i++;
        }
        return arr;
    }

    /*
    adds a node to the end of the list
     */
    public void add(int element) {
        Node newNode = new NodeImpl(element, null);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }

    }

    /*
    removes the element from the list
     */
    public boolean remove(int element) {
        Node current = head;
        if(isEmpty()) {
            return false;
        }
        if(current.getValue() == element){
            head = head.getNext();
            size--;
            return true;
        }
        while(current.getNext().getValue() != element) {
            current = current.getNext();
            if(current == null) {
                return false;
            }
        }
        if(current.getNext().getNext() == null) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    /*
        returns the value at the index parameter.
     */
    public int get(int index) {
        validIndex(index);
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    /*
    sets the value of the node at index to the element
     */
    public int set(int index, int element) {
        validIndex(index);
        Node current = head;
        int prevValue = 1;
        int i = 0;
        if(index == 0) {
            prevValue = head.getValue();
            head.setValue(element);
        } else {
            while(current != null) {
                if(i == index) {
                    prevValue = current.getValue();
                    current.setValue(element);
                    return prevValue;
                }
                current = current.getNext();
                i++;
            }
        }

        return prevValue;
    }

    /*
    adds a node at the given index with the given element as its value
     */
    public void add(int index, int element) {
        if(index > size) {
            validIndex(index);
        }
        Node current = head;
        int i = 0;
        if(index == 0) {
            if(isEmpty()) {
                add(element);
                return;
            } else {
                Node newNode = new NodeImpl(element, head);
                head = newNode;
                size++;
                return;
            }

        }  else if(index == size) {
            add(element);
            return;
        }
        while(current != null) {
            if(i == (index - 1)) {
                Node temp = current.getNext();
                Node newNode = new NodeImpl(element, temp);
                current.setNext(newNode);
                size++;
                return;
            } else {
                current = current.getNext();
                i++;
            }
        }
    }

    /*
    returns the index of the given element
     */
    public int indexOf(int element) {
        Node current = head;
        int index = 0;
        while(current != null) {
            if(current.getValue() == element) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    /*
    returns the last index of the element
     */
    public int lastIndexOf(int element) {
        Node current = head;
        int index = -1;
        int i = 0;
        while(current != null) {
            if(current.getValue() == element) {
                index = i;
            }
            i++;
            current = current.getNext();
        }
        return index;
    }

    public void validIndex(int i) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public Node getHead() {
        return head;
    }

    /* prints out list */
    public String toString() {
        String list = "";
        Node current = head;
        while(current != null) {
            if(current.getNext() == null)
                list+= current.getValue();
            else
                list += current.getValue() + " -> ";
            current = current.getNext();
        }
        return list;
    }

}