public class SecondTask {

    //Составить алгоритм: если введенное имя совпадает с Вячеслав, то вывести “Привет, Вячеслав”,
    //если нет, то вывести "Нет такого имени"
    // делаем проверки на написание букв латиницей и кириллицей, где возможно.
    // Пример: 'B' - английская b, 'В' русская в, 'e' английская и русская и т.д.
    //Ввод должен визуально быть похож на слово "Вячеслав", написанное кириллицей. Регистр не указан.
    public static void secondTask(String name) {
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
}
