
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
        //Также ниже приведены примеры правильных скобочных последовательностей
        System.out.println(isRightParenthSeq("[][(){}()]"));
        System.out.println(isRightParenthSeq("()"));
        System.out.println(isRightParenthSeq("{}"));
    }

    //Составить алгоритм: если введенное число больше 7, то вывести “Привет”
    public static void firstTask() {
        System.out.println("Provide number.");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int numberSeven;
        try {
            numberSeven = Integer.parseInt(number);
            if (numberSeven > 7) {
                System.out.println("Привет");
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Incorrect input");
        }
    }

    //Составить алгоритм: если введенное имя совпадает с Вячеслав, то вывести “Привет, Вячеслав”,
    //если нет, то вывести "Нет такого имени"
    public static void secondTask() {
        System.out.println("Provide name.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String output = name.equalsIgnoreCase("вячеслав") ? "Привет, Вячеслав" : "Нет такого имени";
        System.out.println(output);
    }

    // Составить алгоритм: на входе есть числовой массив, необходимо вывести элементы массива кратные 3.
    // P.S. в целях интерактивного взаимодействия с пользователем,
    // числовой массив получаем через ввод в консоль внутри функции.
    public static void thirdTask() {
        System.out.println("Provide any number N, it will be size of an array.");
        Scanner sc = new Scanner(System.in);
        try {
            int i = sc.nextInt();
            System.out.println("Provide N numbers, to find multiple 3 in the row.");
            ArrayList<Integer> list = addNumbersToArray(i);
            printMultipleOfThree(list);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("You have to input number.");
            thirdTask();
        }
    }

    public static ArrayList<Integer> addNumbersToArray(Integer i) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String num = "";
        for (int j = 0; j < i; j++) {
            num = sc.nextLine();
            try {
                Integer f = Integer.parseInt(num);
                list.add(f);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("You have to input number.");
                j--;
            }
        }
        return list;
    }

    public static void printMultipleOfThree(ArrayList<Integer> list) {
        List<Integer> listToPrint = list
                .stream()
                .filter(integer -> integer % 3 == 0 && integer != 0)
                .collect(Collectors.toList());
        System.out.println(listToPrint);
    }


    private static boolean isRightParenthSeq(String inputStr) {
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