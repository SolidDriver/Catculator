import java.util.regex.Pattern;

public class Tester {
    public String test(String text) throws MyException  {
        int isRoman;
        String[] elements = text.split(" ");

        if (Pattern.matches("[-+*/]+", text)){
            throw new MyException("Строка не является математической операцией");}
        if (elements.length != 3) {
            throw new MyException("Неподходящий формат операции");}
        else {
            if (Pattern.matches("[IVX]+", elements[0]) && Pattern.matches("[IVX]+", elements[2])) {
                isRoman = 1;
            }
            else if (Pattern.matches("[0-9]+", elements[0]) && Pattern.matches("[0-9]+", elements[2])) {
                isRoman = 0;}
            else {
                throw new MyException("Неподходящий формат операции");}
        }
        return text+isRoman;
    }
}
