package hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MinBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO: overloaded constructor
    public MinBinHeapER(Prioritized<V, P>[] initialEntries ) {
        _heap = new ArrayList<>();
        for (Prioritized entry: initialEntries) {
            enqueue((V) entry.getValue(), (P) entry.getPriority());
        }
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        Prioritized newPatient = new Patient(value, priority);
        this._heap.add(newPatient);
        int currentidx = this.size() - 1;
        while (currentidx > 0) {
            int parentidx = (currentidx - 1) / 2;
            if (this._heap.get(currentidx).getPriority().compareTo(this._heap.get(parentidx).getPriority()) < 0) {
                Prioritized newParent = this._heap.get(currentidx);
                Prioritized newChild = this._heap.get(parentidx);
                this._heap.set(currentidx, newChild);
                this._heap.set(parentidx, newParent);
                currentidx = parentidx;
            }
            else {
                break;
            }
        }
    }

    // TODO: enqueue
    public void enqueue(V value) {
        Prioritized newPatient = new Patient(value);
        this._heap.add(newPatient);
        int currentidx = this.size() - 1;
        while (currentidx > 0) {
            int parentidx = ((currentidx - 1) / 2);
            if (this._heap.get(currentidx).getPriority().compareTo(this._heap.get(parentidx).getPriority()) < 0) {
                Prioritized newParent = this._heap.get(currentidx);
                Prioritized newChild = this._heap.get(parentidx);
                this._heap.set(currentidx, newChild);
                this._heap.set(parentidx, newParent);
                currentidx = parentidx;
            }
            else {
                break;
            }
        }
    }

    // TODO: dequeue
    @Override
    public V dequeue() {
        if (this._heap.isEmpty()) {
            return null;
        }
        Prioritized<V,P> root = this._heap.get(0);
        this._heap.set(0, _heap.get(_heap.size() - 1));
        this._heap.remove(this._heap.size() - 1);
        int i = 0;
        while(!this._heap.isEmpty()) {
            int lTree = 2 * i + 1;
            if (lTree >= this._heap.size()) {
                break;
            }
            else {
                int rTree = lTree + 1;
                if (rTree >= this._heap.size()) {
                    if (this._heap.get(i).getPriority().compareTo(this._heap.get(lTree).getPriority()) <= 0) {
                        break;
                    }
                    else {
                        Prioritized<V,P> temp = this._heap.get(lTree);
                        this._heap.set(lTree, this._heap.get(i));
                        this._heap.set(i, temp);
                        i = lTree;
                    }
                }
                else {
                    if (this._heap.get(i).getPriority().compareTo(this._heap.get(lTree).getPriority()) <= 0 && this._heap.get(i).getPriority().compareTo(this._heap.get(rTree).getPriority()) <= 0) {
                        break;
                    }
                    else {
                        int smallestLeaf = (this._heap.get(lTree).getPriority().compareTo(this._heap.get(rTree).getPriority()) <= 0 ? lTree : rTree);
                        Prioritized<V,P> temp = this._heap.get(smallestLeaf);
                        this._heap.set(smallestLeaf, this._heap.get(i));
                        this._heap.set(i, temp);
                        i = smallestLeaf;
                    }
                }
            }
        }
        return root.getValue();
    }

    // TODO: getMin
    @Override
    public V getMin() {
        if (this._heap.size() == 0) {
            return null;
        }
        return this._heap.get(0).getValue();
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }
}