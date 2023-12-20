package org.trishul;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Admin {

    private List<Event> events;
    private List<Member> members;

    public Admin(){
        this.events = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public Event addEvent(String name, LocalDate eventDate){
        Event event = new Event(name, eventDate);
        events.add(event);
        return event;
    }

    public void addMembers(Member member){
        members.add(member);
    }


    public void addMemberToEvent(Event event, Member member){
        event.registerMember(member);
    }

    public void pastEvents(){
        for(Event event: events){
            System.out.println(event);
        }
    }

    public void addBid(Event event, Bid bid) throws Exception{
        event.addBid(bid);
    }

    public void getWinner(Event event){
        event.getWinner();
    }


}
