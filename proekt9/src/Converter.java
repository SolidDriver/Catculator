import java.util.HashMap;

public class Converter {
    public String toRoman(int number) {
        String[] d3 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] d2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] d1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return d3[(number % 1000)/100] + d2[(number % 100) / 10] + d1[number % 10];
    }

    public String toInteger(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);

        int result=0;
        for(int i=0; i<text.length(); i++) {
            char ch = text.charAt(i);
            /* Тут проверяется индекс цифры в полученном стринге
            Если это римское число БОЛЬШЕ чем предыдущее (предыдущее получается вычитанием 1 из индекса)
            то к результату прибавляется разность между ключем этой цифры, и предедыдущей цифры умноженноЙ на 2. */
            if( (i>0) && map.get(ch) > map.get(text.charAt(i-1)) ) {
                result += ( map.get(ch) - 2 * map.get(text.charAt(i-1)) );
            } else
                result += map.get(ch);
            // В остальных случаях ключ римской цифры в хешмапе прибавляется к результату.
        }
        return result+"";
    }
}
