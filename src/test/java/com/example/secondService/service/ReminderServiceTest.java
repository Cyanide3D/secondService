package com.example.secondService.service;

import com.example.secondService.model.Remind;
import com.example.secondService.repo.ReminderRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ReminderServiceTest {

    @MockBean
    private ReminderRepo repo;
    @MockBean
    private ReminderService service;

    @Test
    void list() {
        List<Remind> notes = List.of(new Remind("1", LocalDateTime.now(), "2"), new Remind("3", LocalDateTime.now(), "4"));
        Mockito.when(service.list()).thenReturn(notes);
        List<Remind> list = service.list();
        assertArrayEquals(notes.toArray(), list.toArray());
    }

    @Test
    void byId() {
        Remind note = new Remind("1", LocalDateTime.now(), "2");
        note.setId(1L);
        Mockito.when(service.byId(1L)).thenReturn(note);
        assertEquals(note, service.byId(1L));
    }

    @Test
    void save() {
        Remind note = new Remind("1", LocalDateTime.now(), "2");
        Mockito.when(service.save(note)).thenReturn(note);
        assertEquals(note, service.save(note));
    }
}