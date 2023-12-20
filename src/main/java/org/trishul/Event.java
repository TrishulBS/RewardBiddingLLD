package org.trishul;

import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Event {
    private String eventName;
    private LocalDate eventDate;
    private Map<Member, List<Bid>> bids;
    private List<Member> members;
    private String winner;

    private boolean winnerDeductMoney = true;
    public Event(String name, LocalDate eventDate){
        this.eventName = name;
        this.eventDate = eventDate;
        this.bids = new HashMap<>();
        this.members = new ArrayList<>();
    }

    public void addBid(Bid bid) throws Exception{
        if(members.contains(bid.getMember())){
            if(bids.containsKey(bid.getMember())){
                if(bids.get(bid.getMember()).size()>5){
                    throw new Exception("Number of bids already exceeded 5");
                }
                else{
                    List<Bid> bds = bids.get(bid.getMember());
                    for(Bid bd: bds){
                        if(bd.getAmount() == bid.getAmount()){
                            throw new Exception("Same bid amount has been submitted before for this event "+ this.eventName + " by " + bid.getMember().getName());
                        }
                    }

                    bid.setBidNumber(bids.get(bid.getMember()).size()+1);
                    bids.get(bid.getMember()).add(bid);
                }
            }
            else{
                bid.setBidNumber(1);
                List<Bid> lst = new ArrayList<>();
                lst.add(bid);
                bids.put(bid.getMember(), lst);
            }
        }else{
            throw new Exception("Member "+ bid.getMember().getName() +  "has not registered to the event. Please register");
        }
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", bids=" + bids +
                ", members=" + members +
                ", winner='" + winner + '\'' +
                '}';
    }

    public void registerMember(Member member){
        this.members.add(member);
        System.out.println("Member "+ member.getName() + " registered successfully to the event "+ this.eventName);
    }

    public void getWinner(){
        int lowest = Integer.MAX_VALUE;
        int bidNumber = Integer.MAX_VALUE;
        Member winner = null;

        for(Member member: bids.keySet()){
            List<Bid> lst = bids.get(member);
            for(Bid bid: lst){
                int amount = bid.getAmount();
                int no = bid.getBidNumber();
                if(amount<lowest){
                    lowest = amount;
                    bidNumber = no;
                    winner = member;
                }
                else if((amount == lowest) && no<bidNumber){
                    winner = member;
                }
            }
        }

        System.out.println("Winner of the event "+this.eventName +" is " + winner.getName() + " with bid amount "+ lowest);
        if(winnerDeductMoney){
            this.winnerDeductMoney = false;
            winner.setCoins(winner.getCoins() - lowest);
        }

    }
}
