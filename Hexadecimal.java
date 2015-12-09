//Team Noodle- Sunghex Kim, Richard Lin
//APCS1 pd10
//HW43 -- This or That or Fourteen Other Things
//2015-12-08

public class Hexadecimal {

    private final static String HEXDIGITS = "0123456789ABCDEF";   
    private int _decNum;
    private String _hexNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
        _decNum = 0;
	_hexNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	if( n >= 0 ) {
	    _decNum = n;
	    _hexNum = decToHex( n );
	}
    }

    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexadecimal number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
    	_hexNum = s;
    	_decNum = hexToDec( s );
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() {
	return _hexNum;
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to hexadecimal
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(2) -> "2"
      decToHex(3) -> "3"
      decToHex(14) -> "E"
      =====================================*/
    public static String decToHex( int n ) {
	String btemp = ""; // a var for nonstatic _hexNum
	int holder = n;
	while( n > 0 ) {
	    btemp = HEXDIGITS.substring( n % 16 , (n % 16) + 1 ) + btemp;
	    n = n / 16;
	}
	if( holder > 0 ) {
	    return btemp;
	}
	else if( holder == 0) {
	    return "0";
	}
	else {
	    return "Input has to be greater than or equal to 0.";
	}	
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexadecimal, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(2) -> "2"
      decToHexR(3) -> "3"
      decToHexR(14) -> "E"
      =====================================*/
    public static String decToHexR( int n ) { 
	String retVal = "";
	if( n == 0 ) {
	    return "0";
	}
	else if( n > 0 ) {
	    retVal = decToHexR( n / 16 ) + HEXDIGITS.substring( n % 16, (n % 16) + 1 );
	    return retVal.substring(1,retVal.length());
	}
	else {
	    return "Input has to be greater than or equal to 0.";
	}
	
    }
    
    /*=====================================
      String hexToDec(String) -- converts base-10 input to hexadecimal
      pre:  s represents non-negative hexadecimalimal number
      post: returns decimal equivalent as int
      eg  
      hexToDec("0") -> 0
      hexToDec("1") -> 1
      hexToDec("2") -> 2
      hexToDec("3") -> 3
      hexToDec("E") -> 14
      =====================================*/
    public static int hexToDec( String s ) {
	int dtemp = 0;
	for( int i = 0; i < s.length(); i++ ) {
	    dtemp += HEXDIGITS.indexOf(s.substring(i, i + 1));
	}
	return dtemp;
    }


    /*=====================================
      String hexToDecR(String) -- converts base-10 input to hexadecimal, recursively
      pre:  s represents non-negative hexadecimal number
      post: returns decimal equivalent as int
      eg  
      hexToDecR("0") -> 0
      hexToDecR("1") -> 1
      hexToDecR("2") -> 2
      hexToDecR("3") -> 3
      hexToDecR("E") -> 14
      =====================================*/
    public static int hexToDecR( String s ) {
	if( !s.equals("") ) {
	    return hexToDecR( s.substring(1) ) + (HEXDIGITS.indexOf(s.substring(0,1)));
	}
	else {
	    return 0;
	}
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hexadecimal values
      =============================================*/
    public boolean equals( Object other ) {
	if( other instanceof Hexadecimal ) {
	    return ( ( this == (Hexadecimal)other ) || ( this._hexNum.equals(((Hexadecimal)other)._hexNum ) ));
	}
	else {
	    throw new ClassCastException("\nERROR! equals() input not a hexadecimal");
	}
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if( other instanceof Hexadecimal ) {
	    if( this._decNum < ((Hexadecimal)other)._decNum )
		return -1;
	    else if( this._decNum == ((Hexadecimal)other)._decNum )
		return 0;
	    else {
		return 1;
	    }
	}
	else {
	    throw new ClassCastException("\nERROR! compareTo() input not a hexadecimal");
	}
    }


    //main method for testing
    public static void main( String[] args ) {


	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal b1 = new Hexadecimal(210);
	Hexadecimal b2 = new Hexadecimal(210);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(192);

	System.out.println( b1 ); // prints D2
	System.out.println( b2 ); // D2
	System.out.println( b3 ); // D2 
	System.out.println( b4 ); // C0
	
	System.out.println(hexToDec(b1.toString()));
	System.out.println(hexToDecR("0"));

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be pos
	System.out.println( b4.compareTo(b1) ); //should be neg
	/*=========================================
	  =========================================*/
    }//end main()

} //end class
