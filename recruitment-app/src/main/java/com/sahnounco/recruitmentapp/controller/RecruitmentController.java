package com.sahnounco.recruitmentapp.controller;
import com.sahnounco.recruitmentapp.model.Recruit;
import com.sahnounco.recruitmentapp.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruitment")
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @Autowired
    public RecruitmentController(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

    // Endpoint to get all recruits
    @GetMapping("/recruits")
    public ResponseEntity<List<Recruit>> getAllRecruits() {
        List<Recruit> recruits = recruitmentService.getAllRecruits();
        return ResponseEntity.ok(recruits);
    }

    // Endpoint to get a recruit by ID
    @GetMapping("/recruits/{id}")
    public ResponseEntity<Recruit> getRecruitById(@PathVariable Long id) {
        Recruit recruit = recruitmentService.getRecruitById(id);
        if (recruit != null) {
            return ResponseEntity.ok(recruit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to create a new recruit
    @PostMapping("/recruits")
    public ResponseEntity<Recruit> createRecruit(@RequestBody Recruit recruit) {
        Recruit createdRecruit = recruitmentService.createRecruit(recruit);
        return ResponseEntity.ok(createdRecruit);
    }

    // Endpoint to update an existing recruit
    @PutMapping("/recruits/{id}")
    public ResponseEntity<Recruit> updateRecruit(@PathVariable Long id, @RequestBody Recruit recruit) {
        Recruit updatedRecruit = recruitmentService.updateRecruit(id, recruit);
        if (updatedRecruit != null) {
            return ResponseEntity.ok(updatedRecruit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a recruit by ID
    @DeleteMapping("/recruits/{id}")
    public ResponseEntity<Void> deleteRecruit(@PathVariable Long id) {
        if (recruitmentService.deleteRecruit(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/recruits/preselectResume")
    public ResponseEntity<List<Recruit>> preselectResume(@RequestBody List<Recruit> recruits) {
        List<Recruit> preselectedRecruits = recruitmentService.preselectResume(recruits);
        if (!preselectedRecruits.isEmpty()) {
            return ResponseEntity.ok(preselectedRecruits);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

