import java.util.Scanner;

class Student {
    String name;
    String EnrollNo;
    String RoomNo;

    public Student(String name, String EnrollNo, String RoomNo){
        this.name = name;
        this.EnrollNo = EnrollNo;
        this.RoomNo = RoomNo;
    }
}

public class HostelManagementSystem{
    static Student[] students = new Student[100];
    static int Studentscount = 0;
    static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args){
        while(true){
            System.out.println("\n==== Hostel Management System ====");
            System.out.println("1. Add Student ");
            System.out.println("2. Vew Student ");
            System.out.println("3. Search Student ");
            System.out.println("4. Update Student ");
            System.out.println("5. Delete Student ");
            System.out.println("6. Total Student In Hostel ");
            System.out.println("7. Exit ");
            System.out.println("Choose an option:   ");

            int option = Sc.nextInt();
            Sc.nextLine();

            switch(option){
                case 1: AddStudent(); break;
                case 2: ViewStudent(); break;
                case 3: SearchStudent(); break;
                case 4: UpdateStudent(); break;
                case 5: DeleteStudent(); break;
                case 6: TotalStudent(); break;
                case 7:
                System.out.println("Existing hostel Management System...");
                return;
                default:
                System.out.println("Invalid Option! Please Try Again.");
                

            }
        }
    }

    public static void AddStudent(){
        System.out.print("Enter Name: ");
        String name = Sc.nextLine();
        System.out.print("Enter Enrollment Number: ");
        String enroll = Sc.nextLine();
        System.out.print("Enter Room No: ");
        String room = Sc.nextLine();

        students[Studentscount++] = new Student(name, enroll, room);
        System.out.println("Students Added Successfully!");
    }

    public static void ViewStudent(){
        if(Studentscount == 0){
            System.out.println(" No Students Found!");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (int i = 0; i <Studentscount; i++){
            System.out.println((i+1) +". Name: " + students[i].name + ", Enroll: " + students[i].EnrollNo + ", Room: " + students[i].RoomNo);

        }
    }

    public static void SearchStudent(){
        System.out.print("Enter Enrollment No to Search: ");
        String enroll = Sc.nextLine();
        boolean found = false;

        for(int i=0; i<Studentscount; i++){
            if(students[i].EnrollNo.equals(enroll)){
                System.out.println("Students Found: ");
                System.out.println((i+1) +". Name: " + students[i].name + ", Enroll: " + students[i].EnrollNo + ", Room: " + students[i].RoomNo);
                break;
            }
        }
        if(!found){
            System.out.println("Student Not FOund!");
        }
    }

    public static void UpdateStudent(){
        System.out.print("Enter Enrollment No to Update: ");
        String enroll = Sc.nextLine();
        boolean found =  false;

        for(int i =0; i<Studentscount; i++){
            if(students[i].EnrollNo.equals(enroll)){
                System.out.print("Enter New Name: ");
                students[i].name = Sc.nextLine();
                System.out.println("Enter New Room No: ");
                students[i].RoomNo = Sc.nextLine();
                System.out.println("Student Information Updated Successfully!");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println(" Student not found!");
        }
    }

    public static void DeleteStudent(){
        System.out.print("Enter Enrollment No to Delete: ");
        String enroll = Sc.nextLine();
        boolean found = false;

        for(int i=0; i<Studentscount; i++){
            if(students[i].EnrollNo.equals(enroll)){

                for(int j=i; j<Studentscount - 1; j++){
                    students[j] = students[j + 1];
                }
                Studentscount--;
                System.out.println(" Student Deleted Successfully!");
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println(" Student Not FOund!");
        }
    }

    public static void TotalStudent(){
        if(Studentscount==0){
            System.out.println("No Students in Hostel Now");
            return;
        }
        System.out.println("Total Student: " + Studentscount);
    }
}
