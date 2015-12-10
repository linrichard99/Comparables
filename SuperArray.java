/*
  Richard Lin
  APCS pd10
  hw45 -- Come Together
  2015-12-09
*/

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 *  Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;
    
    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;
    
    
    //~~~~~METHODS~~~~~
    //default constructor: initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }
    
    
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }
    
    
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }
    
    
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }
    
    
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }
    
    
    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
    	_lastPos++;
    	_size++;
    	_data[_lastPos]= newVal;
    }
    
    
    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
    	_lastPos++;
    	_size++;
    	for (int i = index; i <= _lastPos; i++){
	    Comparable temp = _data[i];
	    _data[i] = newVal;
	    newVal = temp;
    	}
    }
   
    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) { 
    	for (int i = index; i < _size; i++) {
	    _data[i] = _data[i+1];
    	}
    	_lastPos--;
    	_size--;
    }


    //return number of meaningful items in _data
    public int size() { 
    	return _size;
    }

    public int linSearch(Comparable val) {
	int index = 0;
	while (index < _size) {
	    if (_data[index].equals(val)) {
		return index;
	    }
	    index++;
	}
	return -1;
    }

    public boolean isSorted() {
	for (int i = 0; i < _lastPos; i++) {
	    if (_data[i].compareTo(_data[i+1]) == 1) {
		return false;
	    }
	    
	}
	return true;
    }
    
    //main method for testing
    public static void main( String[] args ){

	//Testing Binary
	System.out.println("BINARY TEST");
	
	SuperArray binaryTest = new SuperArray();
	System.out.println("Printing empty SuperArray binaryTest...");
	System.out.println(binaryTest);

	binaryTest.add(new Binary("101"));
	binaryTest.add(new Binary(4));
	binaryTest.add(new Binary(2));
	binaryTest.add(new Binary("111"));
	binaryTest.add(new Binary("110"));

	System.out.println("Printing populated SuperArray binaryTest...");
	System.out.println(binaryTest);
	  
	binaryTest.remove(3);
	System.out.println("Printing SuperArray binaryTest post-remove...");
	System.out.println(binaryTest);
	binaryTest.remove(3);
	System.out.println("Printing SuperArray binaryTest post-remove...");
	System.out.println(binaryTest);
	  
	binaryTest.add(3, new Binary(9));
	System.out.println("Printing SuperArray binaryTest post-insert...");
	System.out.println(binaryTest);
	binaryTest.add(2, new Binary("111"));
	System.out.println("Printing SuperArray binaryTest post-insert...");
	System.out.println(binaryTest);
	binaryTest.add(1, new Binary(10));
	System.out.println("Printing SuperArray binaryTest post-insert...");
	System.out.println(binaryTest);

	System.out.println("Printing SuperArray binaryTest linSearch...");
	System.out.println(binaryTest.linSearch(new Binary(9)));

	System.out.println("Printing SuperArray binaryTest isSorted...");
	System.out.println(binaryTest.isSorted());

	System.out.println();
	System.out.println();
	
	//Testing Hexadecimal
	System.out.println("HEXADECIMAL TEST");
	
	SuperArray hexadecimalTest = new SuperArray();
	System.out.println("Printing empty SuperArray hexadecimalTest...");
	System.out.println(hexadecimalTest);

	hexadecimalTest.add(new Hexadecimal(1));
	hexadecimalTest.add(new Hexadecimal("14F"));
	hexadecimalTest.add(new Hexadecimal(2800));
	hexadecimalTest.add(new Hexadecimal("D9"));
	hexadecimalTest.add(new Hexadecimal("E7"));

	System.out.println("Printing populated SuperArray hexadecimalTest...");
	System.out.println(hexadecimalTest);
	  
	hexadecimalTest.remove(3);
	System.out.println("Printing SuperArray hexadecimalTest post-remove...");
	System.out.println(hexadecimalTest);
	hexadecimalTest.remove(3);
	System.out.println("Printing SuperArray hexadecimalTest post-remove...");
	System.out.println(hexadecimalTest);
	  
	hexadecimalTest.add(1, new Hexadecimal(2));
	System.out.println("Printing SuperArray hexadecimalTest post-insert...");
	System.out.println(hexadecimalTest);
	hexadecimalTest.add(2, new Hexadecimal("F8"));
	System.out.println("Printing SuperArray hexadecimalTest post-insert...");
	System.out.println(hexadecimalTest);
	hexadecimalTest.add(3, new Hexadecimal(318));
	System.out.println("Printing SuperArray hexadecimalTest post-insert...");
	System.out.println(hexadecimalTest);

	System.out.println("Printing SuperArray hexadecimalTest linSearch...");
	System.out.println(hexadecimalTest.linSearch(new Hexadecimal("E9")));

	System.out.println("Printing SuperArray hexadecimalTest isSorted...");
	System.out.println(hexadecimalTest.isSorted());

	System.out.println();
	System.out.println();

	//Testing Rational
	System.out.println("RATIONAL TEST");
	
	SuperArray rationalTest = new SuperArray();
	System.out.println("Printing empty SuperArray rationalTest...");
	System.out.println(rationalTest);

	rationalTest.add(new Rational(1,2));
	rationalTest.add(new Rational(2,7));
	rationalTest.add(new Rational(6,5));
	rationalTest.add(new Rational(8,7));
	rationalTest.add(new Rational(22,1));

	System.out.println("Printing populated SuperArray rationalTest...");
	System.out.println(rationalTest);
	  
	rationalTest.remove(3);
	System.out.println("Printing SuperArray rationalTest post-remove...");
	System.out.println(rationalTest);
	rationalTest.remove(3);
	System.out.println("Printing SuperArray rationalTest post-remove...");
	System.out.println(rationalTest);
	  
	rationalTest.add(1, new Rational());
	System.out.println("Printing SuperArray rationalTest post-insert...");
	System.out.println(rationalTest);
	rationalTest.add(2, new Rational(19,17));
	System.out.println("Printing SuperArray rationalTest post-insert...");
	System.out.println(rationalTest);
	rationalTest.add(3, new Rational(21,25));
	System.out.println("Printing SuperArray rationalTest post-insert...");
	System.out.println(rationalTest);

	System.out.println("Printing SuperArray rationalTest linSearch...");
	System.out.println(rationalTest.linSearch(new Rational(4,14)));

	System.out.println("Printing SuperArray rationalTest isSorted...");
	System.out.println(rationalTest.isSorted());

	/*============================================
	  SuperArray curtis = new SuperArray();
	  System.out.println("Printing empty SuperArray curtis...");
	  System.out.println(curtis);
	
	  for( int i = 0; i < curtis._data.length; i++ ) {
	  curtis.set(i,i*2);
	  curtis._size++; //necessary bc no add() method yet
	  }

	  System.out.println("Printing populated SuperArray curtis...");
	  System.out.println(curtis);

	  System.out.println("testing get()...");
	  for( int i = 0; i < curtis._size; i++ ) {
	  System.out.print( "item at index" + i + ":\t" );
	  System.out.println( curtis.get(i) );
	  }
	
	  System.out.println("Expanded SuperArray curtis:");
	  curtis.expand();
	  System.out.println(curtis);


	
	  SuperArray mayfield = new SuperArray();
	  System.out.println("Printing empty SuperArray mayfield...");
	  System.out.println(mayfield);

	  mayfield.add(5);
	  mayfield.add(4);
	  mayfield.add(3);
	  mayfield.add(2);
	  mayfield.add(1);

	  System.out.println("Printing populated SuperArray mayfield...");
	  System.out.println(mayfield);
	  
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  
	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);


	

	  **ListInt currently not used**

	  System.out.println("ListInt stuffz");
	  ListInt tacos = new SuperArray();
	  System.out.println("Printing empty SuperArray mayfield tacos...");
	  System.out.println(tacos);

	  tacos.add(5);
	  tacos.add(4);
	  tacos.add(3);
	  tacos.add(2);
	  tacos.add(1);

	  System.out.println("Printing populated SuperArray tacos...");
	  System.out.println(tacos);

	  tacos.remove(0);
	  System.out.println("Printing SuperArray tacos post-remove...");
	  System.out.println(tacos);
	  tacos.remove(2);
	  System.out.println("Printing SuperArray tacos post-remove...");
	  System.out.println(tacos);

	  tacos.add(3,99);
	  System.out.println("Printing SuperArray tacos post-insert...");
	  System.out.println(tacos);
	  tacos.add(2,88);
	  System.out.println("Printing SuperArray tacos post-insert...");
	  System.out.println(tacos);
	  tacos.add(1,77);
	  System.out.println("Printing SuperArray tacos post-insert...");
	  System.out.println(tacos);
	  ============================================*/
	      
	//*****INSERT ANY ADDITIONAL TEST CALLS HERE*****

    }//end main
		
}//end class
