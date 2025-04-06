package org.example.Programs.Patterns;

public class StarPatterns {
    public static void main(String[] args) {
        for (int i=0;i<2;i++){
            for (int j=0;j<=i;j++){
                starPattern1();
            }
        }
    }

    private static void starPattern1() {
        var val=5;
        int space = val-1;
        for (int i=0;i<val;i++){
            for (int j=0;j<=i;j++){
                if (j==0){
                    System.out.print(" ".repeat(space)+"* ");
                    space--;
                }
                else if (j==i || i==val-1){
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        /*
                                *
                               * *
                              *   *
                             *     *
                            * * * * *
                           *         *
                          * *       * *
                         *   *     *   *
                        *     *   *     *
                       * * * * * * * * * *





         *
         */
    }
}
