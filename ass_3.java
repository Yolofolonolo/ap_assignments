import java.util.Random;
import java.util.Scanner;
public class ass_3 {
    static String floor[]=new String[14];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        floor[0]="START";floor[1]="EMPTY";floor[2]="ELEVATOR";floor[3]="EMPTY";floor[4]="EMPTY";floor[5]="SNAKE";floor[6]="EMPTY";floor[7]="EMPTY";floor[8]="LADDER";floor[9]="EMPTY";floor[10]="EMPTY";floor[11]="KINGCOBRA";floor[12]="EMPTY";floor[13]="FINISH";
        System.out.println("Enter the player name and hit enter");
        player_.name= sc.nextLine();
        System.out.println("The game setup is ready");

        while(true){
            System.out.println("Hit enter to roll a dice");
            dice d = new dice();
            int diceResult = d.generateNumber();

            if(diceResult==1){
                System.out.println("Player position - " + player_.pos);
                System.out.println(player_.name + " has reached an empty floor");
                System.out.println("Total points " + player_.score);

                player_.pos +=1;
                player_.score+=1;
                break;
            }
            System.out.println("Game can not start until you get 1.");
        }

        boolean first_try = true;

        while (true){
            dice d = new dice();
            System.out.print("Hit enter to roll a dice ");
            sc.nextLine();

            int d1 = d.generateNumber();
            System.out.println("dice gave " + d1);

            if(first_try && d1 == 2){
                System.out.println("Game cannot start until you get 1");
                continue;
            }

            if(d1 == 1 && first_try){
                first_try = false;
            }

            if(player_.pos+d1 <= 13) {
// n is the position to be updated
                int n = d1 + player_.pos;

                player_.display_();
//                these floor are empty floors
                if (n == 1 || n == 3 || n == 4 || n == 6 || n == 7 || n == 9 || n == 10) {
                    empty e = new empty();
                    e.score_(floor[player_.pos]);
                    e.display_();
                } else if (n == 2) {
                    stairs s = new stairs();
                    s.score_(floor[player_.pos]);
                    s.display_();
                } else if (n == 5) {
                    snake_ sn = new snake_();
                    sn.score_(floor[player_.pos]);
                    sn.display_();
                } else if (n == 8) {
                    empty e = new empty();
                    e.score_(floor[player_.pos]);
                    e.display_();
                } else if (n == 11) {
                    snake_ sn = new snake_();
                    sn.score_(floor[player_.pos]);
                    sn.display_();
                } else if (n == 13) {
                    player_.score += 1;
                    player_.pos = 13;
                    System.out.println("finished");
                    break;
                }
            }
        }
    }

}
class dice{
    private int diceFace;

    public void setDiceFace(int val){
        diceFace = val;
    }

    public int getDiceFace(){
        return diceFace;
    }

    public int generateNumber(){
        Random r = new Random();
        int n = r.nextInt(2) + 1;
        setDiceFace(n);
        return getDiceFace();
    }
}

class player_{
    static String name = null;
    static int pos = -1;
    static int score = 0;
    static String floor_ = null;

    public static void display_(){
        System.out.println("Player position Floor "+player_.pos);
        System.out.println(player_.name+" has reached an "+ player_.floor_);
        System.out.println("Total points "+player_.score);
    }
}
class empty extends player_{
    public static void score_(String floor){
        if(floor.equals("EMPTY")){
            player_.score+=1;
            player_.pos+=1;
        }
    }
}

class snake_ extends player_{
    public static void score_(String floor){
        if(floor.equals("SNAKE")){
            player_.score-=2;
            player_.pos=1;
        }
        if(floor.equals("KINGCOBRA")){
            player_.score-=4;
            player_.pos=3;
        }
    }
}

class stairs extends player_ {
