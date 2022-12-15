package com.example.secondService.controller;

import com.example.secondService.model.Remind;
import com.example.secondService.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminder")
public class IndexController {

    @Autowired
    private ReminderService service;

    @GetMapping
    public ResponseEntity<List<Remind>> notes() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Remind> byId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.byId(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    private ResponseEntity<Remind> save(@RequestBody Remind remind) {
        return ResponseEntity.ok(service.save(remind));
    }

}
