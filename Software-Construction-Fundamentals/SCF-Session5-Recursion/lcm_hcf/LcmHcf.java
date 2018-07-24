
package lcm_hcf;

/**
 *This class contains 2 methods to compute LCM and HCF of 2 numbers by recursion
 * @author Twinkle-Garg
 */
public class LcmHcf {
/***
 * This method uses Euclid's algorithm to find GCD or HCF of 2 numbers
 * @param number1
 * @param number2
 * @return HCF of number1 and number2
 */
 public int hcf(int number1, int number2)
{
    if (number1 == 0 || number2 == 0)
       return 0;

    if (number1 == number2)
        return number1;

    if (number1 > number2)
        return hcf(number1-number2, number2);
    return hcf(number1, number2-number1);
}

    /**
     *This method will return LCM of 2 numbers by computing HCF and dividing it with product of numbers
     * @param number1
     * @param number2
     * @return LCM of number1 and number2
     */
    public int lcm(int number1,int number2){
     return (number1*number2)/hcf(number1,number2); 
  }
}
