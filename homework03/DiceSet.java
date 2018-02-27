/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Josh Patterson
 *  Date          :  2017-02-20
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson    Initial writing and release
 *  @version 1.1.0  2017-02-17  B.J. Johnson    Filled in method code
 *  @version 1.2.0  2017-02-21  Josh Patterson  Methods Filled in
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
// public class Die {   NOTE: THIS IS WRONG; MUST MATCH THE FILE NAME
public class DiceSet {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private final int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   // public Die( int nSides ) {   NOTE: THIS IS WRONG; MUST MATCH THE FILE NAME - ALSO NEEDS TWO ARGS
   public DiceSet( int nSides ) {
      if ( nSides < MINIMUM_SIDES ) {
        throw new IllegalArgumentException( "\n Enter atleast 4" );
      } else {
          this.sides = nSides;
          pips = 1;
      }
   }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   public int roll() {
      pips = (int)Math.floor(Math.random() * this.sides + 1);
      return pips;
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {
      return this.pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public void setSides( int sides ) {
     if (sides < MINIMUM_SIDES ) {
       throw new IllegalArgumentException( "Enter atleast 4" );
     } else { this.sides = sides; }
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
      String dieString = "[" + pips + "]";
    return dieString;
  }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString( Die d ) {
     // String dieString = "[" + d.pips + "]";   NOTE: THIS IS WRONG; "pips" IS PRIVATE.  USE "getValue()"
     String dieString = "[" + d.getValue() + "]";
    return dieString;
  }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args) {
    // Die d1 = new Die(1);   NOTE: THIS NEEDS TO BE IN A TRY-CATCH BLOCK TO KEEP FROM BLOWING UP
    Die d4 = new Die(4);
    Die d7 = new Die(7);

    // System.out.println("Test of rolling dice 1" + d1.roll());

    System.out.println("Test of pip count of dice 4" + d4.getValue());

    System.out.println("Test of string result of dice 4" + d4.toString());

  }
}
