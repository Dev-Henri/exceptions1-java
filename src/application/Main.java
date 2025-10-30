package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import static model.entities.Reservation.fmt1;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), fmt1);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), fmt1);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), fmt1);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();

    }
}
