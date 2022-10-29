public class Solver {
    public String solve(String input, int isRoman) throws MyException {
        Converter convert = new Converter();
        String[] objs = input.split(" ");

        String output = "";
        int result = 0;

        String var1 = "";
        String var2 = "";

        if (isRoman == 1) {
            var1 = convert.toInteger(objs[0]);
            var2 = convert.toInteger(objs[2]);
        } else if (isRoman == 0) {
            var1 = objs[0];
            var2 = objs[2];
        }

        if (Integer.parseInt(var1) > 10 || Integer.parseInt(var2) > 10) {
            throw new MyException("Операнд больше 10.");
        } else if  (Integer.parseInt(var1) < 1 || Integer.parseInt(var2) < 1) {
            throw new MyException("Операнд меньше 1");
        }

        switch (objs[1]) {
            case "-" -> result = (Integer.parseInt(var1) - Integer.parseInt(var2));
            case "+" -> result = (Integer.parseInt(var1) + Integer.parseInt(var2));
            case "*" -> result = (Integer.parseInt(var1) * Integer.parseInt(var2));
            case "/" -> result = (Integer.parseInt(var1) / Integer.parseInt(var2));
        }
        if (isRoman == 1) {
            if (result < 1) {
                throw new MyException("В римской системе нет отрицательных чисел.");
            }
            output = convert.toRoman(result) + "";
        } else if (isRoman == 0) {
            output = result + "";
        }
        
        return output;
    }
}
