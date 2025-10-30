package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public String updateDates(LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            return "Reservation dates for update must be future dates";
        }
        if (!checkOut.isAfter(checkIn)) {
            return "Check-out date must be after check-in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room ").append(roomNumber);
        sb.append(", check-in: ").append(fmt1.format(checkIn));
        sb.append(", check-out: ").append(fmt1.format(checkOut));
        sb.append(", ").append(duration()).append(" nights");
        return sb.toString();
    }

}


