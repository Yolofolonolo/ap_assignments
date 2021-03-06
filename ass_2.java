import java.util.regex.Pattern;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;
import javax.print.DocFlavor.STRING;
// import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
import java.util.regex.Pattern;
import java.util.*;

class Lecture_Slides implements material{
    private String topic;
    private String number;
    private String [] content;
    private Date time;
    private String uploaded_by;

    public Lecture_Slides () {}

    public Lecture_Slides(String topic, String number, String [] content , String uploaded_by , Date uploaded_time) {
        this.topic = topic;
        this.number = number;
        this.content = content;
        this.uploaded_by = uploaded_by;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setContent(String [] content) {
        this.content = content;
    }

    public void setUploaded_by(String uploadedby) {
        this.uploaded_by = uploadedby;
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

    public String [] getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }

    public String getUploaded_by() {
        return uploaded_by;
    }

    public String getFilename() {
        return filename;
    }

    
    private String filename;

    Date dateobject = new Date();
    SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
    static ArrayList<Lecture_Slides> slidesArrayList=new ArrayList<>();
    private String uploaded_time;
    int intnumber;
    @Override
    public void add(String uploadedby){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter topic of slides: ");
        String topic = sc.nextLine();
        System.out.print("enter number of slides: ");
        String number = sc.nextLine();
        intnumber=Integer.parseInt(number);
        String [] content = new String[intnumber];
        for (int i = 0 ; i < intnumber ; i++){
            System.out.print("Content of slide " + (i + 1) + ": ");
            content[i] = sc.nextLine();
        }
        Date uploaded_time = java.util.Calendar.getInstance().getTime();
        String uploaded_by = uploadedby;
        System.out.print(uploaded_time);

        Lecture_Slides slides_object = new Lecture_Slides(topic, number, content , uploaded_by , uploaded_time);

        slidesArrayList.add(slides_object);
        
    }
    @Override
    public void view(){
        for (int i = 0 ; i < slidesArrayList.size() ; i++) {
            System.out.println(slidesArrayList.get(i).topic + " - " + slidesArrayList.get(i).getUploaded_by());
            System.out.println(slidesArrayList.get(i).uploaded_time);
            for (int k = 0; k< slidesArrayList.get(i).intnumber ; k++) {
                System.out.println("Slide: " + (k+1)  + ": " + slidesArrayList.get(i).content[k]);
            }
                                                                


        }

    }
}
class lecture_Recordings implements material {
    private String topic;
    private String uploaded_by;
    private Date upload_time;
    private String file_name;

    public lecture_Recordings() { }

