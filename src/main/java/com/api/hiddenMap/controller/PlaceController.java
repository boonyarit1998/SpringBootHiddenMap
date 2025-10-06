package com.api.hiddenMap.controller;

import com.api.hiddenMap.entity.PlaceEntity;
import com.api.hiddenMap.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/place")
@RequiredArgsConstructor
@RestController
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping()
    public List<PlaceEntity> getAllPlace(){
        return placeService.getAllPlace();
    }

    @GetMapping("/{id}")
    public  PlaceEntity getPlaceByID(@PathVariable Long id){
        return  placeService.getPlaceByid(id);
    }

    @PostMapping()
    public PlaceEntity createPlace(@RequestBody PlaceEntity place){
        return  placeService.createPlace(place);
    }

    @PutMapping("/{id}")
    public PlaceEntity updatePlace(@PathVariable Long id,@RequestBody PlaceEntity place){
        return placeService.updatePlace(place,id);
    }

    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable Long id){
         placeService.deletePlace(id);
    }
}
