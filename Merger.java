/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;


    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int end1    // index past end of list1
      ) {
          ArrayList<String> combinedList = usersData;
          System.out.println(combinedList.isEmpty());
          int index0 = start0;
          int index1 = start1;
          int indexCombined = start0;
          while (index0 < start1 && index1 < end1) { //while both lists have elements:
              //if the current element from list 0 is smaller than that from list 1:
              if (usersData.get(index0).compareTo(usersData.get(index1)) <= 0) {
                  //"deal" current element of list 0
                  System.out.println("index0 = " + index0);
                  System.out.println("list size = " + combinedList.size());
                  combinedList.set(indexCombined, usersData.get(index0));
                  index0++;
                  indexCombined++;
              } else {
                  //"deal" current element of list 1
                  System.out.println("index1 = " + index1);
                  System.out.println("list size = " + combinedList.size());
                  combinedList.set(indexCombined, usersData.get(index1));
                  index1++;
                  indexCombined++;
              }
          }
          if (index0 >= start1) {
              for (; index1 < end1; index1++, indexCombined++) {
                  combinedList.set(indexCombined, usersData.get(index1));
              }
          } else if (index1 >= end1){
              for (; index0 < start1; index0++, indexCombined++) {
                  combinedList.set(indexCombined, usersData.get(index0));
              }
          } else {}
        usersData = combinedList;
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) {
                System.out.println( "trouble between position " + i
                                  + ", which holds " + usersData.get(i)
                                  + ", and position " + (i +1)
                                  + ", which holds " + usersData.get(i +1)
                                  );
                return false;
            }
        return true;
    }
}
