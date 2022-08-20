package RightTrianglePattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    private static Connection conn;

    public static void main(String[] args) throws SQLException {

        String url ="jdbc:mysql://localhost:3306/gpasystem";
        String username= "root";
        String password="password";
            try{
                Connection connection =DriverManager.getConnection(url,username,password);
            }catch (SQLException e){
                System.out.println("Error!");
            }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name :");
        String name = sc.nextLine();

        System.out.print("Course duration(in years) :");
        int yea = sc.nextInt();

        if (yea > 0 && yea <= 4) {
            System.out.print("\n\nCongratulations! Registration was completed.\n\n");

            System.out.print("   ----GPA Calculator----\n");

            System.out.print("\n   Hello " + name + ", Welcome back!\n\n");

            System.out.print("        ----Menu----\n" +
                    "       1. View results\n" +
                    "       2. Add results\n" +
                    "       3. Export data\n" +
                    "       4. Clear data\n" +
                    "       5. Exit");

            System.out.print("\n\nEnter your choice: ");
            int choice = sc.nextInt();

            if (choice > 0 && choice <= 5) {
                while (choice != 5) {

                    if(choice == 2){
                        Scanner sc1= new Scanner(System.in);
                        System.out.println("----add result----");

                        System.out.print("Year(1,2,3,4): ");
                        int year = sc1.nextInt();
                        System.out.print("Course code:");
                        String C_code= sc1.nextLine();
                        System.out.print("Grade(A+,A,A-,B+,B,B-,C+,C,C-,D+,D,E): ");
                        String grade =sc1.nextLine();
                        System.out.print("Credits: ");
                        int credit = sc1.nextInt();

                        System.out.print("confirm(y/n): ");
                        String confirm = sc1.nextLine();

                        if(confirm =="y"){
                            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gpasystem");
                            Statement stmt = conn.createStatement();
                            String sql ="INSERT INTO Ressult" + "VALUES('Saman',2019,'SENG 21243','A',2);";
                        }
                    }
                    else if(choice== 1){
                        System.out.print("----view Result----\n\n");
                        float gpa=2.0f;
                        int No_Subjects=5;
                        int credit =10;
                        System.out.println("Current GPA:"+gpa);
                        System.out.println("No. of subjects:" + No_Subjects);
                        System.out.println("Total credits: "+credit);

                        System.out.println("\n\nTo view records:\n" +
                                "1. Year 1\n" +
                                "2. Year 2\n" +
                                "3. Year 3\n" +
                                "4. Year 4\n" +
                                "\n" +
                                "0. Back");

                        Scanner sc2= new Scanner(System.in);

                        System.out.print("Enter your choice: ");
                        int record = sc2.nextInt();
                        break;
                    }

                }
            }
        }
    }
}