package application;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

public static void main(String[] args) throws ParseException {
Scanner sc = new Scanner(System.in);



res(sc);

System.out.println("End of program");
sc.close();
}
public static void method1(Scanner sc){
System.out.println("***method1 start***");
method2(sc);
System.out.println("***method1 end***");
}
public static void method2(Scanner sc){
System.out.println("***method2 start***");
try {
String[] vect = sc.nextLine().split(" ");
int position = sc.nextInt();
System.out.println(vect[position]);
} /*catch (ArrayIndexOutOfBoundsException e) {
System.out.println("Invalid position!");
}*/ catch (InputMismatchException e) {
System.out.println("Input error!");
}
System.out.println("***method2 end***");
}
public static void IO(){
File file = new File("C:\\Users\\Técnico\\Documents\\input.txt");

Scanner sc = null;

try {
sc = new Scanner(file);
while(sc.hasNextLine()){
System.out.println(sc.nextLine());
}
}
catch (IOException e) {
System.out.println("Error opening file: " + e.getMessage());

}
finally{
if (sc != null) {
sc.close();
}
}
}
public static void res(Scanner sc){
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
try {
System.out.println("Room number: ");
int number = sc.nextInt();
System.out.print("Check-in date (dd/MM/yyyy): ");
Date checkIn = sdf.parse(sc.next());
System.out.print("Check-out date (dd/MM/yyyy): ");
Date checkOut = sdf.parse(sc.next());

System.out.println();
System.out.println("Enter date to update the reservation:");
System.out.print("Check-in date (dd/MM/yyyy): ");
checkIn = sdf.parse(sc.next());
System.out.print("Check-out date (dd/MM/yyyy): ");
checkOut = sdf.parse(sc.next());

Reservation reservation = new Reservation(number, checkIn, checkOut);
System.out.println("Reservation: " + reservation);

} catch (ParseException e) {
System.out.println("invalid date form");
} catch (IllegalArgumentException e) {
System.out.println("Error in reservation: " + e.getMessage());
}
}
}