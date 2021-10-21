package edu.parinya.softarchdesign.structural;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker{
    protected HealthcareServiceable member;

    public HealthcareWorkerDecorator(HealthcareWorker member){
        super(member);
        this.member = member;
    } 

    @Override
    public void service(){
        member.service();
    }

    @Override
    public double getPrice(){
        return super.getPrice();
    }
}
