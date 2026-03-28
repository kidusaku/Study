public class Task4_27 {
    public static void main(String[] args) {
        String[] names = {"Aki", "Ken", "Mina"};
        try {System.out.println(names[3]);            
        } catch (Exception e) {
            System.out.println("配列の範囲外アクセスが発生しました");
        }
        finally {
            System.out.println("finallyの処理です");
        }
        System.out.println("処理を続けます");
    }
}

/*問２
 * 配列は０から考えるため、names[3]は存在しない4番目を指している。
 * 対処法としては0～2を指すか、for構文にlengthを使って、エラーが起きないようにする。
 * 
 *  
 *  

 */
