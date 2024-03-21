package gazzha.currenttime.currenttimemvc;


import gazzha.currenttime.currenttimemvc.controller.UserController;
import gazzha.currenttime.currenttimemvc.dto.Message;
import gazzha.currenttime.currenttimemvc.service.DateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DateService service;

    private final static String currentDate = LocalDate.now().toString();

    private final static String currentTime = Instant.now().toString();

    private final static String currentTimeZone = "Europe/Moscow";

    @Test()
    void testCurrentTimeZoneFromService() throws Exception {
        when(service.getCurrentDate()).thenReturn(getCurrentTimeZone());
        this.mockMvc.perform(get("/time"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$.timezone").value(currentTimeZone));
    }

    @Test()
    void testCurrentDateFromService() throws Exception {
        when(service.getCurrentDate()).thenReturn(getCurrentDate());
        this.mockMvc.perform(get("/time"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$.date").value(currentDate));
    }

    @Test()
    void testCurrentTimeFromService() throws Exception {
        when(service.getCurrentDate()).thenReturn(getCurrentTime());
        this.mockMvc.perform(get("/time"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$.time").value(currentTime));
    }

    @Test()
    void testCurrentMessage() throws Exception {
        when(service.getCurrentDate()).thenReturn(getCurrentMessage());
        this.mockMvc.perform(get("/time"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$.time").value(currentTime))
                .andExpect(jsonPath("$.date").value(currentDate))
                .andExpect(jsonPath("$.timezone").value(currentTimeZone));
    }

    @Test()
    void testVerifyingHTTPRequestMatching() throws Exception {
        when(service.getCurrentDate()).thenReturn(getCurrentMessage());
        mockMvc.perform(get("/time")
                        .contentType("application/json"))
                .andExpect(status().isOk());
        verify(service).getCurrentDate();
        verify(service,times(1)).getCurrentDate();
    }


    private Message getCurrentTimeZone() {
        return new Message("", "", currentTimeZone);
    }

    private Message getCurrentDate() {
        return new Message("", currentDate, "");
    }

    private Message getCurrentTime() {
        return new Message(currentTime, "", "");
    }

    private Message getCurrentMessage() {
        return new Message(currentTime, currentDate, currentTimeZone);
    }
}
