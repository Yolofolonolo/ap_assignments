import java.util.ArrayList;
import java.util.*;

class Citizen {
    private String Name;
    private int age;
    private long UniqueID;
    private int isVaccinated;
    private ArrayList<Slot> vaccineSlot;

    public Citizen(String name,int age,long UniqueID){
        this.Name = name;
        this.age = age;
        this.UniqueID = UniqueID;
        isVaccinated = 0;
        this.vaccineSlot = new ArrayList<Slot>();
    }

    public String VaccinationStatus(){//checks
        if(vaccineSlot.size()==0){
            return "NOT VACCINATED";
        }

        if(vaccineSlot.get(0).getNumberOfDoses()==vaccineSlot.size()){
            return "FULLY VACCINATED";
        }else if(vaccineSlot.size()==0){
            return "NOT VACCINATED";
        }else if(vaccineSlot.get(0).getNumberOfDoses()>vaccineSlot.size()){
            return "PARTIALLY VACCINATED";
        }

        return "ERROR";
    }

    public void addSlot(Slot s){
        boolean flag = false;
        vaccineSlot.add(s);
        flag = checkVaccineSlot();

        if(flag){
            vaccineSlot.remove(vaccineSlot.get(vaccineSlot.size()-1));
        }
    }

    public boolean checkVaccineSlot(){

        if(vaccineSlot.size()==0){
            return true;
        }
        //if the vaccine applied is different than the first one

        for(int i=0;i<vaccineSlot.size();i++){

            if(!vaccineSlot.get(i).getVaccine().getName().equals(vaccineSlot.get(0).getVaccine().getName())){
                System.out.println("Cant take different vaccines");
                return false;
            }
        }

        //if the next dose is taken before completing the gap period

        int day;
        day = vaccineSlot.get(0).getDay();
        for(int i=0;i<vaccineSlot.size()-1;i++){
            if(day+vaccineSlot.get(i).getVaccine().getGap()>vaccineSlot.get(i+1).getDay()){
                System.out.println("Wait for the specified gap between two doses");
                return false;
            }
        }

        //if the vaccine doses have exceeded the required number of doses
        if(vaccineSlot.size()>vaccineSlot.get(0).getNumberOfDoses()){
            System.out.println("You have completed the required number of doses");
            return false;
        }

        return true;
    }

    public void gotDose() {
        if(isVaccinated>=2){
            return;
        }

        isVaccinated++;
    }


    public String getName() {
        return Name;
    }

    public long getUniqueID() {
        return UniqueID;
    }

    public int getAge() {
        return age;
    }
}

class Data {
    private ArrayList<Vaccine> vaccineList;
    private ArrayList<Hospital> hospitalList;
    private ArrayList<Citizen> citizenList;

    Data(){
        vaccineList = new ArrayList<Vaccine>();
        hospitalList = new ArrayList<Hospital>();
        citizenList = new ArrayList<Citizen>();
    }

    public ArrayList<Citizen> getCitizenList() {
        return citizenList;
    }

    public ArrayList<Hospital> getHospitalList() {
        return hospitalList;
    }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void addVaccine(Scanner sc){



        //Input Taking

        System.out.println("Enter the Name : ");
        String Name = sc.next();
        //Error Handling
        for(int i=0;i<vaccineList.size();i++){
            if(vaccineList.get(i).getName().equals(Name)){
                System.out.println("This Vaccine is Already Registered");
                return;
            }
        }

            System.out.println("Number of Doses : ");
            int numberOfDoses = sc.nextInt();
            int gap =0;
            if(numberOfDoses > 1)
            {
                System.out.println("Gap between Doses : ");
                gap = sc.nextInt();
            }
        //Add Vaccine to the List
        Vaccine vaccine = new Vaccine(Name,gap,numberOfDoses);
        setVaccineList(vaccine);

        //Input confirmation
        System.out.println("Vaccine Name: "+vaccine.getName()+", Number of Doses: "+vaccine.getNumberD()+", Gap Between Doses: "+vaccine.getGap());
    }

    public void addHospital(Scanner sc, int hID){

        //Input Taking
        System.out.println("Enter the Name : ");
        String Name = sc.next();

        System.out.println("PinCode : ");
        String pinCode = sc.next();

        //Error Handling
        for(int i=0;i<hospitalList.size();i++){
            if(hospitalList.get(i).getName().equals(Name)&&hospitalList.get(i).getPinCode().equals(pinCode)){
                System.out.println("This Hospital is Already Registered");
                return;
            }
        }

        //Add Hospital to the List
        Hospital hospital = new Hospital(Name,pinCode, hID);
        setHospitalList(hospital);

        //Input confirmation
        System.out.println("Hospital Name: "+hospital.getName()+", PinCode: "+hospital.getPinCode()+", Unique ID:  "+hospital.getUniqueID());
    }

