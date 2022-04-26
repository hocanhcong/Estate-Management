package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearch;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.input.BuildingCreateOrUpdateRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingCreationRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingSearchRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingUpgradationRequestDTO;
import com.laptrinhjavaweb.dto.output.BuildingSearchResponseDTO;
import com.laptrinhjavaweb.dto.output.ResponseDTO;
import com.laptrinhjavaweb.dto.output.StaffResponseDTO;
import com.laptrinhjavaweb.entity.*;
import com.laptrinhjavaweb.repository.*;
import com.laptrinhjavaweb.repository.output.BuildingRepositoryImpl;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.ValidateUtils;
import net.minidev.json.JSONObject;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManagerFactory;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    BuildingRepositoryCustom buildingRepositoryImpl = new BuildingRepositoryImpl();

    @Autowired
    RentAreaRepository rentAreaRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AssignmentBuildingRepository assignmentBuildingRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    BuildingConverter buildingConverter;


    @Override
    public List<BuildingSearchRequestDTO> findAll() {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll();
        List<BuildingSearchRequestDTO> result = new ArrayList<>();
        for (BuildingEntity item:buildingEntities)
        {
            BuildingSearchRequestDTO buildingDTO = new BuildingSearchRequestDTO();
            buildingDTO = buildingConverter.convertToDto(item);
            result.add(buildingDTO);
        }
        return result;
    }

    @Override
    @Transactional
    public void save(BuildingCreateOrUpdateRequestDTO buildingCreateOrUpdateRequestDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertBuildingCreateOrUpdateDTOToEntity(buildingCreateOrUpdateRequestDTO);
        buildingRepository.saveAndFlush(buildingEntity);
        List<RentAreaEntity> rentAreaEntityList = buildingEntity.getRentAreaEntityList();
        if(rentAreaEntityList!=null && !rentAreaEntityList.isEmpty())
        {
            rentAreaRepository.save(rentAreaEntityList);
        }
    }

    @Override
    public Map<Long, String> getStaffMaps() {
        List<UserEntity> userEntities = userRepository.findByStatusAndRoles_Code(1,"staff");
        return userEntities.stream().collect(Collectors.toMap(UserEntity::getId,UserEntity::getFullName));
    }

    @Override
    @Transactional
    public void delete(List<Long> dataFromClient) {
        if(dataFromClient.size()>0)
        {
            for(Long item:dataFromClient)
            {
                rentAreaRepository.deleteAllByBuildingId(item);
                assignmentBuildingRepository.deleteAllByBuildingId(item);
                buildingRepository.deleteById(item);
            }
        }
        return;
    }

    public List<BuildingSearchResponseDTO> findBuildingUsingBuilderPattern(BuildingSearchRequestDTO buildingDTO)
    {
        boolean isEmployee = true;//Là staff

        if(buildingDTO.getStaffId() == null)
        {
            isEmployee = false;//Là admin
        }

        BuildingSearch buildingSearch = convertDTOToBuildingSearch(buildingDTO);
        List<BuildingEntity> buildingEntities = buildingRepositoryImpl.findBuilding(buildingSearch);
        List<BuildingEntity> buildingEntitiesManagedByEmployee = new ArrayList<>();
        List<BuildingSearchResponseDTO> result = new ArrayList<>();
        //Nếu là employee
        if(isEmployee == true && buildingEntities.size()>0)
        {
            for(BuildingEntity buildingEntity:buildingEntities)
            {
                AssignmentBuildingEntity assignmentBuildingEntity = assignmentBuildingRepository.findByBuildingIdAndUserId(buildingEntity.getId(),buildingDTO.getStaffId());
                if(assignmentBuildingEntity != null)
                {
                    buildingEntitiesManagedByEmployee.add(buildingEntity);
                }
            }
            for(BuildingEntity item:buildingEntitiesManagedByEmployee)
            {
                BuildingSearchResponseDTO buildingResponseDTO = buildingConverter.convertToBuildingResponseDTO(item);
                result.add(buildingResponseDTO);
            }
            return result;
        }

        //Nếu không phải là employee
        for(BuildingEntity item:buildingEntities)
        {
            BuildingSearchResponseDTO buildingResponseDTO = buildingConverter.convertToBuildingResponseDTO(item);
            result.add(buildingResponseDTO);
        }
        return result;
    }

    public BuildingSearch convertDTOToBuildingSearch(BuildingSearchRequestDTO buildingSearchRequestDTO)
    {
        BuildingSearch result = new BuildingSearch.BuildingSearchBuilder()
                                                .setName(buildingSearchRequestDTO.getName())
                                                .setFloorArea(buildingSearchRequestDTO.getFloorArea())
                                                .setDistrict(buildingSearchRequestDTO.getDistrict())
                                                .setWard(buildingSearchRequestDTO.getWard())
                                                .setNumberOfBasement(buildingSearchRequestDTO.getNumberOfBaseMent())
                                                .setDirection(buildingSearchRequestDTO.getDirection())
                                                .setLevel(buildingSearchRequestDTO.getLevel())
                                                .setAreaRentFrom(buildingSearchRequestDTO.getAreaRentFrom())
                                                .setAreaRentTo(buildingSearchRequestDTO.getAreaRentTo())
                                                .setCostRentFrom(buildingSearchRequestDTO.getCostRentFrom())
                                                .setCostRentTo(buildingSearchRequestDTO.getCostRentTo())
                                                .setBuildingTypes(buildingSearchRequestDTO.getBuildingTypes())
                                                .setStaffId(buildingSearchRequestDTO.getStaffId())
                                                .setStreet(buildingSearchRequestDTO.getStreet())
                                                .build();
        return result;
    }

    @Override
    public BuildingUpgradationRequestDTO findBuildingToUpdate(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id);
        BuildingUpgradationRequestDTO buildingUpgradationRequestDTO = buildingConverter.convertToBuildingUpgradationDTO(buildingEntity);
        return buildingUpgradationRequestDTO;
    }

    //100,200,300
    //String[] = [100,200,300];

    @Override
    public List<StaffResponseDTO> findStaffsAssigningBuilding(Long buildingId) {
        List<StaffResponseDTO> result = new ArrayList<>();
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId);
        //List<AssignmentBuildingEntity> assignmentBuildingEntityList = assignmentBuildingRepository.findByBuildingId(buildingId);
        List<AssignmentBuildingEntity> assignmentBuildingEntityList = buildingEntity.getAssignmentBuildingEntities();
        List<Long> staffAssignedId = new ArrayList<>();
        assignmentBuildingEntityList.forEach(item->staffAssignedId.add(item.getUser().getId()));
        List<UserEntity> userEntities = userRepository.findByStatusAndRoles_Code(1,"staff");

        for(UserEntity u:userEntities)
        {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(u.getFullName());
            staffResponseDTO.setStaffId(u.getId());
            if(staffAssignedId.contains(u.getId()))
            {
                staffResponseDTO.setChecked("checked");
            }
            else
            {
                staffResponseDTO.setChecked("");
            }
            result.add(staffResponseDTO);
        }
        return result;
    }

    @Override
    @Transactional
    public void assignBuildingToStaff(Map<String,Long[]> responseDTO) {
        Long[] buildingArray = responseDTO.get("buildingId");
        Long buildingId = buildingArray[0];
        Long[] staffIds = responseDTO.get("staffIds");
        List<Long> listStaffIds = Arrays.asList(staffIds);
        List<AssignmentBuildingEntity> assignmentBuildingEntityList = assignmentBuildingRepository.findByBuildingId(buildingId);
        List<Long> staffAssignedId = new ArrayList<>();
        assignmentBuildingEntityList.forEach(item->staffAssignedId.add(item.getUser().getId()));
        List<UserEntity> userEntities = userRepository.findByStatusAndRoles_Code(1,"staff");

        BuildingEntity buildingEntity = buildingRepository.findById(buildingId);
        for(Long item:listStaffIds)
        {
            UserEntity userEntity = userRepository.findById(item);
            if(staffAssignedId.contains(item))
            {
                continue;
            }
            else
            {
                AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
                assignmentBuildingEntity.setBuilding(buildingEntity);
                assignmentBuildingEntity.setUser(userEntity);
                assignmentBuildingRepository.save(assignmentBuildingEntity);
            }
        }

        for(Long item:staffAssignedId)
        {
            UserEntity userEntity = userRepository.findById(item);
            if(listStaffIds.contains(item))
            {
                continue;
            }
            else
            {
                assignmentBuildingRepository.deleteByUserIdAndBuildingId(userEntity.getId(),buildingEntity.getId());
                //assignmentBuildingRepository.deleteByUser_IdAndBuilding_Id(userEntity.getId(),buildingEntity.getId());
            }
        }

    }

}
