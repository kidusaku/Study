package chapter2;

public class DebugExample {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;

        // 配列の合計を計算
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        // 平均を計算
        int average = sum / numbers.length;

        System.out.println("合計: " + sum);
        System.out.println("平均: " + average);
    }
}