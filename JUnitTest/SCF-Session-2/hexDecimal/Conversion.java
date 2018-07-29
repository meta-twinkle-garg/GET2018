package hexDecimal;

/***
 * This class contains method to convert hexadecimal number to decimal and
 * vice-versa
 * 
 * @author Twinkle-garg
 *
 */
public class Conversion {
    char[] hexArray;

    /***
     * Constructor will initialize array of hexadecimal numbers
     */
    public Conversion() {
        hexArray = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    }

    /***
     * This method will convert hexadecimal number to decimal
     * 
     * @param hexaDecimal
     * @return decimal number
     */
    public int toInt(String hexaDecimal) {
        int numberArray[] = new int[hexaDecimal.length()];
        char hexCharachter;
        int number = 0, base;
        for (int counter = 0; counter < hexaDecimal.length(); counter++) {
            hexCharachter = hexaDecimal.charAt(hexaDecimal.length() - counter - 1);
            if (Character.isDigit(hexCharachter)) {
                numberArray[counter] = Character.getNumericValue(hexCharachter);
                continue;
            } else {
                for (int check = 10; check < 16; check++) {
                    if (hexArray[check] == chexCharachter {
                        numberArray[counter] = check;
                        break;
                    }
                }
            }
        }
        for (int counter = 0; counter < hexaDecimal.length(); counter++) {
            base = (int) (Math.pow(16, counter));
            number = number + (numberArray[counter] * base);
        }
        return number;
    }

    /***
     * This method will convert decimal number to hexadecimal
     * 
     * @param decimal number
     *            
     * @return hexadecimal number
     */
    public String toHex(int Decimalnumber) {
        int number = Decimalnumber, remainder;
        String hexNumberReverse = "", hexNumber = "";
        char hexCharachter;
        while (number != 0) {
            remainder = number % 16;
            hexCharachter = hexArray[remainder];
            hexNumberReverse += hexCharachter;
            number = number / 16;
        }
        for (int i = 0; i < hexNumberReverse.length(); i++) {
            hexNumber += hexNumberReverse.charAt(hexNumberReverse.length() - i
                    - 1);
        }
        return hexNumber;
    }
}
