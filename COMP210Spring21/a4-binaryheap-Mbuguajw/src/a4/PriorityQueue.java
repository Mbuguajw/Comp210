package a4;


import java.util.ArrayList;

public class PriorityQueue implements Queue {

  private Prioritized[] heap;
  private int size;
  private static final int arraySize = 10000; // Everything in the array will initially
  // be null. This is ok! Just build out
  // from array[1]. Don't change the value of this variable.

  public PriorityQueue() {
    heap = new Prioritized[arraySize];
    size = 0;
    heap[0] = new Prioritized(Double.NaN, Double.NaN); //0th will be unused for simplicity
    //of child/parent computations
  }

  // fill in the methods below based on the descriptions in the Queue interface. Do NOT change the interface or any
  // of the method signatures
  @Override
  public void enqueue(double value, double priority) {
    Prioritized newPatient = new Prioritized(value, priority);
    ArrayList<Prioritized> tempHeap = new ArrayList();
    int i = 1;
    while (i < heap.length && heap[i] != null) {
      tempHeap.add(heap[i]);
      i++;
    }
    tempHeap.add(newPatient);
    int currentidx = tempHeap.size() - 1;
    while (currentidx > 0) {
      int parentidx = (currentidx - 1) / 2;
      if (tempHeap.get(currentidx).getPriority() > (tempHeap.get(parentidx).getPriority())) {
        Prioritized newParent = tempHeap.get(currentidx);
        Prioritized newChild = tempHeap.get(parentidx);
        tempHeap.set(currentidx, newChild);
        tempHeap.set(parentidx, newParent);
        currentidx = parentidx;
      } else {
        break;
      }
    }
    for (int j = 1; j < tempHeap.size() + 1; j++) {
      heap[j] = tempHeap.get(j - 1);
    }
    size += 1;
  }

  @Override
  public double dequeue() {
    ArrayList<Prioritized> tempHeap = new ArrayList();
    int i = 1;
    while (i < heap.length) {
      tempHeap.add(heap[i]);
      heap[i] = null;
      i++;
    }
    if (size == 0) {
      throw new UnsupportedOperationException();
    }
    int idx = find_max();
    double kickedOutValue = front();
    tempHeap.remove(idx);
    for (int j = 1; j < tempHeap.size() + 1; j++) {
      heap[j] = tempHeap.get(j - 1);
    }
    size -= 1;
    this.sort();
    return kickedOutValue;
  }

  private int find_max() {
    ArrayList<Prioritized> tempHeap = new ArrayList();
    int j = 1;
    while (j < heap.length && heap[j] != null) {
      tempHeap.add(heap[j]);
      j++;
    }
    if (tempHeap.size() == 0) {
      throw new UnsupportedOperationException();
    }
    Prioritized max = tempHeap.get(0);
    int maxIndex = 0;

    for (int i = 1; i < tempHeap.size(); i++) {
      if (tempHeap.get(i).getPriority() > (max.getPriority())) {
        max = tempHeap.get(i);
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  @Override
  public double front() {
    ArrayList<Prioritized> tempHeap = new ArrayList();
    int j = 1;
    while (j < heap.length && heap[j] != null) {
      tempHeap.add(heap[j]);
      j++;
    }
    if (tempHeap.size() == 0) {
      throw new UnsupportedOperationException();
    }
    Prioritized max = tempHeap.get(0);

    for (int i = 1; i < size; i++) {
      if (tempHeap.get(i).getPriority() > (max.getPriority())) {
        max = heap[i];
      }
    }
    return max.getValue();
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean empty() {
    boolean queueLoaded = true;
    int i = 1;
    while (i < heap.length && queueLoaded) {
      if (heap[i] != null) {
        queueLoaded = false;
      }
      i++;
    }
    return queueLoaded;
  }

  @Override
  public double[] sort() {
    for (int i = 1; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        if(i == size - 1) {
          break;
        }
        if (heap[i].getPriority() < heap[j].getPriority()) {
          Prioritized greater = heap[j];
          Prioritized smaller = heap[i];
          heap[i] = greater;
          heap[j] = smaller;
        }
      }
    }
    double[] valueArray = new double[10000];
    for (int k = 1; k < heap.length; k++) {
      valueArray[k] = heap[k].getValue();
    }
    return valueArray;
  }

  @Override
  public void build(Prioritized[] elements) {
    ArrayList<Prioritized> transfer = new ArrayList<>();
    for (Prioritized element : elements) {
      transfer.add(element);
      size++;
    }
    for(int i = 1; i < transfer.size() + 1; i++) {
      heap[i] = transfer.get(i - 1);
    }
  }


  // do not change
  public Prioritized[] getHeap() {
    return heap;
  }
}
