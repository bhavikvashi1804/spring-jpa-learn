package com.bhavik.jpa.repo;


import com.bhavik.jpa.entity.Guide;
import com.bhavik.jpa.entity.Trainee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class GuideRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void generateDummyGuide(){

        Guide guide1 = new Guide("Maximillan");
        Guide guide2 = new Guide("Angela Yu");

        entityManager.persist(guide1);
        entityManager.persist(guide2);

    }

    @Transactional
    public void doTest(){

        Guide guide = new Guide("Bhavik Guide");


        Trainee trainee = new Trainee("Bhavik Vashi");
        trainee.setGuide(guide);
        entityManager.persist(trainee);
    }


    @Transactional
    public void addTrainee(Long guideId, String traineeName){

        Guide guide = entityManager.find(Guide.class, guideId);
        Trainee trainee = new Trainee(traineeName);
        guide.addTrainee(trainee);
        entityManager.persist(guide);

    }

    @Transactional
    public void removeTrainee(Long guideId, Long traineeId){

        Guide guide = entityManager.find(Guide.class, guideId);

        Trainee trainee = guide.getTrainees().stream().filter(x -> traineeId.equals(x.getId())).findFirst().orElse(null);

        if(trainee != null){
            guide.removeTrainee(trainee);
        }

        entityManager.persist(guide);
    }

    @Transactional
    public void removeGuide(Long guideId){
        Guide guide = entityManager.find(Guide.class, guideId);
        entityManager.remove(guide);
    }

    @Transactional
    public void removeTrainee(Long traineeId){
        Trainee trainee = entityManager.find(Trainee.class, traineeId);
        entityManager.remove(trainee);
    }

}
