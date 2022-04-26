package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.input.BuildingCreateOrUpdateRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingCreationRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingSearchRequestDTO;
import com.laptrinhjavaweb.dto.input.BuildingUpgradationRequestDTO;
import com.laptrinhjavaweb.dto.output.BuildingSearchResponseDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    public BuildingSearchRequestDTO convertToDto (BuildingEntity entity){
        BuildingSearchRequestDTO result = modelMapper.map(entity, BuildingSearchRequestDTO.class);
        return result;
    }

    public BuildingEntity convertToEntity(BuildingSearchRequestDTO buildingDTO)
    {
        BuildingEntity result = modelMapper.map(buildingDTO,BuildingEntity.class);
        return result;
    }

    public BuildingSearchResponseDTO convertToBuildingResponseDTO(BuildingEntity buildingEntity)
    {
        BuildingSearchResponseDTO result = modelMapper.map(buildingEntity, BuildingSearchResponseDTO.class);
        String districtName = SystemConstant.districtTable().get(buildingEntity.getDistrict());
        result.setAddress(buildingEntity.getStreet()+","+buildingEntity.getWard()+","+districtName);
        return result;
    }

    public BuildingEntity convertBuildingCreateOrUpdateDTOToEntity(BuildingCreateOrUpdateRequestDTO buildingCreateOrUpdateRequestDTO)
    {
        BuildingEntity buildingEntity = modelMapper.map(buildingCreateOrUpdateRequestDTO,BuildingEntity.class);
        //Xử lý type
        if(buildingCreateOrUpdateRequestDTO.getBuildingTypes()!=null)
        {
            String types = Arrays.stream(buildingCreateOrUpdateRequestDTO.getBuildingTypes()).collect(Collectors.joining(","));
            buildingEntity.setType(types);
        }
        List<RentAreaEntity> oldRentAreaEntityList = rentAreaRepository.findAllByBuildingId(buildingCreateOrUpdateRequestDTO.getId());

        List<RentAreaEntity> newRentAreaEntityList = new ArrayList<>();
        String[] newRentArray = new String[]{};
        if(buildingCreateOrUpdateRequestDTO.getAreaRent()!=null)
        {
            newRentArray = buildingCreateOrUpdateRequestDTO.getAreaRent().split(",");
            for(int i = 0;i<newRentArray.length && !newRentArray[i].isEmpty();i++)
            {
                if(Integer.valueOf(newRentArray[i])>0)
                {
                    RentAreaEntity rentAreaEntity = new RentAreaEntity();
                    rentAreaEntity.setValue(Integer.valueOf(newRentArray[i]));
                    rentAreaEntity.setBuilding(buildingEntity);
                    newRentAreaEntityList.add(rentAreaEntity);
                }
            }
        }

        if(buildingCreateOrUpdateRequestDTO.getId()==null)//Trường hợp create
        {
            buildingEntity.setRentAreaEntityList(newRentAreaEntityList);        }
        else//Trường hợp update
        {
            oldRentAreaEntityList.forEach(item->rentAreaRepository.delete(item));
        }

        return buildingEntity;
    }


    public BuildingUpgradationRequestDTO convertToBuildingUpgradationDTO(BuildingEntity buildingEntity) {
        BuildingUpgradationRequestDTO buildingUpgradationRequestDTO = modelMapper.map(buildingEntity,BuildingUpgradationRequestDTO.class);
        //Set ID
        buildingUpgradationRequestDTO.setId(buildingEntity.getId());
        //Lấy tên district
        buildingUpgradationRequestDTO.setDistrict(SystemConstant.districtTable().get(buildingEntity.getDistrict()));
        //Lấy mảng code loại tòa nhà
        if(buildingEntity.getType()!=null)
        {
            buildingUpgradationRequestDTO.setBuildingTypes(buildingEntity.getType().split(","));
        }
        //Xử lý areaRent
        List<RentAreaEntity> buildingRent = rentAreaRepository.findAllByBuildingId(buildingEntity.getId());
        List<String> buildingListRent = new ArrayList<>();
        buildingRent.forEach(item->buildingListRent.add(item.getValue().toString()));
        String rentValue = String.join(",",buildingListRent);
        buildingUpgradationRequestDTO.setAreaRent(rentValue);

        //Lấy check của loại tòa nhà
        Map<String,String> check = new HashMap<>();
        String[] typeArrayFromServer = buildingUpgradationRequestDTO.getBuildingTypes();

        if(typeArrayFromServer!=null)
        {
            for(String item:typeArrayFromServer)
            {
                check.put(item,"checked");
            }
        }

        for(Map.Entry<String,String> item:SystemConstant.typeTable().entrySet())
        {
            if(!check.containsKey(item.getKey()))
            {
                check.put(item.getKey(),"");
            }
        }
        buildingUpgradationRequestDTO.setCheck(check);
        return buildingUpgradationRequestDTO;
    }
}
