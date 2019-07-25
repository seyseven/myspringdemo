package com.example.myspringdemo.datainit;

import com.example.myspringdemo.entity.Officer;
import com.example.myspringdemo.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
class Datainit implements ApplicationRunner {

    private OfficerService officerService;

    private static final DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public Datainit(OfficerService officerService){
        this.officerService = officerService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        //long count = officerService.count;
        //if(count ==0){
        Officer o1 = new Officer();
        o1.setFullName("Иван");
        Date d1 = dt.parse("1980-12-20");
        o1.setDateOfBirth(d1);
        Date dR = dt.parse("2019-07-15");
        o1.setDateReceived(dR);
        //
        Officer o2 = new Officer();
        o2.setFullName("Василий");
        Date d2 = dt.parse("1985-11-11");
        o2.setDateOfBirth(d2);

            officerService.save(o1);
            officerService.save(o2);

        // }
    }
}
