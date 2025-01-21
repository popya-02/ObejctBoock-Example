package object.solution.example01.domain;

public class SolutionBag {
    private Long amount;
    private SolutionTicket ticket;
    private SolutionInvitation invitation;

    // 생성자 추가
    public SolutionBag(SolutionInvitation invitation, Long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }
    public Long hold(SolutionTicket ticket){
        if(hasInvitation()){
            System.out.println("초대장 있음");
            setTicket(ticket);
            return 0L;
        }else{
            System.out.println("초대장 없음");
            minusAmount(ticket.getFee());
            setTicket(ticket);
            return ticket.getFee();
        }
    }

    private void setTicket(SolutionTicket ticket){
        this.ticket = ticket;
        System.out.println("티켓 발행 완료");
    }

    private boolean hasInvitation(){
        return invitation != null;
    }

    private void minusAmount(Long amount){
        this.amount -= amount;
        System.out.println("티켓 구매 완료 \n잔액 : " + this.amount + "원");
    }
}
