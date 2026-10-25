package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Room {

     private int number;
     String name;
     int roomNum;
     Date checkIn;
     Date checkOut;

    Room() {
        this.number = 0;
        this.name = null;
        this.roomNum = 0;
        this.checkIn = null;
        this.checkOut = null;
        //int number, String name, int roomNum, Date checkIn, Date checkOut
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}

class Global {

    private static Room[] roomArray = new Room[20];
    static int availableRooms = 0, occupiedRooms = 0, outOFOrderRooms = 0;

    public static Room getRoomArray(int index) {
        return roomArray[index];
    }

    public static void instantiateRoomArray(int index) {
        Global.roomArray[index] = new Room();
    }

    //public static void setRoomArray(int index) {
    //   Global.roomArray[index] = roomArray[index];
    //}

    public static int getAvailableRooms() {
        return availableRooms;
    }

    public static void setAvailableRooms(int availableRooms) {
        Global.availableRooms = availableRooms;
    }

    public static int getOccupiedRooms() {
        return occupiedRooms;
    }

    public static void setOccupiedRooms(int occupiedRooms) {
        Global.occupiedRooms = occupiedRooms;
    }

    public static int getOutOFOrderRooms() {
        return outOFOrderRooms;
    }

    public static void setOutOFOrderRooms(int outOFOrderRooms) {
        Global.outOFOrderRooms = outOFOrderRooms;
    }

    public static int getNumAvailableRooms() {
        availableRooms = 0;
        for(int i = 0; i < roomArray.length;i++) {
            if(roomArray[i].name == null) {
                availableRooms += 1;
            }
        }
        return availableRooms;
    }

    public static int getNumOccupiedRooms() {
        occupiedRooms = 0;
        for(int i = 0; i < roomArray.length;i++) {
            if(roomArray[i].name != null) {
                occupiedRooms += 1;
            }
        }
        return occupiedRooms;
    }

}


public class Main {

    public static void main(String[] args) throws ParseException {

        for(int i = 0; i < 20; i++) {
            Global.instantiateRoomArray(i);
            Global.getRoomArray(i).setRoomNum(i+1);
        }
        //SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
        //SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
        //Date date = format1.parse("06/01/2022");
        //System.out.println(format1.format(date));

        Login_Page mainLogin_Page = new Login_Page();
    }
}
