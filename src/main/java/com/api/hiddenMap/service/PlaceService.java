package com.api.hiddenMap.service;

import com.api.hiddenMap.entity.PlaceEntity;
import com.api.hiddenMap.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<PlaceEntity> getAllPlace (){
        return placeRepository.findAll();
    }

    public PlaceEntity getPlaceByid(Long id){
        return placeRepository.findById(id).orElse(null);
    }

    public PlaceEntity createPlace(PlaceEntity place){
        return placeRepository.save(place);
    }

    public PlaceEntity updatePlace(PlaceEntity place,Long id){
        PlaceEntity update = placeRepository.findById(id).orElse(null);
        update.setName(place.getName());
        update.setDescription(place.getDescription());
        update.setProvince(place.getProvince());
        update.setDistrict(place.getDistrict());
        update.setSubDistrict(place.getSubDistrict());
        update.setCategory(place.getCategory());
        update.setUser(place.getUser());
        return placeRepository.save(update);
    }

    public void deletePlace(Long id){
        placeRepository.deleteById(id);
    }
}
