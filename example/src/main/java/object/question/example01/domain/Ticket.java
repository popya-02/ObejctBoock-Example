package object.question.example01.domain;

public class Ticket {
    public static final Long FEE = 100L;    //티켓 가격은 100원으로 고정

    public Long getFee(){
        return FEE;
    }
}
