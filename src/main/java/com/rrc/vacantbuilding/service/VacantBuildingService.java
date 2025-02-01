package com.rrc.vacantbuilding.service;

import com.rrc.vacantbuilding.entity.VacantBuilding;
import com.rrc.vacantbuilding.repository.VacantBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacantBuildingService {

    @Autowired
    private VacantBuildingRepository vacantBuildingRepository;

    public List<VacantBuilding> getAllVacantBuildings() {
        return vacantBuildingRepository.findAll();
    }

    public Optional<VacantBuilding> getVacantBuildingById(Long id) {
        return vacantBuildingRepository.findById(id);
    }

    public VacantBuilding saveOrUpdateVacantBuilding(VacantBuilding vacantBuilding) {
        return vacantBuildingRepository.save(vacantBuilding);
    }

    public void deleteVacantBuilding(Long id) {
        vacantBuildingRepository.deleteById(id);
    }
}
