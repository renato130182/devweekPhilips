package com.class_dio.devweek.Controller;

import com.class_dio.devweek.Entity.Incidence;
import com.class_dio.devweek.Entity.Region;
import com.class_dio.devweek.Repository.IncidenceRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IncidenceController {
    private final IncidenceRepo repo;

    public IncidenceController(IncidenceRepo incidenceRepo) {
        this.repo = incidenceRepo;
    }

    @GetMapping("/incidences")
    public ResponseEntity<List<Incidence>> findAllIncidence(){
        try {
            List<Incidence> incidenceList = repo.findAll();
            if(incidenceList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(incidenceList,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/incidences/{id}")
    public ResponseEntity<Incidence> findIncidenceById(@PathVariable Long id){
        try {
            Optional<Incidence> incidence = repo.findById(id);
            if(incidence.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                Incidence inc = incidence.get();
                return new ResponseEntity<>(inc,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/incidences/add", method = RequestMethod.POST)
    public Incidence newIncidence (@RequestBody Incidence newIncidence){
        return repo.save(newIncidence);
    }

    @RequestMapping(value = "/incidences/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRegion (@PathVariable Long id){
        try {
            Optional<Incidence> opt = repo.findById(id);
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
