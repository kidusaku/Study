package saku;

public class Task6_6 {
    public static void main(String[] args) {
        String[] names = {"Aki", "Ken", "Mina"};
        String numText = "10a";
        
        try {
            int value = Integer.parseInt(numText);
            System.out.println("value: " + value);
        } catch (Exception e) {
            System.out.println("数値に変換できません ");
            System.out.println(e.getClass().getName());
        }
        
        try {
            System.out.println("name: " + names[3]);
        } catch (Exception e) {
            System.out.println("処理を続けます");
            System.out.println(e.getClass().getName());
        }
        finally {
            System.out.println("finallyの処理です" );
        }
        System.out.println("処理を続けます");
        
    }
    
}