package object.solution.example01.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SolutionTicketOffice {
    private Long amount;
    private List<SolutionTicket> tickets = new ArrayList<>();

    public SolutionTicketOffice(){
        this.amount = 100000L;   // Long 타입은 Spring 빈으로 관리되지 않기 때문에 작성해줌
        initializeTickets();  // 티켓을 초기화하는 메서드 호출
    }

    private void initializeTickets() {
        // 티켓을 10개 예시로 생성하여 리스트에 추가
        for (int i = 0; i < 10; i++) {
            tickets.add(new SolutionTicket());
        }
    }

    public void sellTicketTo(SolutionAudience audience){
        plusAmount(audience.buy(getTicket()));
    }

    private SolutionTicket getTicket(){
        System.out.println("티켓 갯수 : " + tickets.size() + "개");
        SolutionTicket result = tickets.remove(0);
        return result;
    }

    private void plusAmount(Long amount){
        this.amount += amount;
        System.out.println("티켓부스의 잔고 : " + this.amount + "원");
    }
}
