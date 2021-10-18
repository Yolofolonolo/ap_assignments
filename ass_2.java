import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;
import java.util.regex.Pattern;

class Lecture_Slides implements material{
    private String topic;
    private String number;
    private String [] content;
    private String time;

    public Lecture_Slides(String topic, String number, String[] content, String time, int addedbyuser, String filename) {
        this.topic = topic;
        this.number = number;
        this.content = content;
        this.time = time;
        this.addedbyuser = addedbyuser;
        this.filename = filename;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAddedbyuser(int addedbyuser) {
        this.addedbyuser = addedbyuser;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTopic() {
        return topic;
    }

    public String getNumber() {
        return number;
    }

    public String[] getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public int getAddedbyuser() {
        return addedbyuser;
    }

    public String getFilename() {
        return filename;
    }

    private int addedbyuser;
    private String filename;

    @Override
    public void add(){

    }
    @Override
    public void view(){

    }
}
class lecture_Recordings implements material {
    private String topic;
    private String uploaded_by;
    private String upload_time;
    private String file_name;

    public lecture_Recordings(String topic, String uploaded_by, String upload_time, String file_name) {
        this.topic = topic;
        this.uploaded_by = uploaded_by;
        this.upload_time = upload_time;
        this.file_name = file_name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

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
interface assessment{
    public void add();
    public void view();
    public void submission();
    public void grade();
}
class assignment implements assessment {
    public assignment(String problem_statement, String max_marks, String uploaded_by, String uploaded_time) {
        this.problem_statement = problem_statement;
        this.max_marks = max_marks;
        this.uploaded_by = uploaded_by;
        this.uploaded_time = uploaded_time;
    }

    public String getProblem_statement() {
        return problem_statement;
    }

    public void setProblem_statement(String problem_statement) {
        this.problem_statement = problem_statement;
    }

    public String getMax_marks() {
        return max_marks;
    }

    public void setMax_marks(String max_marks) {
        this.max_marks = max_marks;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getUploaded_time() {
        return uploaded_time;
    }

    public void setUploaded_time(String uploaded_time) {
        this.uploaded_time = uploaded_time;
    }

    private String problem_statement;
    private String max_marks;
    private String uploaded_by;
    private String uploaded_time;

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
class quiz implements assessment {
    public quiz(String uploaded_by, String uploaded_time, String question) {
        this.uploaded_by = uploaded_by;
        this.uploaded_time = uploaded_time;
        this.question = question;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    public String getUploaded_time() {
        return uploaded_time;
    }

    public void setUploaded_time(String uploaded_time) {
        this.uploaded_time = uploaded_time;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private String uploaded_by;
    private String uploaded_time;
    private String question;

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
    public comment(String comment, String uploaded_time, String uploaded_by) {
        this.comment = comment;
        this.uploaded_time = uploaded_time;
        this.uploaded_by = uploaded_by;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUploaded_time() {
        return uploaded_time;
    }

    public void setUploaded_time(String uploaded_time) {
        this.uploaded_time = uploaded_time;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public void setUploaded_by(String uploaded_by) {
        this.uploaded_by = uploaded_by;
    }

    private String comment;
    private String uploaded_time;
    private String uploaded_by;
    Date dateobject = new Date();
    SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
    ArrayList<String> commentsArrayList=new ArrayList<>();
    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter comment: ");
        String comment = sc.nextLine();
        String uploaded_time = date.format(dateobject);
        String uploaded_by = uploadedby;
        
        comments comment_object = new comments(comment , uploaded_by , uploaded_time);
        
        commentsArrayList.add(comment_object);

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

                            //Lecture_Slides slidesobject = new Lecture_Slides();

                            //slidesobject.add();

                        } else if (choiceforlecture == 2) {

                            //lecture_Recordings videosobject = new lecture_Recordings();

                            //videosobject.add();

                        }

                    }
                    else if (choicefortask == 2) {

                        System.out.println("1. Add Assignment\n" +
                                "2. Add Quiz");

                        if (choice == 1) {

                            //assignment assignmentobject = new assignment();

                            //assignmentobject.add();

                        } else if (choice == 2) {


                            //quiz quizobject = new quiz();

                            //quizobject.add();

                        }

                    }

                    else if(choicefortask == 3 ) {

                        //Lecture_Slides slidesobject = new Lecture_Slides();
                        //lecture_Recordings videosobject = new lecture_Recordings();
                        //slidesobject.view();
                        System.out.println("-----------------------------------------");
                        //videosobject.view();

                    }

                    else if(choicefortask == 4 ) {

                        int counter = 0;

                        //assignment assignmentobject = new assignment();
                        //quiz quizobject = new quiz();
                        //assignmentobject.view();
                        System.out.println("-----------------------------------------");
                        //quizobject.view();

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






