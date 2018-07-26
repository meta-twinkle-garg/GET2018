package hexDecimal;

public interface NumberSystem {
    public String add(String number1, String number2);

    public String diff(String number1, String number2);

    public String mult(String number1, String number2);

    public String div(String number1, String number2);

    public boolean isGreater(String number1, String number2);

    public boolean isLess(String number1, String number2);

    public boolean isEqual(String number1, String number2);

}
