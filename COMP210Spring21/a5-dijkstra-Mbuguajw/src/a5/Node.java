package a5;

public interface Node {

     /**
      * @return the name of the node
      */
     String getName();

     void setWeight(double _weight);

     double getWeight();

     void setValue(String value);

     Node getNext();

     void setNext(Node next);

     default boolean hasNext() {
          return (getNext() != null);
     }

}
