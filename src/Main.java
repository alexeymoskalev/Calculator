import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {
        int number1;
        int number2;
        String operator;
        String result;
        boolean isRoman;
        String[] oper = input.split("[+\\-*/]");
        if(oper.length !=2)  throw new Exception("Формат математической операции не удовлетворяет задание - два операнда и один оператор (+, -, /, *)");
        operator = findOperator(input);
        if(operator == null) throw new Exception("Строка не является математической операцией");
        if(Romanletters.isRoman(oper[0]) && Romanletters.isRoman(oper[1])) {
            number1 = Romanletters.convertToArabian(oper[0]);
            number2 = Romanletters.convertToArabian(oper[1]);
            isRoman = true;
        }
        else if(!Romanletters.isRoman(oper[0]) && !Romanletters.isRoman(oper[1])) {
            number1 = Integer.parseInt(oper[0]);
            number2 = Integer.parseInt(oper[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        if (number1 > 10 || number2 > 10)  {
            throw new Exception("Введенное число должно быть от 1 до 10");
        }
        int arab = calculate(number1,number2,operator);
        if(isRoman) {
            if (arab <=0) {
                throw new Exception("В римской системе нет отрицательных чисел");
            }
            result = Romanletters.convertToRoman(arab);
        } else {
            result = String.valueOf(arab);
        }
        return result;
    }
    static String findOperator(String input) throws Exception {
        if (input.contains("+")) {
            return "+";
        } else if (input.contains("-")) {
            return "-";
        } else if (input.contains("*")) {
            return "*";
        } else if (input.contains("/")) {
            return "/";
        } else {
            return null;
        }
    }

    static int calculate(int x, int y, String operator) {
        if (operator.equals("+")) {
            return x + y;
        } else if(operator.equals("-")) {
            return x - y;
        } else if(operator.equals("*")) {
            return x * y;
        } else {
            return x / y;
        }
    }
    class Romanletters {
        static String[] arr = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

    static boolean isRoman(String s) {
        for(int i = 0; i < arr.length; i++) {
            if(s.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }
    static int convertToArabian(String roman) {
        for(int i = 0; i < arr.length; i++) {
            if(roman.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
    static String convertToRoman(int arab) {

        return arr[arab];
            }
    }
}
