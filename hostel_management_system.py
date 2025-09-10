# Hostel Management System in Python
# Student class to hold student details
class Student:
    def __init__(self, name, enroll_no, room_no):
        self.name = name              # Student's name
        self.enroll_no = enroll_no    # Student's enrollment number
        self.room_no = room_no        # Student's room number


# HostelManagementSystem class to manage all student operations
class HostelManagementSystem:
    def __init__(self):
        # List to store all students (like array in Java)
        self.students = []
    
    # Function to add a student
    def add_student(self):
        name = input("Enter Name: ")
        enroll_no = input("Enter Enrollment Number: ")
        room_no = input("Enter Room No: ")
        
        # Create a new student object and add it to the list
        student = Student(name, enroll_no, room_no)
        self.students.append(student)
        
        print("Student Added Successfully!")

    # Function to view all students
    def view_students(self):
        if len(self.students) == 0:
            print("No Students Found!")
            return
        
        print("\n--- Student List ---")
        for idx, student in enumerate(self.students, start=1):
            print(f"{idx}. Name: {student.name}, Enroll: {student.enroll_no}, Room: {student.room_no}")

    # Function to search a student by enrollment number
    def search_student(self):
        enroll_no = input("Enter Enrollment No to Search: ")
        found = False
        
        for idx, student in enumerate(self.students, start=1):
            if student.enroll_no == enroll_no:
                print("Student Found:")
                print(f"{idx}. Name: {student.name}, Enroll: {student.enroll_no}, Room: {student.room_no}")
                found = True
                break
        
        if not found:
            print("Student Not Found!")

    # Function to update student details
    def update_student(self):
        enroll_no = input("Enter Enrollment No to Update: ")
        found = False
        
        for student in self.students:
            if student.enroll_no == enroll_no:
                student.name = input("Enter New Name: ")
                student.room_no = input("Enter New Room No: ")
                print("Student Information Updated Successfully!")
                found = True
                break
        
        if not found:
            print("Student Not Found!")

    # Function to delete student by enrollment number
    def delete_student(self):
        enroll_no = input("Enter Enrollment No to Delete: ")
        found = False
        
        for i, student in enumerate(self.students):
            if student.enroll_no == enroll_no:
                self.students.pop(i)  # Remove student from list
                print("Student Deleted Successfully!")
                found = True
                break
        
        if not found:
            print("Student Not Found!")

    # Function to show total students
    def total_students(self):
        if len(self.students) == 0:
            print("No Students in Hostel Now")
        else:
            print(f"Total Students: {len(self.students)}")

    # Main menu loop (like while(true) in Java)
    def run(self):
        while True:
            print("\n==== Hostel Management System ====")
            print("1. Add Student")
            print("2. View Students")
            print("3. Search Student")
            print("4. Update Student")
            print("5. Delete Student")
            print("6. Total Students in Hostel")
            print("7. Exit")
            
            try:
                option = int(input("Choose an option: "))
            except ValueError:
                print("Invalid input! Please enter a number.")
                continue
            
            if option == 1:
                self.add_student()
            elif option == 2:
                self.view_students()
            elif option == 3:
                self.search_student()
            elif option == 4:
                self.update_student()
            elif option == 5:
                self.delete_student()
            elif option == 6:
                self.total_students()
            elif option == 7:
                print("Exiting Hostel Management System...")
                break
            else:
                print("Invalid Option! Please Try Again.")


# Run the system
if __name__ == "__main__":
    system = HostelManagementSystem()
    system.run()