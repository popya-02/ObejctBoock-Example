package object.solution.example01.domain;

public class SolutionAudience {
    private SolutionBag bag;

    public SolutionAudience(SolutionBag bag){
        this.bag = bag;
    }

    public Long buy(SolutionTicket ticket){
        return bag.hold(ticket);
    }

}
