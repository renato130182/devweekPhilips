package com.class_dio.devweek.Controller;

import com.class_dio.devweek.Entity.AgeGroup;
import com.class_dio.devweek.Entity.Region;
import com.class_dio.devweek.Repository.AgeGroupRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AgeGroupController {

    private final AgeGroupRepo repo;

    public AgeGroupController(AgeGroupRepo repo) {
        this.repo = repo;
    }
    @GetMapping("age-groups")
    public ResponseEntity<?> findAllAgeGroup(){
        try {
            List<AgeGroup> ageGroupList = repo.findAll();
            if(ageGroupList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(ageGroupList,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("age-groups/{id}")
    public ResponseEntity<AgeGroup> findAgeGroupById(@PathVariable Long id){
        try {
            Optional <AgeGroup> ageGroupOptional = repo.findById(id);
            if(ageGroupOptional.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                AgeGroup ageGroup = ageGroupOptional.get();
                return new ResponseEntity<>(ageGroup,HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/age-groups/add")
    public AgeGroup newAgeGroup (@RequestBody AgeGroup newAgeGroup){
            return repo.save(newAgeGroup);
    }

    @PostMapping("/age-groups/delete")
    public void a (@PathVariable long id){
        repo.deleteById(id);
    }

    @RequestMapping(value = "/age-groups/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAgeGroup (@PathVariable Long id){
        try {
            Optional<AgeGroup> opt = repo.findById(id);
            if(!opt.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
