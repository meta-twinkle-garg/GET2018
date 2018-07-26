package hexDecimal;

import java.util.Scanner;

public class MainClass {
    public static void main(String args[]) {
        HexCalc c = new HexCalc();
        Conversion convertInstance = new Conversion();
        String number1, number2, result;
        int num;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. to add");
            System.out.println("2. to subtract");
            System.out.println("3. to multiply");
            System.out.println("4. to divide");
            System.out.println("5. to check number1>number2");
            System.out.println("6. to check number1>=number2");
            System.out.println("7. to check number1<number2");
            System.out.println("8. to convert decimal to hexadecimal");
            System.out.println("9. to convert hexadecimal to decimal");
            System.out.println("10. to exit");
            System.out.println("Enter appropriate option");
            int option = sc.nextInt();
            boolean compare;
            switch (option) {
            case 1:
                System.out.println("Enter 2 numbers");
                number1 = sc.next();
                number2 = sc.next();
                result = c.add(number1, number2);
                System.out.println("addition result = " + result);
                break;
            case 2:
                System.out.println("Enter 2 numbers");
                number1 = sc.next();
                number2 = sc.next();
                result = c.diff(number1, number2);
                System.out.println("subtraction result = " + result);
                break;
            case 3:
                System.out.println("Enter 2 numbers");
                number1 = sc.next();
                number2 = sc.next();
                result = c.mult(number1, number2);
                System.out.println("multiplication result = " + result);
                break;
            case 4:
                System.out.println("Enter 2 numbers");
                number1 = sc.next();
                number2 = sc.next();
                result = c.div(number1, number2);
                System.out.println("division result = " + result);
                break;
            case 5:
                System.out.println("Enter 2 numbers");
                number1 = sc.next();
                number2 = sc.next();
                compare = c.isGreater(number1, number2);
                System.out.println("" + compare);
                break;
            case 6:
                System.out.println("Enter 2 numbers");
                number1 = sc.next();
                number2 = sc.next();
                compare = c.isLess(number1, number2);
                System.out.println("" + compare);
                break;
            case 7:
                System.out.println("Enter 2 numbers");
                number1 = sc.next();
                number2 = sc.next();
                compare = c.isEqual(number1, number2);
                System.out.println("" + compare);
                break;
            case 8:
                System.out.println("Enter hexadecimal number");
                number1 = sc.next();
                num = convertInstance.toInt(number1);
                System.out.println("Decimal number is: " + num);
                break;
            case 9:
                System.out.println("Enter decimal number");
                num = sc.nextInt();
                result = convertInstance.toHex(num);
                System.out.println("Hexadecimal number is: " + result);
                break;
            case 10:
                System.exit(0);
            default:
                System.out.println("Enter appropriate option");
            }

        }

    }
}
