/*
  Team Squafz -- Richard Lin, Nielzz Graham
  APCS1 pd10
  hw42 -- Array of Titanium
  2015-12-04
*/

//This is the ListInt interface. It is used currently for SuperArray.java
//It is to give additional int list functionality to classes. 
public interface ListInt {
    void add(int newVal); //Appends at end of list (right side)
    void add(int index, int newVal); //Inserts at index specified
    void remove(int index); //Removes at index specified and left-justified
    int size(); //Returns _size
    int get(int index); //Returns the value at the specified index
    int set(int index, int newVal); //Sets value at the specified index
}
