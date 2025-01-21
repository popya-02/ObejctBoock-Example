package object.solution.example01.domain;

import object.question.example01.domain.TicketOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolutionTicketSeller {
    private SolutionTicketOffice ticketOffice;

    @Autowired
    public SolutionTicketSeller(SolutionTicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(SolutionAudience audience){
        ticketOffice.sellTicketTo(audience);
    }
}