    public void addCitizen(Scanner sc){

        //Input Taking
        System.out.println("Enter the Name : ");
        String Name = sc.next();
        System.out.println("Age : ");
        int age = sc.nextInt();
        System.out.println("UniqueID : ");
        long UniqueID = sc.nextLong();

        for(int i=0;i<citizenList.size();i++){
            if(citizenList.get(i).getUniqueID()==(UniqueID)){
                System.out.println("This Citizen is Already Registered");
                return;
            }
        }

        boolean ageCheck = false;

        ageCheck = age>=18? true : false;

        if(ageCheck) {
            //Add Citizen to the List
            Citizen citizen = new Citizen(Name, age, UniqueID);
            setCitizenList(citizen);
            //Input confirmation
            System.out.println("Name: "+citizen.getName()+", Age: "+citizen.getAge()+", Unique ID:  "+citizen.getUniqueID());
        }else{
            //printing data
            Citizen citizen = new Citizen(Name, age, UniqueID);
            System.out.println("Name: "+citizen.getName()+", Age: "+citizen.getAge()+", Unique ID:  "+citizen.getUniqueID());
            System.out.println("Only above 18 are allowed");
        }

    }

    public Hospital findHospital(Scanner sc){
        System.out.println("Enter Hospital ID : ");
        int UniqueID = sc.nextInt();


        for(int i=0;i<hospitalList.size();i++){
            if(hospitalList.get(i).getUniqueID()==(UniqueID)){
                return hospitalList.get(i);

            }
        }

        return null;

    }

    public Citizen findCitizen(Scanner sc){
        System.out.println("Enter UniqueID : ");
        int UniqueID = sc.nextInt();


        for(int i=0;i<citizenList.size();i++){
            if(citizenList.get(i).getUniqueID()==(UniqueID)){
                return citizenList.get(i);

            }
        }

        return null;

    }

    private void setCitizenList(Citizen c) {
        this.citizenList.add(c);
    }

    private void setHospitalList(Hospital h) {
        this.hospitalList.add(h);
    }

    private void setVaccineList(Vaccine v) {
        this.vaccineList.add(v);
    }


}


class Hospital {
    private String Name;
    private int uniqueID;
    private String pinCode;
    private ArrayList<Slot> slots ;

    Hospital(String name,String pinCode, int ID){
        this.Name = name;
        this.pinCode = pinCode;

        //generate unique hospital id
        this.uniqueID = ID; //for loop lagana hai

        //initializing slot array
        this.slots = new ArrayList<Slot>();
    }

    public void addSlot(Scanner sc,Data data){
        //Taking Input
        System.out.println("Enter the Number of Slots to be added : ");
        int slotCount = sc.nextInt();
        while(slotCount-- > 0)
        {   
            System.out.println("Day Number : ");
            int dayNumber = sc.nextInt();

            System.out.println("Quantity : ");
            int quantity = sc.nextInt();

            System.out.println("Select The Vaccine : ");

            for(int i=0;i<data.getVaccineList().size();i++){
                Vaccine temp = data.getVaccineList().get(i);
                System.out.println(i + ". " + temp.getName());
            }

            int vaccineIndex = sc.nextInt();

            if(vaccineIndex>data.getVaccineList().size()){
                System.out.println("Invalid Choice");
                return;
            }

                //Initializing slot
            Slot slot = new Slot(dayNumber,quantity,data.getVaccineList().get(vaccineIndex));
            slots.add(slot);
            System.out.println(slot.getDay());
            
            //Confirmation
            System.out.println("Slot added by Hospital : "+ this.uniqueID +", for Day: "+dayNumber+", Available Quantity: "+quantity+" of Vaccine : "+data.getVaccineList().get(vaccineIndex).getName());
        }
    }

