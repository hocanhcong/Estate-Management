package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.input.BuildingCreateOrUpdateRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingCreationRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingSearchRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingUpgradationRequestDTO;
import com.laptrinhjavaweb.dto.output.ResponseDTO;
import com.laptrinhjavaweb.dto.output.StaffResponseDTO;
import net.minidev.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingSearchRequestDTO> findAll();

    void save(BuildingCreateOrUpdateRequestDTO buildingCreateOrUpdateRequestDTO);
    Map<Long,String> getStaffMaps();

    void delete(List<Long> dataFromClient);

    BuildingUpgradationRequestDTO findBuildingToUpdate(Long id);

    List<StaffResponseDTO> findStaffsAssigningBuilding(Long buildingId);

    void assignBuildingToStaff(Map<String,Long[]> responseDTO);

    /*Map<String,String> getTypeMaps();

    Map<String,String> getDistrictMaps();*/
    //void delete(BuildingDeleteRequestDTO buildingDeleteRequestDTO);
}
