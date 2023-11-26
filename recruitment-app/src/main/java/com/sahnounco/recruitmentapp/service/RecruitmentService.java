package com.sahnounco.recruitmentapp.service;

import com.sahnounco.recruitmentapp.model.Recruit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecruitmentService {

    private List<Recruit> recruits;

    public RecruitmentService() {
        this.recruits = new ArrayList<>();
        // Add dummy data
        recruits.add(new Recruit(1L, "John Sahnoun", "Senior Software Engineer"));
        recruits.add(new Recruit(2L, "Jane Smith", "Senior Data Scientist"));
        recruits.add(new Recruit(3L, "Bob Sahnoun", "UX Designer"));
    }

    public List<Recruit> getAllRecruits() {
        return recruits;
    }

    public Recruit getRecruitById(Long id) {
        return recruits.stream()
                .filter(recruit -> recruit.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Recruit createRecruit(Recruit recruit) {
        recruit.setId(generateId());
        recruits.add(recruit);
        return recruit;
    }

    public Recruit updateRecruit(Long id, Recruit updatedRecruit) {
        for (int i = 0; i < recruits.size(); i++) {
            Recruit recruit = recruits.get(i);
            if (recruit.getId().equals(id)) {
                updatedRecruit.setId(id);
                recruits.set(i, updatedRecruit);
                return updatedRecruit;
            }
        }
        return null;
    }

    public boolean deleteRecruit(Long id) {
        return recruits.removeIf(recruit -> recruit.getId().equals(id));
    }

    public List<Recruit> preselectResume(List<Recruit> recruits1) {
        List<Recruit> preselectedRecruits = new ArrayList<>();

        for (Recruit recruit : recruits) {
            // Check if the lastname is Sahnoun and position contains the word "Senior"
            if ("Sahnoun".equalsIgnoreCase(recruit.getName()) && recruit.getPosition().toLowerCase().contains("senior")) {
                preselectedRecruits.add(recruit);
            }
        }

        return preselectedRecruits;
    }

    private Long generateId() {
        // This is a simple method to generate a unique ID. In a real application, you may use a more robust strategy.
        return System.currentTimeMillis();
    }
}
