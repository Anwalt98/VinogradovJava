import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThirdTask {

    // Составить алгоритм: на входе есть числовой массив, необходимо вывести элементы массива кратные 3.
    // P.S. в целях интерактивного взаимодействия с пользователем,
    // числовой массив получаем через ввод в консоль внутри функции.
    // Числа обрабатываются по принципу: складываем каждый разряд числа, если сумма кратна 3, выводим.
    // Если дробное - ищем точку, проверяем дробный остаток. Если он 0, делаем действия для целой части по пункту выше.
    public static void thirdTask() {
        System.out.println("Provide any natural number N, it will be size of an array.");
        Scanner sc = new Scanner(System.in);
        try {
            int i = sc.nextInt();
            if (i < 0){
                throw new InputMismatchException();
            }
            System.out.println("Provide N numbers, to find multiple 3 in the row.");
            ArrayList<String> list = addNumbersToArray(i);
            System.out.println(list);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("You have to input correct natural number.");
            thirdTask();
        }
    }

    public static ArrayList<String> addNumbersToArray(Integer i) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String num = "";
        String number;
        int counter = 0;
        for (int j = 0; j < i; j++) {
            number = sc.nextLine();
            num = number;
            if (number.equals("") || number.equals("0") || number.equals("-0") || number.equals("+0")) {
                continue;
            }
            //убираем '-', чтобы потом сложить все числа по разряду
            if (num.charAt(0) == '-') {
                num = num.substring(1);
            }
            // то же самое с '+'
            if (num.charAt(0) == '+') {
                num = num.substring(1);
            }
            //удаляем первые по разряду 0, если есть в числе
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
                        counter = 0;
                        break;
                    }
                }
                if (counter % 3 == 0) {
                    list.add(number);
                    counter = 0;
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
                            counter = 0;
                            break;
                        }
                    }
                    if (counter % 3 == 0) {
                        list.add(number);
                        counter = 0;
                    }

                }
            }
        }
        return list;
    }
}
