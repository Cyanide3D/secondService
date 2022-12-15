package com.example.secondService.repo;

import com.example.secondService.model.Remind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepo extends JpaRepository<Remind, Long> {
}
