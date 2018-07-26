package hexDecimal;

/***
 * This class contains several methods to be implemented on hexadecimal numbers
 * 1. add 2 hexadecimal numbers 2. subtract 2 hexadecimal numbers 3. multiply 2
 * hexadecimal numbers 4. divide 2 hexadecimal numbers 5. compare 2 hexadecimal
 * numbers
 * 
 * @author Twinkle-Garg
 *
 */

public class HexCalc implements NumberSystem {
    /***
     * Returns addition of 2 hexadecimal numbers
     * 
     * @param number1
     * @param number2
     * @return result of addition
     */
    public String add(String number1, String number2) {

        Conversion obj = new Conversion();
        int num1 = obj.toInt(number1);
        int num2 = obj.toInt(number2);
        int sum = num1 + num2;
        String result = obj.toHex(sum);
        return result;
    }

    /***
     * Returns difference of 2 hexadecimal numbers
     * 
     * @param number1
     * @param number2
     * @return result of subtraction
     */
    public String diff(String number1, String number2) {
        Conversion obj = new Conversion();
        int num1 = obj.toInt(number1);
        int num2 = obj.toInt(number2);
        int difference = num1 - num2;
        String result = obj.toHex(difference);
        return result;
    }

    /***
     * Returns multiplication of 2 hexadecimal numbers
     * 
     * @param number1
     * @param number2
     * @return result of multiplication
     */
    public String mult(String number1, String number2) {
        Conversion obj = new Conversion();
        int num1 = obj.toInt(number1);
        int num2 = obj.toInt(number2);
        int multiply = num1 * num2;
        String result = obj.toHex(multiply);
        return result;
    }

    /***
     * Returns division of 2 hexadecimal numbers
     * 
     * @param number1
     * @param number2
     * @return result of division
     */
    public String div(String number1, String number2) {
        Conversion obj = new Conversion();
        int num1 = obj.toInt(number1);
        int num2 = obj.toInt(number2);
        int division = num1 / num2;
        String result = obj.toHex(division);
        return result;
    }

    /***
     * Compares if 1 number is greater than other
     * 
     * @param number1
     * @param number2
     * @return true if number1>number2
     */
    public boolean isGreater(String number1, String number2) {
        int counter;
        if (number1.length() > number2.length()) {
            return true;
        } else if (number1.length() < number2.length()) {
            return false;
        } else {
            if (isEqual(number1, number2)) {
                return false;
            } else {
                for (counter = 0; counter < number1.length(); counter++) {
                    if (number1.charAt(counter) < number2.charAt(counter)) {
                        return false;
                    }

                }
            }

            return true;
        }
    }

    /***
     * Compares if 1 number is smaller than other
     * 
     * @param number1
     * @param number2
     * @return true if number1<number2
     */
    public boolean isLess(String number1, String number2) {
        int counter;
        if (number1.length() < number2.length()) {
            return true;
        } else if (number1.length() > number2.length()) {
            return false;
        } else {
            if (isEqual(number1, number2)) {
                return false;
            } else {
                for (counter = 0; counter < number1.length(); counter++) {
                    if (number1.charAt(counter) > number2.charAt(counter)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    /***
     * Compares if 1 number is equal to other
     * 
     * @param number1
     * @param number2
     * @return true if number1=number2
     */
    public boolean isEqual(String number1, String number2) {
        int counter;
        if (number1.length() == number2.length()) {
            for (counter = 0; counter < number1.length(); counter++) {
                if (number1.charAt(counter) != number2.charAt(counter)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }
}
