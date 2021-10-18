import java.util.ArrayList;
import java.util.*;

class Lecture_Slides implements material{
    private String s = "";
    @Override
    public void add(){

    }
    @Override
    public void view(){

    }
}
class lecture_Recordings implements material {
    @Override
    public void add(){

    }
    @Override
    public void view(){

    }
}
interface material{
    public void add();
    public void view();
}
interface loda{
    public void add();
    public void view();
    public void submission();
    public void grade();
}
class assignment implements loda {

    public void add() {
    }



    @Override
    public void view() {


    }



    @Override
    public void submission() {


    }



    @Override
    public void grade() {


    }
}
class quiz implements loda {

    public void add() {
    }

    public void view() {
    }

    @Override
    public void submission() {


    }

    @Override
    public void grade() {


    }

}

class instructor {
}
class student{

}
class comment implements material{
    @Override
    public void add() {
        
    }

    @Override
    public void view() {

    }
}
class backpack {
    //arraylist for all the classes 

    public static void displayinstructor () {
        System.out.println("INSTRUCTOR MENU\n" +
                "1. Add class material\n" +
                "2. Add assessments\n" +
                "3. View lecture materials\n" +
                "4. View assessments\n" +
                "5. Grade assessments\n" +
                "6. Close assessment\n" +
                "7. View comments\n" +
                "8. Add comments\n" +
                "9. Logout");
    }

    public static void displaystudent() {
        System.out.println("STUDENT MENU\n" +
                "1. View lecture materials\n" +
                "2. View assessments\n" +
                "3. Submit assessment\n" +
                "4. View grades\n" +
                "5. View comments\n" +
                "6. Add comments\n" +
                "7. Logout");
    }


    Scanner sc = new Scanner(System.in);{

        while (true) {

            System.out.println("Welcome to Backpack.");
            System.out.println("1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.println("Instructors:\n" +
                        "0 - I0\n" +
                        "1 - I1");

                String instructor_id = sc.next();

                System.out.println("Welcome " + instructor_id);

                while (true) {

                    displayinstructor();

                    int choicefortask = sc.nextInt();

                    if (choicefortask == 1) {

                        System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");

                        int choiceforlecture = sc.nextInt();

                        if (choiceforlecture == 1) {

                            Lecture_Slides slidesobject = new Lecture_Slides();

                            slidesobject.add();

                        } else if (choiceforlecture == 2) {

                            lecture_Recordings videosobject = new lecture_Recordings();

                            videosobject.add();

                        }

                    }
                    else if (choicefortask == 2) {

                        System.out.println("1. Add Assignment\n" +
                                "2. Add Quiz");

                        if (choice == 1) {

                            assignment assignmentobject = new assignment();

                            assignmentobject.add();

                        } else if (choice == 2) {


                            quiz quizobject = new quiz();

                            quizobject.add();

                        }

                    }

                    else if(choicefortask == 3 ) {

                        Lecture_Slides slidesobject = new Lecture_Slides();
                        lecture_Recordings videosobject = new lecture_Recordings();
                        slidesobject.view();
                        System.out.println("-----------------------------------------");
                        videosobject.view();

                    }

                    else if(choicefortask == 4 ) {

                        int counter = 0;

                        assignment assignmentobject = new assignment();
                        quiz quizobject = new quiz();
                        assignmentobject.view();
                        System.out.println("-----------------------------------------");
                        quizobject.view();

                    }
                    else if(choicefortask == 5 ){

                    }
                    else if(choicefortask == 6 ) {

                    }
                    else if(choicefortask == 7 ) {

                    }
                    else if(choicefortask == 8 ) {

                    }

                    else if(choicefortask==9) {
                        break;
                    }


                }


                displayinstructor();

            }

            else if (choice == 3) {
                break;
            }
        }
    }

    public static void start() {
    }
}

public class Appp {
    public static void main(String[] args){
        backpack.start();
    }

}




