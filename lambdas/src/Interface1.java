

public class Interface1 {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 =  a->  Math.sqrt(a) ;
        Formula formula2 =  a->  (a*a) ;
    

      System.out.println(  formula1.calculate(100));     // 10.0
      System.out.println( formula2.calculate(23));          // 0.0
      System.out.println( Formula.positive(-4));        // 0.0

    }

}