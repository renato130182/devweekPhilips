package com.class_dio.devweek.Controller;

import com.class_dio.devweek.Entity.Region;
import com.class_dio.devweek.Repository.RegionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegionController {
    private final RegionRepo repository;

    public RegionController(RegionRepo repository) {
        this.repository = repository;
    }
    @GetMapping("/regions")
    public List<Region> getAllRegions(){
        return repository.findAll();
    }

    public ResponseEntity<?> findAllRegions(){
        try {
            List<Region> allRegions = repository.findAll();
            System.out.println("find all returned OK");
            if(allRegions.isEmpty())
                System.out.println("all regions void");
            return new ResponseEntity<>(allRegions,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("regions/{id}")
    public ResponseEntity<Region> findRegionById(Long id){
        try {
            Optional<Region> regionOptional = repository.findById(id);
            if(regionOptional.isEmpty()){
                System.out.println("region not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
                Region region = regionOptional.get();
                return new ResponseEntity<>(region,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/regions/add", method = RequestMethod.POST)
    public Region newRegion (@RequestBody Region newRegion){
        return repository.save(newRegion);
    }

    @RequestMapping(value = "/regions/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRegion (@PathVariable Long id){
        try {
            Optional<Region> optRegion = repository.findById(id);
            if(!optRegion.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
