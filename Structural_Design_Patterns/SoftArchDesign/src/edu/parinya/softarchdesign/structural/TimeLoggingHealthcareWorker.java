package edu.parinya.softarchdesign.structural;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{
    
    public TimeLoggingHealthcareWorker(HealthcareWorker member){
        super(member);
        System.out.println("Decorate " + member.getName() + " with TimeLogging.");
    }

    @Override
    public void service(){
        Date date = new Date();
        var dateformat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
        System.out.print(dateformat.format(date) + ": ");
        super.service();
    }
}
