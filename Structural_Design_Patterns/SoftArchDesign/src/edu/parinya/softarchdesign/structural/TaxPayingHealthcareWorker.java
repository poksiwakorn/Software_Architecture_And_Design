package edu.parinya.softarchdesign.structural;

public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator{
    
    public TaxPayingHealthcareWorker(HealthcareWorker member){
        super(member);
        System.out.println("Decorate " + member.getName() + " with TaxPaying.");
    }

    @Override
    public double getPrice(){
        return member.getPrice() * 1.1;
    }
}
