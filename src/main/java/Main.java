
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    // все получаемые данные и вывод идут через консоль
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //задание 1. Передаем число в виде строки.
        System.out.println("Provide number.");
        String number = sc.nextLine();
        FirstTask.firstTask(number);


        // задание 2.
        System.out.println("Provide name.");
        String name = sc.nextLine();
        SecondTask.secondTask(name);

        // задание 3.
        ThirdTask.thirdTask();

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