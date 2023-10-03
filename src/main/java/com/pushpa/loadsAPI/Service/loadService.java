package com.pushpa.loadsAPI.Service;

import com.pushpa.loadsAPI.Entity.Load;
import com.pushpa.loadsAPI.Repository.loadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class loadService {

    private final loadRepository loadRepo;

    @Autowired
    public loadService(loadRepository loadRepo) {
        this.loadRepo = loadRepo;
    }

    public Load createLoad(Load load){
        return loadRepo.save(load);
    }

    public List<Load> getByShipperId(UUID shipperId){
        return loadRepo.findByShipperId(shipperId);
    }

    public Load getById(Long id){
        return loadRepo.findById(id).orElse(null);
    }
    public Load updateLoad(Long loadId, Load updatedLoad) {
        Load existingLoad = loadRepo.findById(loadId).orElse(null);

        if (existingLoad != null) {
            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            existingLoad.setProductType(updatedLoad.getProductType());
            existingLoad.setTruckType(updatedLoad.getTruckType());
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            existingLoad.setWeight(updatedLoad.getWeight());
            existingLoad.setComment(updatedLoad.getComment());
            existingLoad.setDate(updatedLoad.getDate());

            return loadRepo.save(existingLoad);
        }
        return null;
    }

    public void deleteById(Long id){
        loadRepo.deleteById(id);
    }
}
