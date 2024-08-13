import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Формат ввода A + B или A+B\nВвод: ");

        while (scan.hasNextLine()){
            String input = scan.nextLine();
            if (input.isEmpty()){
                break;
            }
            try {
                String result = сalc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                throw new RuntimeException("Ошибка! " + e.getMessage());
            }

        }
        scan.close();


    }
    public static String сalc(String input){
        input = input.replaceAll(" ", "");

        String[] nums = input.split("(?<=[-+*/])|(?=[-+*/])");
        if (nums.length !=3){
            System.out.println(nums.length);
            throw new IllegalArgumentException ("Ожидается Ввод в формате A + B или A+B");
        }

        int num1;
        int num2;

        try {
            num1 = Integer.parseInt(nums[0]);
            num2 = Integer.parseInt(nums[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Не верные значения чисел");
        }


        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа только от 1 - 10");
        }

        String act = nums[1];

        int answer = 0;

        switch (act){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                try {answer = num1 / num2;
                    break;
                }catch (ArithmeticException e){
                    System.out.println("На ноль делить нельзя");
                }
            default:
                throw new IllegalArgumentException("Не известная операция. Операции вида + - * /");
        }
        return String.valueOf(answer);
        }
}