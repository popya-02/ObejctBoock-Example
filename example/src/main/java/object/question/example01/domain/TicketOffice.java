package object.question.example01.domain;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(){
        this.amount = 100000L;   // Long 타입은 Spring 빈으로 관리되지 않기 때문에 작성해줌
        initializeTickets();  // 티켓을 초기화하는 메서드 호출
    }

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    // 티켓을 초기화하는 메서드
    private void initializeTickets() {
        // 티켓을 10개 예시로 생성하여 리스트에 추가
        for (int i = 0; i < 10; i++) {
            tickets.add(new Ticket());
        }
    }

    public Ticket getTicket() {

        System.out.println("현재 티켓 수 : " + tickets.size());

        if (tickets.isEmpty()) {
            throw new IllegalStateException("티켓이 더 이상 없습니다.");  // 리스트가 비어있다면 예외 처리
        }

        Ticket result = tickets.remove(0); // 첫 번째 티켓 제거
        System.out.println("남은 티켓 수 : " + tickets.size());

        return result;
    }

    public void minusAount(Long amount) {
        this.amount -= amount;
    }

    public void plusAount(Long amount) {
        this.amount += amount;
    }
}
