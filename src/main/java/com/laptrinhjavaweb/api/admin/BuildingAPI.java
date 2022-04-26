package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.input.BuildingCreateOrUpdateRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingCreationRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingUpgradationRequestDTO;
import com.laptrinhjavaweb.dto.output.ResponseDTO;
import com.laptrinhjavaweb.dto.output.StaffResponseDTO;
import com.laptrinhjavaweb.service.impl.BuildingService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController(value="buildingAPIOfAdmin")
public class BuildingAPI {
    @Autowired
    BuildingService buildingService;

    @PostMapping("/api/building")
    public ResponseDTO createBuilding(@RequestBody BuildingCreateOrUpdateRequestDTO buildingCreateOrUpdateRequestDTO)
    {
        buildingService.save(buildingCreateOrUpdateRequestDTO);
        return new ResponseDTO();
    }

    /*@DeleteMapping("/api/building")
    public ResponseDTO deleteBuilding(@RequestBody Map<String,List<Long>> dataFromClient)
    {
        buildingService.delete(dataFromClient);
        return new ResponseDTO();
    }*/

    @DeleteMapping("/api/building")
    public ResponseDTO deleteBuilding(@RequestBody List<Long>dataFromClient)
    {
        buildingService.delete(dataFromClient);
        return new ResponseDTO();
    }

    @PutMapping("/api/building-edit-{id}")
    public ResponseDTO updateBuilding(@RequestBody BuildingCreateOrUpdateRequestDTO buildingCreateOrUpdateRequestDTO)
    {
        buildingService.save(buildingCreateOrUpdateRequestDTO);
        return new ResponseDTO();
    }

    @RequestMapping(value = "/api/building-{id}-staffs",method = RequestMethod.GET)
    public ResponseDTO loadStaffs(@PathVariable("id") Long buildingId)
    {
        ResponseDTO result = new ResponseDTO();
        List<StaffResponseDTO> assignedStaffsOfBuilding = buildingService.findStaffsAssigningBuilding(buildingId);

        result.setData(assignedStaffsOfBuilding);
        result.setMessage("success");
        //result.data = response.data
        return result;
    }

    @RequestMapping(value = "/api/building-assign-staffs",method = RequestMethod.POST)
    public ResponseDTO loadStaffs(@RequestBody Map<String,Long[]> jsonObject)
    {
        buildingService.assignBuildingToStaff(jsonObject);
        return new ResponseDTO();
    }
}
