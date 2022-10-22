
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    // все получаемые данные и вывод идут через консоль
    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();

        //также написан метод для проверки, является ли строка правильной скобочной последовательностью
        //Ответ на задание 4:
        //Приведенная ниже последовательность не является правильной скобочной последовательностью.
        System.out.println(isRightParenthSeq("[((())()(())]]"));
        //Чтобы она стала правильной, нужно, например, изменить символ с индексом [1] на '['.
        //Пример ниже.
        System.out.println(isRightParenthSeq("[[(())()(())]]"));
        //Либо предпоследний на ')'. Вариантов может быть много.
        System.out.println(isRightParenthSeq("[((())()(()))]"));
    }

    //Составить алгоритм: если введенное число больше 7, то вывести “Привет”
    //для обозначения дробных считаем, что используется '.'
    //проверка на символьность для краевых чисел, которые могут не уместиться в Long
    public static void firstTask() {
        System.out.println("Provide number.");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        if (Objects.equals(number, "")){
            return;
        }
        if (number.charAt(0) == '+'){
            number= number.substring(1);
        }
        for (int k = 0; k < number.length(); k++){
            if (number.charAt(k) != '0'){
               number = number.substring(k);
               break;
            }
        }
        boolean numeric = number.matches("-?\\d+(\\.\\d+)?");
        if (!numeric) return;
        if (number.charAt(0) == '-'){
           return;
        }
        if (number.length() == 1 && number.charAt(0) != '8'&& number.charAt(0) != '9'){
            return;
        }
        if (Integer.parseInt(String.valueOf(number.charAt(0))) < 7 && number.charAt(1) == '.'){
            return;
        }
        if (number.substring(0,1).matches("\\d")){
            System.out.println("Привет");
            return;
        }
        if (number.charAt(0) == '8'|| number.charAt(0) == '9'){
            System.out.println("Привет");
            return;
        }
        if (number.charAt(0) == '7' && number.charAt(1) == '.'){
            System.out.println("Привет");
        }
    }


    //Составить алгоритм: если введенное имя совпадает с Вячеслав, то вывести “Привет, Вячеслав”,
    //если нет, то вывести "Нет такого имени"
    // делаем проверки на написание букв латиницей и кириллицей, где возможно.
    // Пример: 'B' - английская b, 'В' русская в, 'e' английская и русская и т.д.
    //Ввод должен визуально быть похож на слово "Вячеслав", написанное кириллицей. Регистр не указан.
    public static void secondTask() {
        System.out.println("Provide name.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (name.length() != 8){
            System.out.println("Нет такого имени");
            return;
        }
        boolean isVyacheslav = name.charAt(0) == 'B' || name.charAt(0) == 'В' || name.charAt(0) == 'в' ;
        if (!(name.charAt(1) == 'я' || name.charAt(1) == 'Я')){
            isVyacheslav = false;
        }
        if (!(name.charAt(2) == 'ч'|| name.charAt(2) == 'Ч')){
            isVyacheslav = false;
        }
        if (!(name.charAt(3) == 'e' || name.charAt(3) == 'е' ||name.charAt(3) == 'E' || name.charAt(3) == 'Е')){
            isVyacheslav = false;
        }
        if (!(name.charAt(4) == 'с' || name.charAt(4) == 'c' || name.charAt(4) == 'C' || name.charAt(4) == 'С')){
            isVyacheslav = false;
        }
        if (!(name.charAt(5) == 'л' || name.charAt(5) == 'Л')){
            isVyacheslav = false;
        }
        if (!(name.charAt(6) == 'а' || name.charAt(6) == 'a' || name.charAt(6) == 'А' || name.charAt(6) == 'A')){
            isVyacheslav = false;
        }
        if (!(name.charAt(7) == 'B' || name.charAt(7) == 'В' || name.charAt(7) == 'в')){
            isVyacheslav = false;
        }
        String output = isVyacheslav  ? "Привет, Вячеслав" : "Нет такого имени";
        System.out.println(output);
    }

    // Составить алгоритм: на входе есть числовой массив, необходимо вывести элементы массива кратные 3.
    // P.S. в целях интерактивного взаимодействия с пользователем,
    // числовой массив получаем через ввод в консоль внутри функции.
    // Числа обрабатываются по принципу: складываем каждое, если сумма кратна 3, выводим.
    // Если дробное - ищем точку, проверяем дробный остаток. Если он 0, делаем действия для целой части по пункту выше.
    public static void thirdTask() {
        System.out.println("Provide any natural number N, it will be size of an array.");
        Scanner sc = new Scanner(System.in);
        try {
            int i = sc.nextInt();
            System.out.println("Provide N numbers, to find multiple 3 in the row.");
            ArrayList<String> list = addNumbersToArray(i);
            System.out.println(list);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("You have to input number.");
            thirdTask();
        }
    }

    public static ArrayList<String> addNumbersToArray(Integer i) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String num = "";
        String number;
        Integer counter = 0;
        for (int j = 0; j < i; j++) {
            number = sc.nextLine();
            num = number;
            if (number.equals("") || number.equals("0") || number.equals("-0") || number.equals("+0")) {
                continue;
            }
            if (num.charAt(0) == '-') {
                num = num.substring(1);
            }
            if (num.charAt(0) == '+') {
                num = num.substring(1);
            }
            for (int k = 0; k < num.length(); k++) {
                if (num.charAt(k) != '0') {
                    num = num.substring(k);
                    break;
                }
            }
            boolean numeric = num.matches("-?\\d+(\\.\\d+)?");
            if (!numeric) continue;
            int pos = num.lastIndexOf(".");

            if (pos == -1) {
                for (int k = 0; k < num.length(); k++) {
                    Character ch = num.charAt(k);
                    counter += Integer.parseInt(String.valueOf(ch));
                    boolean b = Character.isDigit(ch);
                    if (!b) {
                        break;
                    }
                }
                if (counter % 3 == 0) {
                    list.add(number);
                }
            } else {
                String copy = num.substring(pos + 1);
                boolean isMultiple = true;
                for (int ik = 0; ik < copy.length(); ik++) {
                    if (copy.charAt(ik) != '0') {
                        isMultiple = false;
                        break;
                    }
                }
                if (isMultiple) {
                    num = num.substring(0,pos);
                    for (int k = 0; k < num.length(); k++) {
                        Character ch = num.charAt(k);
                        counter += Integer.parseInt(String.valueOf(ch));
                        boolean b = Character.isDigit(ch);
                        if (!b) {
                            break;
                        }
                    }
                    if (counter % 3 == 0) {
                        list.add(number);
                    }

                }

            }
        }
        return list;
    }





    private static boolean isRightParenthSeq(String inputStr) {
        if (Objects.equals(inputStr, "")){
            return true;
        }
        Stack stack = new Stack();
        char[] charArray = inputStr.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char current = charArray[i];
            if (current == '{' || current == '[' || current == '(') {
                stack.push(current);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char popChar;
            switch (current) {
                case ')':
                    popChar = (char) stack.pop();
                    if (popChar == '{' || popChar == '[')
                        return false;
                    break;
                case '}':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '[')
                        return false;
                    break;
                case ']':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}