//I am the sole author of the work in this repository. Chatted about design with Madeline Carswell.

import structure5.*;
import java.text.DecimalFormat;

/**
 * An implementation of an iterator that goes through vectors of generic type.
 * Subsets of this Vector will be returned as the Iterator progresses
 */
 public class SubsetIterator<E> extends AbstractIterator<Vector<E>> {

   /**
    * vector of generic type
    */
   private Vector<E> vec;

   /**
    * long which stores the place of the iterator as it goes through and returns
    * subsets
    */
   private long subsetCounter;

   /**
    * SubsetIterator constructor, takes in a vector of generic type and calls
    * reset method which sets the subsetCounter variable to zero
    */
   public SubsetIterator(Vector<E> vector) {
     vec = vector;
     reset();
   }

   /**
    * Function to progress the counter to the next subset and return the next subset
    * @return newSub which is of Vector<E> type
    * @pre the subset that is being iterated over has a next subset
    * @post returns the next vector
    */
   public Vector<E> next() {
     Vector<E> newSub = get();
     subsetCounter++;
     return newSub;
   }

   /**
    * Function to determine whether a subset has another subset that follows it
    * @return boolean indicating whether subset has a next element
    * @pre called on a subsetIterator object
    * @post returns true if there is another subset and false if there is not
    */
   public boolean hasNext() {
     return (subsetCounter < (1L << vec.size()));
   }

   /**
    * Function to return the vector of generic type from subsetIterator object.
    * @return temp a vector of generic type
    * @pre called on a subsetIterator object
    * @post returns vector of generic type
    */
   public Vector<E> get() {
     //initialize new vector of generic type
     Vector<E> temp = new Vector<E>();
     //traverse through vector
    for (int i = 0; i < vec.size(); i++) {
      //if the bitwise of subsetCounter and the 1L << i is equal to 1L << i
      //add number to subset temp
      if ((subsetCounter & (1L << i)) == (1L << i)) {
        temp.add(vec.get(i));
      }
    }
     return temp;
   }

   /**
    * Function to reset the subsetIterator
    * @pre called on a subsetIterator object
    * @post subsetCounter is set to 0
    */
   public void reset() {
     subsetCounter = 0L;
   }

   /**
    * Function to test subsetIterator functionality by running it as a script
    */
   public static void main(String[] args) {
     //create new vector and add integers 0 - 7 to vec
    Vector<Integer> vec = new Vector<Integer>(8);
    for (int i = 0; i < 8; i++) {
      vec.add(i);
    }

    //create subset iterator object si and print every subset 
    SubsetIterator<Integer>  si = new SubsetIterator<Integer>(vec);
 		for (Vector<Integer> s : si) {
 			System.out.println(s);
 		}
   }
 }
