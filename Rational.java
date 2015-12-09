/*
Team Squafartwo -- Richard Lin, Nielz Graham
APCS pd10
hw41 -- In America, the Driver Sits on the Left
2015-12-3
*/

public class Rational implements Comparable {
    
    //instance vars
    private int numerator;
    private int denominator;

    
    //default constructor
    public Rational() {
	//sets default number to 0/1
	numerator = 0;
	denominator = 1;
    }

    //overloaded constructor
    public Rational(int a, int b){
	this(); //calls default constructor
	if (b != 0){
	    //if denominator is not 0, set instance vars to paramaters
	    numerator = a;
	    denominator = b;
	}
    }
	    
    //==================mutators======================
    public void setNum( int num ) {
	numerator = num;
    }

    public void setDen( int num ) {
	denominator = num;
    }
    //================================================
    
    //==================PHASE 1=======================================

    //string representation of num as fraction
    public String toString() {
	//return "numerator/denominator"
	return numerator + "/" + denominator;    }

    //return the fraction as a floating point 
    public float floatValue(Rational num){
	//return the quotient of numerator and denominator as a float
	return (float)num.numerator/num.denominator;
    }
    
    //multiply
    public void multiply( Rational num ) {
	/*multiplies the numerator and denominators of this Rational object
	  and Rational num*/
        numerator *= num.numerator;
        denominator *= num.denominator;
    }

    //divide
    public void divide( Rational num) {
	/*multiplies the numerator and denominators of this Rational object
	  to the reciprocal of Rational num*/
        numerator *= num.denominator;
        denominator *= num.denominator;
    }
    //================================================================

    //==================PHASE 2========================================
    //adds num to the calling rational
    public void add(Rational num){
	int num1Num = this.numerator;
	int num1Den = this.denominator;
	int num2Num = num.numerator;
	int num2Den = num.denominator;
	this.numerator = num1Num * num2Den + num1Num * num1Den;
	this.denominator = num1Den * num2Den;
    }//end add
    
    //subtracts num from the calling rational
    public void subtract(Rational num){
	int num1Num = this.numerator;
	int num1Den = this.denominator;
	int num2Num = num.numerator;
	int num2Den = num.denominator;
	this.numerator = num1Num * num2Den - num1Num * num1Den;
	this.denominator = num1Den * num2Den;
    }//end subtract
    
    //returns the GCD of numerator and denominator
    public int gcd(){
	return gcd(numerator, denominator);
    }//end gcd
    
    //Reduces the numerator and the denominator so GCD is 1.
    public Rational reduce(){
	int a = this.numerator;
	int b = this.denominator;
	int g = gcd(a , b);
	//divide the numerator and the denominator by the g so the GCD is 1.
	this.numerator = a/g;
	this.denominator = b/g;
	return this;
    }//end reduce
    //===================================================================

    //==================PHASE 3=========================================
    //returns the GCD of 2 integers
    private static int gcd(int m, int n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
    }//end gcd

    //Compares the calling rational to the parameter
    public int compareTo(Object factor) {
	//I didn't reduce the Rationals because that would alter them without the user explicitly wanting to alter them

	//This is a check to see if its Rational
	if( !(factor instanceof Rational) ) {
	    System.out.println("Error. Not a Rational. Printin -2");
	    return -2;
	}

	//Typecasting factor into a rational
	Rational temp = (Rational)factor;
	int thisNumer = numerator * temp.denominator;
	int thatNumer = temp.numerator * denominator;

	//The following is just basic fraction comparison. Multiply by each other's denominators and then compare numerators.
	if(thisNumer == thatNumer ) {
	    return 0;
	}
	else if(thisNumer > thatNumer) {
	    return 1;
	}
	else {
	    return -1;
	}
    }
   
    //end compareTo
    //==================================================================

    //===================PHASE 4=========================================

    public boolean equals(Object rat) {
	//First check aliasing:
	boolean retVal = this == rat;

	//Next, if this and input are different objects:
	if (!retVal) {
	    
	    //check if input object is Rational:
	     //Compares the calling rational to the parameter
	    retVal = rat instanceof Rational

		//And then use compareTo to check for instance variable equality
		&& (this.compareTo((Rational)rat) == 0);
	}
	
	return retVal;

    }




    //==================================================================
    //main method
    public static void main( String[]args ) {
	Rational bob = new Rational();
	Rational emma = new Rational();
	Rational kevin = new Rational(3, 9);
	Rational Jimbo = new Rational(48, 12);
	Rational Bayle = new Rational(27, 81);
	//emma.setNum(10);
	//bob.setNum(3);
	//bob.setDen(5);
	//System.out.println( emma + "\n" + bob);
	//emma.multiply( bob );
	//System.out.println( emma );
	//System.out.println(floatValue(emma));
	System.out.println( kevin + "\n" + Bayle);
        System.out.println(kevin.equals(Bayle));
	System.out.println(kevin.equals(Jimbo));
    }//end main
    
}//end class
