package com.rrc.vacantbuilding.controller;

import com.rrc.vacantbuilding.entity.VacantBuilding;
import com.rrc.vacantbuilding.service.ApiService;
import com.rrc.vacantbuilding.service.VacantBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vacantbuildings")
public class VacantBuildingController {

    @Autowired
    private VacantBuildingService vacantBuildingService;

    @Autowired
    private ApiService apiService;

    @GetMapping
    public List<VacantBuilding> getAllVacantBuildings() {
        return vacantBuildingService.getAllVacantBuildings();
    }

    @GetMapping("/addresses")
    @CrossOrigin(origins = "http://localhost:5173")
    public List<String> getAllAddresses() {
        return vacantBuildingService.getAllVacantBuildings()
                .stream()
                .map(VacantBuilding::getAddress)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<VacantBuilding> getVacantBuildingById(@PathVariable Long id) {
        return vacantBuildingService.getVacantBuildingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public VacantBuilding createOrUpdateVacantBuilding(@RequestBody VacantBuilding vacantBuilding) {
        return vacantBuildingService.saveOrUpdateVacantBuilding(vacantBuilding);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<Void> deleteVacantBuilding(@PathVariable Long id) {
        vacantBuildingService.deleteVacantBuilding(id);
        return ResponseEntity.noContent().build();
    }

    // @GetMapping("/online")
    // public VacantBuilding[] getAllOnlineVacantBuildings() {
    // return apiService.getVacantBuildings();
    // }
    @GetMapping("/online")
    public Map<String, Object>[] getAllOnlineVacantBuildings() {
        return apiService.getVacantBuildings();
    }

    @GetMapping("/online/addresses")
    public List<String> getAllOnlineVacantBuildingAddresses() {
        Map<String, Object>[] response = apiService.getVacantBuildings();
        return Arrays.stream(response)
                .map(entry -> (String) entry.get("address"))
                .collect(Collectors.toList());
    }

}
