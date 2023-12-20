package org.trishul;

public class Bid {
    private Member member;
    private int amount;
    private int bidNumber;

    public Bid(Member member, int amount) throws Exception{
        if(amount<=0){
            throw new Exception("Bid amount should be grater than zero");
        }

        if(amount>member.getCoins()){
            throw new Exception("Bid amount is greater than the coins you have "+ member.getName());
        }
        else{
            this.member = member;
            this.amount = amount;
        }


    }

    public Member getMember() {
        return member;
    }

    public int getAmount() {
        return amount;
    }

    public void setBidNumber(int number){
        this.bidNumber = number;
    }

    public int getBidNumber(){
        return this.bidNumber;
    }
}
