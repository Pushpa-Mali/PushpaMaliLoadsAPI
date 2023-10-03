package com.pushpa.loadsAPI.Controller;

import com.pushpa.loadsAPI.Entity.Load;
import com.pushpa.loadsAPI.Service.loadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class loadController {

    private final loadService loadServ;

    @Autowired
    public loadController(loadService loadServ) {
        this.loadServ = loadServ;
    }
    @GetMapping("/hello")
        public String hello(){
            return "hello";
        }

    @PostMapping("/load")
    public String createLoad(@RequestBody Load load) {
        loadServ.createLoad(load);
        return "Load details added successfully";
    }

    @GetMapping("/load")
    public List<Load> getByShipperId(@RequestParam UUID shipperId) {
        return loadServ.getByShipperId(shipperId);
    }

    @GetMapping("/load/{loadId}")
    public Load getLoadById(@PathVariable Long loadId) {
        return loadServ.getById(loadId);
    }

    @PutMapping("/load/{loadId}")
    public Load updateLoad(@PathVariable Long loadId, @RequestBody Load load) {
        return loadServ.updateLoad(loadId, load);
    }

    @DeleteMapping("/load/{loadId}")
    public void deleteLoad(@PathVariable Long loadId) {
        loadServ.deleteById(loadId);

    }
}
