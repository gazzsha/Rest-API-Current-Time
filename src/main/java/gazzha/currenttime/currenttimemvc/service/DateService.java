package gazzha.currenttime.currenttimemvc.service;

import gazzha.currenttime.currenttimemvc.dto.Message;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class DateService {

    final static public String DATE_FORMAT = "yyyy-MM-dd";
    final static public String TIME_FORMAT = "HH:mm:ss";
    final static public String TIME_ZONE = "Europe/Moscow";


    public Message getCurrentDate() {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of(TIME_ZONE));
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern(TIME_FORMAT);
        DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return new Message(dateTime.format(formatterTime), dateTime.format(formatterDay), ZoneId.of(TIME_ZONE).toString());
    }
}
