package object.solution.example01;

import object.question.example01.Threater;
import object.question.example01.domain.Audience;
import object.question.example01.domain.Bag;
import object.question.example01.domain.Invitation;
import object.solution.example01.domain.SolutionAudience;
import object.solution.example01.domain.SolutionBag;
import object.solution.example01.domain.SolutionInvitation;
import object.solution.example01.domain.SolutionTicketSeller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class SolutionThreater {
    public SolutionTicketSeller ticketSeller;

    @Autowired
    public SolutionThreater(SolutionTicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public void enter(SolutionAudience audience){
        ticketSeller.sellTo(audience);
    }

    public static void main(String[] args) {
        var context = SpringApplication.run(SolutionThreater.class, args);
        SolutionThreater threater = context.getBean(SolutionThreater.class);
//        SolutionBag bag = new SolutionBag(null, 500L);  // 초대장 없는, 500원을 가진 손님 객체
        SolutionInvitation invitation = new SolutionInvitation();
        SolutionBag bag = new SolutionBag(invitation, 500L);  // 초대장 있는, 500원을 가진 손님 객체
        SolutionAudience audience = new SolutionAudience(bag);
        threater.enter(audience);
    }
}
