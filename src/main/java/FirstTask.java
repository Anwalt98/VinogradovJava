import java.util.Objects;

public class FirstTask {

    //Составить алгоритм: если введенное число больше 7, то вывести “Привет”
    //для обозначения дробных считаем, что используется '.'
    //проверка на символьность для краевых чисел, которые могут не уместиться в Long

    public static void firstTask(String number) {
        if (Objects.equals(number, "")){
            return;
        }
        //убираем '+'
        if (number.charAt(0) == '+'){
            number= number.substring(1);
        }
        //убираем первые по разряду '0', если есть
        for (int k = 0; k < number.length(); k++){
            if (number.charAt(k) != '0'){
                number = number.substring(k);
                break;
            }
        }
        // проверка валидности строки. Может быть либо стандартным целым числом, либо с плавающей точкой.
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
        String reduced = number.substring(0,2);
        if (number.substring(0,1).matches("\\d") && !reduced.equals("7.")){
            System.out.println("Привет");
            return;
        }
        if (number.charAt(0) == '8'|| number.charAt(0) == '9'){
            System.out.println("Привет");
            return;
        }
        boolean more7 = true;
        String reduced2 = number.substring(2);
        for (int i = 0; i < reduced2.length(); i++){
            if (reduced2.charAt(i) == '0') {
                more7 = false;
            }
            else {
                more7 = true;
                break;
            }
        }
        if ((number.charAt(0) == '7' && number.charAt(1) == '.') && (more7) ){
            System.out.println("Привет");
        }
    }
}
