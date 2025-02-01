package com.rrc.vacantbuilding.repository;
import com.rrc.vacantbuilding.entity.VacantBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

// Define the repository interface
public interface VacantBuildingRepository extends JpaRepository<VacantBuilding, Long> {
    // Additional query methods can be defined here if needed
}