    public String getName() {
        return Name;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void listSlots() {
        System.out.println(slots.size());
        if(slots.size()==0){
            System.out.println("No slots available");
            return;
        }

        for(int i=0;i< slots.size();i++){
            Slot temp = slots.get(i);
            System.out.println("Day: " + temp.getDay() + " Vaccine: " +temp.getVaccine().getName()+ "Available Qty: " + temp.getNumberOfDoses());
        }
    }

    public void bookSlot(Scanner sc,Citizen citizen){
        this.listSlots();
        System.out.println("Select your choice");
        int choiceIndex = sc.nextInt();

        //adding the slot to citizen class
        citizen.addSlot(slots.get(choiceIndex));

        //reducing quantity
        slots.get(choiceIndex).setNumberOfDoses(slots.get(choiceIndex).getNumberOfDoses()-1);

        //removing slots that have finished
        if(slots.get(choiceIndex).getNumberOfDoses()==0){
            slots.remove(choiceIndex);
        }

    }
}

class Vaccine {
    private String Name;
    private int gap;
    private int numberD;

    public Vaccine(String name,int gap,int number) {
        this.Name = name;
        this.gap = gap;
        this.numberD = number;
    }

    public String getName() {
        return Name;
    }

    public int getGap() {
        return gap;
    }

    public int getNumberD() {
        return numberD;
    }
}

class Slot {
    private int day;
    private int numberOfDoses;
    private Vaccine vaccine;


    Slot(int day,int numberOfDoses,Vaccine vaccine){
        this.day = day;
        this.numberOfDoses = numberOfDoses;
        this.vaccine = vaccine;

    }



    public int getDay() {
        return day;
    }

    public int getNumberOfDoses() {
        return numberOfDoses;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setNumberOfDoses(int val){
        this.numberOfDoses = val;
    }
}

class Cowin {

    static Data data = new Data();
    static int hospID = 100000;
    static String menu = "CoWin Portal initialized....\n" +
            "---------------------------------\n" +
            "1. Add Vaccine\n" +
            "2. Register Hospital\n" +
            "3. Register Citizen\n" +
            "4. Add Slot for Vaccination\n" +
            "5. Book Slot for Vaccination\n" +
            "6. List all slots for a hospital\n" +
            "7. Check Vaccination Status\n" +
            "8. Exit\n" +
            "---------------------------------";

    private static void printMenu(){
        System.out.println(menu);
    }

    private static void takeInput(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            printMenu();
            int n = sc.nextInt();

            if (n == 1) {
                addVaccine(sc);
            } else if (n == 2) {
                registerHospital(sc, hospID++);
            } else if (n == 3) {
                registerCitizen(sc);
            } else if (n == 4) {
                addSlot(sc);
            } else if (n == 5) {
                bookSlot(sc);
            } else if (n == 6) {
                listSlots(sc);
            } else if (n == 7) {
                checkVaccinationStatus(sc);
            } else if (n == 8) {
                break;
            }else{
                System.out.println("Invalid Input");
            }
        }
    }

    private static void addVaccine(Scanner sc){
        data.addVaccine(sc);
        return;
    }

    private static void registerHospital(Scanner sc, int hID){
        data.addHospital(sc, hID);
        return;
    }

    private static void registerCitizen(Scanner sc){
        data.addCitizen(sc);
        return;
    }

    private static void addSlot(Scanner sc){

        Hospital temp = data.findHospital(sc);

        if(temp==null){
            System.out.println("No such hospital entry found");
            return;
        }else {
            temp.addSlot(sc,data);
        }

        return;
    }

    private static void bookSlot(Scanner sc){
        //find citizen
        Citizen c = data.findCitizen(sc);
        if(c==null){
            System.out.println("Citizen Not Found");
        }
        //find hospital

        //criteria for finding hospital
        System.out.println("1. Search by area\n" +
                           "2. Search by Vaccine\n" +
                           "3. Exit");
        int verbose = sc.nextInt();
        if(verbose==1){
            //search by area
        }else if(verbose==2){
            //search by vaccine
        }else if(verbose==3){
            return;
        }else{
            System.out.println("Invalid Input");
        }
        //this is temporary h we will form new in verbose parts
        Hospital h = data.findHospital(sc);
        if(h==null){
            System.out.println("Hospital Not Found");
        }
        h.bookSlot(sc,c);
        return;
    }

    private static void listSlots(Scanner sc){
        Hospital temp = data.findHospital(sc);
        if(temp==null){
            System.out.println("No such hospital found");
            return;
        }else{
            temp.listSlots();
        }

    }

    private static void checkVaccinationStatus(Scanner sc){
        Citizen c = data.findCitizen(sc);
        if(c==null){
            System.out.println("ID not found");
        }else {
            c.VaccinationStatus();
        }
        return;
    }

    public static void start(){


        takeInput();
    }

}


public class Appp {
    public static void main(String[] args){
        Cowin.start();
    }
}



