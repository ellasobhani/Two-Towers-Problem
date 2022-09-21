//I am the sole author of the work in this repository. Chatted about design with Madeline Carswell.
import structure5.*;

/**
 * An implementation of TwoTowers class to solve the Two Towers problem
 */
public class TwoTowers {

  /**
   * Function to calculate the sum of all the heights of elements in a subset.
   * @param n is an integer
   * @return h is a double representing the sum of the heights in a subset
   * @pre argument is a nonzero integer
   * @post returns a double
   */
  public static Double calculateH(int n) {
    Double h = 0.0;
    //add square root of each element in loop to h
    for (int i = 1; i < n + 1; i++) {
      h += Math.sqrt(i);
    }
    return h;
  }

  /**
   * Function to convert vector representing subset to printable version
   * @param vec is a vector of doubles
   * @return subsetString is a string storing the values in stored in vec
   * @pre argument is a vector of doubles
   * @post returns a string
   */
  public static String subsetToString(Vector<Double> vec) {
    String subsetString = "";
    for (int i = 0; i < vec.size(); i++) {
      if (i == vec.size() - 1) {
        subsetString += Math.round(Math.pow(vec.get(i), 2));
      } else {
        subsetString += Math.round(Math.pow(vec.get(i), 2)) + ", ";
      }
    }
    return "[" + subsetString + "]";
  }

  /**
   * Function to populate a vector with doubles (representing square roots of
   * elements 1 through n) given an integer n
   * @param n is an integer
   * @return vec a vector of doubles
   * @pre n is a nonzero int
   * @post returns a vector of doubles
   */
  public static Vector<Double> populateVec(int n) {
    Vector<Double> vec = new Vector<Double>();
    for (int i = 1; i < n + 1; i++) {
      vec.add(Math.sqrt(i));
    }
    return vec;
  }

  /**
   * Function to calculate the sum of all elements in a subset.
   * @param vec is a vector of doubles
   * @return sum is a double representing the sum of the elements in vec
   * @pre vec is a vector of doubles
   * @post returns a double
   */
  public static Double sumOfSubset(Vector<Double> vec) {
    Double sum = 0.0;
    for (Double element: vec) {
      sum += element;
    }
    return sum;
  }

  /**
   * Function to solve the two towers problem by running as script
   */
  public static void main(String[] args) {
    //pull value of n from command line and store it in double n
    int n = Integer.valueOf(args[0]);
    //create TwoTowers object
    TwoTowers twoTow = new TwoTowers();
    //populate vector vec with doubles 1 through n
    Vector<Double> vec = twoTow.populateVec(n);
    //store the sum of all the heights of each block in var h
    Double h = twoTow.calculateH(n);
    //create subsetIterator object
    SubsetIterator<Double> subsetIterator = new SubsetIterator<Double>(vec);

    //create vectors of doubles for best and second best subsets
    //create doubles for best and second best sums
    Vector<Double> bestSubset = new Vector<Double>();
    Double bestSum = 0.0;

    Vector<Double> secondSubset = new Vector<Double>();
    Double secondSum = 0.0;

    //iterator through the subset iterator
    for (Vector<Double> subset: subsetIterator) {
      //for current subset in loop, calculate the sum of the heights in that subset and store in var
      Double currentHeightSum = twoTow.sumOfSubset(subset);
      //if the currentHeight sum is less than height of all blocks divided by 2
      //and the currentHeightSum is greater than the current best sum, update vars initialized above
      if ((currentHeightSum < h / 2) && (currentHeightSum > bestSum)) {
        secondSum = bestSum;
        secondSubset = bestSubset;
        bestSubset = subset;
        bestSum = currentHeightSum;
        //if currentHeightSum is between current bestSum and current secondSum
        //update secondSubset and secondSum
      } else if ((currentHeightSum < h / 2) && (currentHeightSum > secondSum)) {
        secondSubset = subset;
        secondSum = currentHeightSum;
      }
    }

    //call subsetToString method so bestSubset and secondSubset are printable
    String bestSubsetString = twoTow.subsetToString(bestSubset);
    String secondSubsetString = twoTow.subsetToString(secondSubset);

    System.out.println(n);
    System.out.println("Half height (h/2) is: " + h / 2);
    System.out.println("The best subset is: " + bestSubsetString + " = " + bestSum);
    System.out.println("The second best subset is: " + secondSubsetString + " = " + secondSum);

  }

}
