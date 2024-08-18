package org.example.Programs;

import java.util.stream.Stream;

public class InnerClass {
    final private int population = 250 ;
    final protected class city{
        final private int population = 10000 ;
        public final int getPopulation(){
            return InnerClass.this.population;
        }

    }

    final city city = new city();

  /*final  public static void main(String[] args) {
      System.out.println(new InnerClass().city.getPopulation());

    }*/


}
class Login{
    String role;
    boolean isAdmin(){
        return "admin".equalsIgnoreCase(role);
    }
}
 class AdminConsole{
    final public static void main(String[] args) {
        Login login = new Login();
        Login login1 = new Login();
        Login login2 = new Login();
        login2.role="admin";
        login.role="admin";
        Stream.of(login1,login).filter(Login::isAdmin).forEach(System.out::println);
        System.out.println("C"+1+3);
    }
}
