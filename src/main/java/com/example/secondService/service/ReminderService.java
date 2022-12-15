package com.example.secondService.service;

import com.example.secondService.model.Remind;
import com.example.secondService.repo.ReminderRepo;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepo repo;

    public List<Remind> list() {
        return repo.findAll();
    }

    public Remind byId(Long id) {
        return repo.findById(id).orElse(new Remind());
    }

    public void delete(Long id) {
        repo.findById(id).ifPresent(repo::delete);
    }

    public Remind save(Remind remind) {
        return repo.save(remind);
    }

}