    public lecture_Recordings(String topic, String uploaded_by, Date upload_time, String file_name) {
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


    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
    Date dateobject = new Date();
    SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
    static ArrayList<lecture_Recordings> recordingArrayList=new ArrayList<>();
    public boolean checkfile_name(String file_name){
        return file_name.substring(file_name.length()-4).equals(".mp4");
    }
    @Override
    public void add(String uploadedby){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter topic of recording");
        String topic = sc.nextLine();
        System.out.print("enter filename of recording");
        String file_name = sc.nextLine();
        if (!checkfile_name(file_name)){
            System.out.print("invalid");
            return;
        }
        Date uploaded_time = java.util.Calendar.getInstance().getTime();
        String uploaded_by = uploadedby;
        System.out.print(uploaded_time);

        lecture_Recordings obj = new lecture_Recordings(topic, uploaded_by, upload_time, file_name);
        // String[] arr = {topic, file_name, uploaded_time, uploadedby};
        lecture_Recordings.recordingArrayList.add(obj);

    }
    @Override
    public void view(){
        for (int i = 0 ; i < recordingArrayList.size() ; i++) {
            System.out.println(recordingArrayList.get(i).topic + " - " + recordingArrayList.get(i).getUploaded_by());
            System.out.println(recordingArrayList.get(i).upload_time);
            System.out.println(recordingArrayList.get(i).file_name);
        }
    }
}
interface material{
    public void add(String uploadedby);
    public void view();
}
interface assessment{
    public void submission();
    public void grade();
}
class Submission{
    private final String answer;
    private  float grade;
    private final String student;
    private instructor inst;
    Submission(String s, String ans){
        student = s;
        answer = ans;



    }
    public void setGrade(instructor i, float marks){
        grade = marks;
        inst = i;

    }


}
class assignment implements assessment, material {
    Scanner sc = new Scanner(System.in);
    ArrayList<Submission> submissions = new ArrayList<>();
    public assignment(String problem_statement, String max_marks , String uploaded_by ,Date uploaded_time ) {
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

    public Date getUploaded_time() {
        return uploaded_time;
    }

    public void setUploaded_time(Date uploaded_time) {
        this.uploaded_time = uploaded_time;
    }

    private String problem_statement;
    private String max_marks;
    private String uploaded_by;
    private Date uploaded_time;

    
    public void submission(String student_id) {
        System.out.println("Enter filename of assignment: ");
        String answer = sc.next();
        submissions.add(new Submission(student_id, answer));



    }



    @Override
    public void grade() {


    }
    Date dateobject = new Date();
    SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
    static ArrayList<assignment> assArrayList=new ArrayList<>();
    @Override
    public void add(String uploadedby) {
        Scanner scs = new Scanner(System.in);
        System.out.print("Enter problem statement: ");
        String problem_statement = scs.nextLine();
        System.out.print("Enter max marks: ");
        String max_marks = scs.nextLine();
        Date uploaded_time = java.util.Calendar.getInstance().getTime();
        String uploaded_by = uploadedby;
        System.out.print(uploaded_time);
        
        assignment assignment_object = new assignment(problem_statement, max_marks , uploaded_by , uploaded_time);
        assArrayList.add(assignment_object);
    }
    public void view() {
        for (int i = 0 ; i < assArrayList.size() ; i++) {
            System.out.println(assArrayList.get(i).problem_statement + " - " + assArrayList.get(i).getUploaded_by());
            System.out.println(assArrayList.get(i).uploaded_time);
            System.out.println(assArrayList.get(i).max_marks);
        }

    }
}
class quiz implements assessment, material {
    public quiz(String uploaded_by, Date uploaded_time, String question) {
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

    public Date getUploaded_time() {
        return uploaded_time;
    }

    public void setUploaded_time(Date uploaded_time) {
        this.uploaded_time = uploaded_time;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private String uploaded_by;
    private Date uploaded_time;
    private String question;

    Date dateobject = new Date();
    SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
    static ArrayList<quiz> quizzArrayList=new ArrayList<>();
    public void add(String uploadedby) {
        Scanner scs = new Scanner(System.in);
        System.out.print("Enter question: ");
        String question = scs.nextLine();
        //String uploaded_time = date.format(dateobject);
        Date uploaded_time = java.util.Calendar.getInstance().getTime();
        String uploaded_by = uploadedby;
        System.out.print(uploaded_time);
        quiz quiz_object = new quiz(question, uploaded_time , uploaded_by);
        quizzArrayList.add(quiz_object);
    }

    public void view() {
        for (int i = 0 ; i < quizzArrayList.size() ; i++) {
            System.out.println(quizzArrayList.get(i).question + " - " + quizzArrayList.get(i).getUploaded_by());
            System.out.println(quizzArrayList.get(i).uploaded_time);
        }
    }

    @Override
    public void submission() {


    }

    @Override
    public void grade() {


    }

}
class instructor {

    final static ArrayList <String> instructorID = new ArrayList<> ();

    public static void TryInstructorID(String instructor_id) {
        

        String [] id = {"I0" , "I1"};
    
        instructorID.add(id[0]);
        instructorID.add(id[1]);


    
        int instryuctorIDINT=Integer.parseInt(instructor_id);


    
        System.out.println("Welcome " + id[instryuctorIDINT]);

        }

    public static void close_assessment() {
    }
}
class student{

    final static ArrayList <String> studentID = new ArrayList<> ();
    private final ArrayList<Submission> submissions = new ArrayList<>();

    public static void TryStudentID(String student_ID) {
        

        String [] id = {"I0" , "I1"};
    
        studentID.add(id[0]);
        studentID.add(id[1]);

    
        int instryuctorIDINT=Integer.parseInt(student_ID);
    
        System.out.println("Welcome " + id[instryuctorIDINT]);

        }

}
class comment implements material{
    public comment(String comments, String uploaded_by, String uploaded_time) {
        this.comments = comments;
        this.uploaded_time = uploaded_time;
        this.uploaded_by = uploaded_by;
    }

    public String getComment() {
        return comments;
    }

    public void setComment(String comment) {
        this.comments = comment;
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

    private String comments;
    private String uploaded_time;
    private String uploaded_by;
    Date dateobject = new Date();
    SimpleDateFormat date = new SimpleDateFormat("E,dd MM yyyy HH:mm:ss z");
    static ArrayList<comment> commentsArrayList=new ArrayList<>();
    @Override
    public void add(String uploadedby) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter comment: ");
        String comments = sc.nextLine();
        String uploaded_time = date.format(dateobject);
        String uploaded_by = uploadedby;

        comment comment_object = new comment(comments , uploaded_by , uploaded_time);
        commentsArrayList.add(comment_object);

    }

    @Override
    public void view() {
        System.out.println(commentsArrayList.size());
        for (int i = 0 ; i < commentsArrayList.size() ; i++) {
            
            System.out.println(commentsArrayList.get(i).comments + " - " + commentsArrayList.get(i).getUploaded_by());
            System.out.println(commentsArrayList.get(i).uploaded_time);

        }
    }
}
class backpack {
    //arraylist for all the classes
    static Scanner sc = new Scanner(System.in);

    public static String instructor_id;

    static String student_id;

    public static void funciton () {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to Backpack.");
            System.out.println("1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");

            System.out.print("Enter your choice. ");

            int choice = sc.nextInt();

            if (choice == 1) {
                sc.nextLine();
                System.out.println("Instructors:\n" +
                        "0 - I0\n" +
                        "1 - I1");

                System.out.print("Enter instructor ID. ");
                instructor_id = sc.nextLine();

                instructor.TryInstructorID(instructor_id);

                while (true) {

                    instructor.TryInstructorID(instructor_id);

                    displayinstructor();

                    System.out.print("Enter the number for the task you want to perform. ");

                    int choicefortask = sc.nextInt();

                    if (choicefortask == 1) {

                        System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");

                        int choiceforlecture = sc.nextInt();

                        if (choiceforlecture == 1) {

                            Lecture_Slides slidesobject = new Lecture_Slides();
                            slidesobject.add(instructor_id);

                        } else if (choiceforlecture == 2) {

                            lecture_Recordings videosobject = new lecture_Recordings();

                            videosobject.add(instructor_id);
                        }

                    }
                    else if (choicefortask == 2) {

                        System.out.println("1. Add Assignment\n" +
                                "2. Add Quiz");

                        System.out.print("Enter your choice. ");

                        choice = sc.nextInt();


                        if (choice == 1) {

                            assignment assignmentobject = new assignment(instructor_id, instructor_id, instructor_id, null);

                            assignmentobject.add(instructor_id);

                        } else if (choice == 2) {


                            quiz quizobject = new quiz(instructor_id, null, instructor_id);

                            quizobject.add(instructor_id);

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

                        assignment assignmentobject = new assignment(instructor_id, instructor_id, instructor_id, null);
                        quiz quizobject = new quiz(instructor_id, null, instructor_id);
                        assignmentobject.view();
                        System.out.println("-----------------------------------------");
                        quizobject.view();

                    }

                    else if(choicefortask == 5) {
                        System.out.println("grade assignments");
                    }

                    else if(choicefortask == 6 ) {

                        instructor.close_assessment();

                    }

                    else if(choicefortask == 7) {
                        comment commentObject = new comment(instructor_id, instructor_id, instructor_id);
                        commentObject.view();
                    }

                    else if(choicefortask == 8) {

                        comment commentObject = new comment(instructor_id, instructor_id, instructor_id);
                        commentObject.add(instructor_id);

                    }

                    else if(choicefortask==9) {
                        break;
                    }

                }


//            displayInstructor();

            }

            else if (choice == 2) {

                System.out.println("Students:\n" +
                        "0 - S0\n" +
                        "1 - S1\n" +
                        "2 - S2");
                sc.nextLine();
                System.out.println("Choose the student id. ");

                student_id = sc.nextLine();
                student stobj = new student();
                stobj.TryStudentID(student_id);

                while (true) {

                    //A2.student.TryStudentID(student_id);

                    displaystudent();

                    System.out.print("Enter the number for the task you want to perform. ");

                    int choicefortask = sc.nextInt();

                    if(choicefortask == 1){

                        Lecture_Slides slidesobject = new Lecture_Slides();
                        lecture_Recordings videosobject = new lecture_Recordings();

                        slidesobject.view();

                        System.out.println("-----------------------------------------");

                        videosobject.view();


                    }

                    else if (choicefortask == 2) {

                        int counter = 0;

                        assignment assignmentobject = new assignment(instructor_id, instructor_id, instructor_id, null);
                        quiz quizobject = new quiz(instructor_id, null, instructor_id);
                        assignmentobject.view();
                        System.out.println("-----------------------------------------");
                        quizobject.view();

                    }
                    else if(choicefortask == 3 ) {
                        //A2.student student_object = new student();
                        //student_object.submitAssessment(student_id);
                        System.out.println("Pending Assessments: ");
                        for(int i = 0; i < assignment.assArrayList.size(); i++){
                            System.out.print("ID " + i);
                            System.out.println(assignment.assArrayList.get(i));
                        }
                        int choice1  = sc.nextInt();
                        assignment.assArrayList.get(choice1).submission();


                    }
                    else if(choicefortask == 4) {
                        System.out.println("view grades");
                    }
                    else if(choicefortask == 5 ) {

                        comment commentObject = new comment(instructor_id, instructor_id, instructor_id);
                        commentObject.view();
                    }
                    else if(choicefortask == 6 ) {

                        comment commentObject = new comment(instructor_id, instructor_id, instructor_id);
                        commentObject.add(instructor_id);

                    }
                    else if(choicefortask == 7) {
                        break;
                    }
                }
            }

            else if (choice == 3) {
                break;
            }
        }
    }

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


//    ArrayList <videos> lecturesvideo = new ArrayList<>();

//    ArrayList <assignments> assignmentlist = new ArrayList<>();

//    ArrayList <quizzes> quizzeslist = new ArrayList<>();

    ArrayList <String> instructors = new ArrayList<>();

    static ArrayList <String> student = new ArrayList<>();
}
class Appp {    
    public static void main(String[] args){
        backpack.funciton();
    }

}








