package com.bhavik.jpa.controller;


import com.bhavik.jpa.entity.Guide;
import com.bhavik.jpa.repo.GuideRepo;
import com.bhavik.jpa.repo.GuideRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("guide")
public class GuideController {


    @Autowired
    GuideRepo guideRepo;

    @Autowired
    GuideRepository guideRepository;


    @GetMapping("dummy")
    public void generateDummyGuide(){
        guideRepo.generateDummyGuide();
    }

    @GetMapping()
    public List<Guide> getGuides(@RequestParam(required = false) Optional<Long> id){
        if(id.isPresent()){
            Long requestedId = id.get();
            return guideRepository.findById(requestedId).stream().toList();
        }
        List<Guide> guideList = guideRepository.findAll();
        return  guideList;
    }


    @GetMapping("test")
    public void doTest(){
        guideRepo.doTest();
    }

    @PostMapping("addTrainee/{guideId}")
    public void addTrainee(@PathVariable Long guideId, @RequestParam String traineeName){
        guideRepo.addTrainee(guideId, traineeName);
    }

    @DeleteMapping("removeTrainee/{guideId}/{traineeId}")
    public void removeTrainee(@PathVariable Long guideId, @PathVariable Long traineeId){
        guideRepo.removeTrainee(guideId, traineeId);
    }

    @DeleteMapping()
    public void removeGuide(@RequestParam Long guideId){
        guideRepo.removeGuide(guideId);
    }

    @DeleteMapping("trainee")
    public void removeTrainee(@RequestParam Long traineeId){
        guideRepo.removeTrainee(traineeId);
    }
}
