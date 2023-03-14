package id.kawahedukasi.tugas6.service;

import io.quarkus.scheduler.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;

@ApplicationScoped
public class ScheduleService {
    @Inject
    MailService mailService;

    Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    @Scheduled(every = "5s" )
    public void generateLogger(){
        logger.info("kawah Edukasi {}", LocalDateTime.now());
    }

    @Scheduled(cron = "0 * * ? * *") //every minute
    public void sendEmailSchedule(){
        mailService.sendEmail("azharbazla@gmail.com");
        logger.info("Email Sent Successfully");
    }
}
