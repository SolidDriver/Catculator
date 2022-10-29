import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException{
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("")) {
            throw new MyException("Пустая строка!");
        }
        Tester myTester = new Tester();
        Solver mySolver = new Solver();
        String testedText = myTester.test(input);
        String cut = testedText.substring(0, testedText.length()-1);
        int isRoman = Integer.parseInt(testedText.substring(testedText.length()-1));
        String solved = mySolver.solve(cut, isRoman);
        System.out.println(solved);
    }
}