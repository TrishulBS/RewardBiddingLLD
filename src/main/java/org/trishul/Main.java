package org.trishul;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Bidding Event");

        Member mem1 = new Member("Trishul", 1000);
        Member mem2 = new Member("Virat", 1200);
        Member mem3 = new Member("Sachin", 800);

        Admin admin = new Admin();
        admin.addMembers(mem1);
        admin.addMembers(mem2);
        admin.addMembers(mem3);

        Event event1 = admin.addEvent("EventFirst", LocalDate.of(2023, 12, 20));
        admin.addMemberToEvent(event1, mem1);
        admin.addMemberToEvent(event1, mem2);

//        bid111 represents 1st event 1st user 1st bid
//        bid 122 represents 1st event 2nd user 2nd bid
        Bid bid111 = new Bid(mem1, 520);
        Bid bid112 = new Bid(mem1, 300);

        Bid bid121 = new Bid(mem2, 301);
        Bid bid122 = new Bid(mem2, 500);

        admin.addBid(event1, bid111);
        admin.addBid(event1, bid112);
        admin.addBid(event1, bid121);
        admin.addBid(event1, bid122);

        admin.getWinner(event1);
        System.out.print("\n");

        Event event2 = admin.addEvent("EventSecond", LocalDate.of(2023, 12, 21));
        admin.addMemberToEvent(event2, mem1);
        admin.addMemberToEvent(event2, mem3);

        Bid bid211 = new Bid(mem1, 700);
        Bid bid212 = new Bid(mem1, 300);

        Bid bid231 = new Bid(mem3, 299);
        Bid bid232 = new Bid(mem3, 500);

        admin.addBid(event2, bid211);
        admin.addBid(event2, bid212);
        admin.addBid(event2, bid231);
        admin.addBid(event2, bid232);

        admin.getWinner(event2);

        System.out.print("\n");

        admin.pastEvents();


    }
}