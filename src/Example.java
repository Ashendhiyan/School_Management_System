import java.util.*;
class Example{
    public static void clearconsole(){
        try{
            final String os = System.getProperty("os.name");
            if(os.contains("Windows")){
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }catch(final Exception e){
            e.printStackTrace();
        }
    }
    public static boolean searchElement(String [][]ar,String Id){
        for (int i = 0; i < ar[0].length; i++){
            if(ar[0][i].equals(Id)){
                return true;
            }
        }
        return false;
    }
    public static String[][] pushToArray(String[][] ar,String Id,String Name){
        String[][] tempArray=new String[2][ar[0].length+1];
        for (int i = 0; i < ar[0].length; i++){
            tempArray[0][i]=ar[0][i];
            tempArray[1][i]=ar[1][i];
        }
        tempArray[0][tempArray[0].length-1]=Id;
        tempArray[1][tempArray[0].length-1]=Name;
        return tempArray;
    }
    public static double[][] getMarks(double[][] marks){
        Scanner in=new Scanner(System.in);
        System.out.print("Programming Fundamentals Marks : ");
        int prf=in.nextInt();
        while(prf<0 || prf>100){
            System.out.println("Invalid Marks, Please enter correct marks..");
            System.out.println();
            System.out.print("Programming Fundamentals Marks : ");
                    prf=in.nextInt();
        }
        System.out.print("Database management System marks : ");
        int dbms=in.nextInt();
        while(dbms<0 || dbms>100){
            System.out.println("Invalid Marks, Please enter correct marks..");
            System.out.println();
            System.out.print("Database management System marks : ");
            dbms=in.nextInt();
        }
        return marks=addMarksForStudent(marks,prf,dbms);
    }
    public static double[][] addMarksForStudent(double[][] marks,double prf,double dbms){
        double[][] tempArray=new double[2][marks[0].length+1];
        for (int i = 0; i < marks[0].length; i++){
            tempArray[0][i]=marks[0][i];
            tempArray[1][i]=marks[1][i];
        }
        tempArray[0][tempArray[0].length-1]=prf;
        tempArray[1][tempArray[0].length-1]=dbms;
        return tempArray;
    }
    public static int searchIdElimentIndex(String[][] ar,String Id){
        int eIndex=-50;
        for(int i = 0; i < ar[0].length; i++){
            if(ar[0][i].equals(Id)){
                eIndex=i;
            }
        }
        return eIndex;
    }
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        while(true){
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                    System.out.println("|\t\t\t\t\tWELCOME TO GDSE MARKS MANAGMENT SYSTEM\t\t\t\t\t |");
                            System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                    System.out.println();
            System.out.print("[1] Add New Student");
            System.out.println("\t\t\t\t[2] Add New Student With Marks");
            System.out.print("[3] Add Marks");
            System.out.println("\t\t\t\t\t[4] Update Student Details");
            System.out.print("[5] Update Marks");
            System.out.println("\t\t\t\t[6] Delete Students");
            System.out.print("[7] Print Student Details");
            System.out.println("\t\t\t[8] Print Student Ranks");
            System.out.print("[9] Best in Programming Fundamentals");
            System.out.println("\t\t[10] Best in Database Managment System");
            System.out.println();
            String[][] ar=new String[2][0];
            double[][] marks=new double[2][0];
            String Id="ID";
            String Name="Name";
            char answer='a';
            int x=0;
            while(x==0){
                System.out.print("Enter an option to continue > ");
                int option=in.nextInt();
                switch(option){
                    case 1: do{
                        if(option!=0){
                            clearconsole();
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\t\tADD NEW STUDENT\t\t\t\t\t\t\t|");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        do{
                            System.out.print("Enter Student ID : ");
                            Id=in.next();
                            boolean isDuplicate=searchElement(ar,Id);
                            while(isDuplicate){
                                System.out.println("The Student ID already exists");
                                System.out.println();
                                System.out.print("Enter Student ID : ");
                                Id=in.next();
                                isDuplicate=searchElement(ar,Id);
                            }
                            System.out.print("Enter Student Name : ");
                            Name=in.next();
                            ar=pushToArray(ar,Id,Name);
                            marks=addMarksForStudent(marks,-5,-5);
                            System.out.println();
                            System.out.print("Student has benn added successfully. Do you want to add a new student(y/n) : ");
                            answer=in.next().charAt(0);
                            clearconsole();
                            break;
                        }while(answer =='n' || answer == 'N');
                        x=1;
                    }while(answer=='y'||answer=='Y');
                        break;
                    case 2: do{
                        if(option!=0){
                            clearconsole();
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\tADD NEW STUDENT WITH MARKS\t\t\t\t\t\t |");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        do{
                            System.out.print("Enter Student ID : ");
                            Id=in.next();
                            boolean isDuplicate=searchElement(ar,Id);
                            while(isDuplicate){
                                System.out.println("The Student ID already exists");
                                System.out.println();
                                System.out.print("Enter Student ID : ");
                                Id=in.next();
                                isDuplicate=searchElement(ar,Id);
                            }
                            System.out.print("Enter Student Name : ");
                            Name=in.next();
                            System.out.println();
                            ar=pushToArray(ar,Id,Name);
                            marks=getMarks(marks);
                            System.out.println();
                            System.out.print("Student has benn added successfully. Do you want to add a new student(y/n) : ");
                            answer=in.next().charAt(0);
                            clearconsole();
                            break;
                        }while(answer =='n' || answer == 'N');
                        x=1;
                    }while(answer=='y'||answer=='Y');
                        break;
                    case 3: clearconsole();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\t\tADD MARKS\t\t\t\t\t\t\t |");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                System.out.println();
                        System.out.print("enter id : ");
                        Id=in.next();
                        int eIndex=searchIdElimentIndex(ar,Id);
                        if(eIndex==-50){
                            System.out.println("invalid ");
                        }else{
                            System.out.println(ar[1][eIndex]);
                        }
                        System.out.print("Marks have been added. Do you want to add marks for another student(y/n) : ");
                        answer=in.next().charAt(0);
                        break;
                    case 4: clearconsole();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\tUPDATE STUDENTDETAILS\t\t\t\t\t\t\t |");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                                System.out.print("Invalid Student ID. Do you want to search again? (y/n) : ");
                                                        answer=in.next().charAt(0);
                        System.out.println("Student details has been updated successfully.");
                                System.out.print("Do you want to update another student details? (y/n) : ");
                                        answer=in.next().charAt(0);
                        break;
                    case 5: clearconsole();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\t\tUPDATE MARKS\t\t\t\t\t\t\t |");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 6: clearconsole();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\t\tDELETE STUDENTS\t\t\t\t\t\t\t|");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 7: clearconsole();
                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t\t\t\t|");
                                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 8: clearconsole();
                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\t\tPRINT STUDENT RANKS\t\t\t\t\t\t\t|");
                                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 9: clearconsole();
                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\t BEST IN PROGRAMMING FUNDAMENTALS\t\t\t\t\t\t|");
                                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 10:clearconsole();
                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                                System.out.println("|\t\t\t\t\tBEST IN DATABASE MANAGMENT SYSTEM\t\t\t\t\t\t|");
                                        System.out.println("------------------------------------------------------------------------------------------------------------------------");
                        break;
                }
            }
        }
    }
}
