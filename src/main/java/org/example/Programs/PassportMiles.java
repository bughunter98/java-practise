package org.example.Programs;

interface payment{
    default String type(){
        return "none";
    }
}
abstract class RewardpPoints{
    abstract String type();
}
public class PassportMiles extends RewardpPoints implements payment {
   public PassportMiles(){
       super();
   }
    public String type() {
        return "points";
    }

    public static void main(String[] args) {
        System.out.println(((RewardpPoints) new PassportMiles()).type());
    }
}
interface Trigger{
    default void enable(){
        System.out.println("Enable Trigger");
    }
}
interface Scheduler{
    default void enable(){
        System.out.println("Enable Scheduler");
    }
}
class Quartz implements Trigger,Scheduler{

    @Override
    public void enable() {
        System.out.println("enable Quartz");
    }
    static boolean a (int raing){
        System.out.println("a");
        return raing>6 ? true : false;
    };
    static boolean b (int raing){
        System.out.println("b");
        return raing>6 ? true : false;
    };
    static boolean c (int raing){
        System.out.println("c");
        return raing>6 ? true : false;
    };
    static boolean d (int raing){
        System.out.println("d");
        return raing>6 ? true : false;
    };

    public static void main(String[] args) {
        new Quartz().enable();
        boolean v = a(5)|c(4)&b(7)^d(8);
        System.out.println(v);

        String message = "Good Morning ";
        String newMessage = message.replaceAll("[A-Z]*","").trim();
        String sub = message.substring(2,message.trim().indexOf(" ")+2).concat(message.substring(message.trim().indexOf(" ")+2,message.length()));
        System.out.println(newMessage +" "+sub);
    }
}

