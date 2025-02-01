package com.rrc.vacantbuilding.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.rrc.vacantbuilding.entity.VacantBuilding;
import java.util.Map;
@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    // public VacantBuilding[] getVacantBuildings() {
    //     String url = "https://data.winnipeg.ca/resource/qe3f-4r3j.json"; 
    //     return restTemplate.getForObject(url, VacantBuilding[].class);
    // }

    public Map<String, Object>[] getVacantBuildings() {
        String url = "https://data.winnipeg.ca/resource/qe3f-4r3j.json"; 
        return restTemplate.getForObject(url, Map[].class);
    }
}
