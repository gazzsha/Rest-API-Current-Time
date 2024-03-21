package gazzha.currenttime.currenttimemvc.controller;


import gazzha.currenttime.currenttimemvc.dto.Message;
import gazzha.currenttime.currenttimemvc.service.DateService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    static final public String GET_TIME = "/time";

    DateService dateService;

    @GetMapping(value = GET_TIME, produces =Оф   MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCurrentTime() {
        Message messageDto = dateService.getCurrentDate();
        return ResponseEntity.ok().body(messageDto);
    }
}
