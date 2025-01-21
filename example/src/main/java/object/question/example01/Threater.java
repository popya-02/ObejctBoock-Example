package object.question.example01;

import object.question.example01.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Threater {
    private TicketSeller ticketSeller;

    @Autowired
    public Threater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        System.out.println("enter 실행");
        if (audience.getBag().hasInvitation()) {
            System.out.println("초대장 있음");
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
            System.out.println("초대장이 있으므로 티켓을 무료로 지급하였음");
        } else{
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            System.out.println("초대장 없음");
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAount(ticket.getFee());
            audience.getBag().setTicket(ticket);
            System.out.println("초대장이 없으므로 티켓을 구매하였음\n요금 : " + ticket.getFee() + "원");
            System.out.println("가방에 남은 돈 : " + audience.getBag().getAmount() + "원");
            // 돈이 부족한 조건은 우선 제외
        }
    }

    public static void main(String[] args) {
        // Spring Boot 애플리케이션을 실행
        var context = SpringApplication.run(Threater.class, args);

        // Threater 객체를 Spring Bean으로 가져오기
        Threater threater = context.getBean(Threater.class);

        Invitation invitation = new Invitation();

//        Bag bag = new Bag(invitation, 500L);  // 초대장을 가진, 500원을 가진 Bag 생성
        Bag bag = new Bag(null, 500L);  // 초대장이 없는 ,500원을 가진 Bag 생성

        // Audience 객체 생성 (예시)
        Audience audience = new Audience(bag);

        // enter 메서드 호출
        threater.enter(audience);

    }

}
