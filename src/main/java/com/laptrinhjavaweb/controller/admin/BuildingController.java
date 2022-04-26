package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.input.BuildingUpgradationRequestDTO;
import com.laptrinhjavaweb.dto.output.BuildingSearchResponseDTO;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.input.BuildingSearchRequestDTO;

import java.util.List;
import java.util.Map;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {

	@Autowired
	BuildingService buildingService;

	@RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingListPage(@ModelAttribute("modelSearch") BuildingSearchRequestDTO buildingDTO) {
		ModelAndView modelAndView = new ModelAndView("admin/building/list");
		//check role is staff
		Long staffId = null;
		if(!SecurityUtils.getAuthorities().contains(SystemConstant.ADMIN_ROLE))
		{
			staffId = SecurityUtils.getPrincipal().getId();
			buildingDTO.setStaffId(staffId);
		}
		//List<BuildingSearchResponseDTO> buildingSearchOutputList = buildingService.findBuildingAsRequest(buildingDTO);
		List<BuildingSearchResponseDTO> buildingSearchOutputList = buildingService.findBuildingUsingBuilderPattern(buildingDTO);
		modelAndView.addObject("buildingSearch", buildingSearchOutputList);
		modelAndView.addObject("modelSearch", buildingDTO);
		modelAndView.addObject("buildings", buildingService.findAll());
		modelAndView.addObject("staffMaps", buildingService.getStaffMaps());
		modelAndView.addObject("districtMaps", SystemConstant.districtTable());
		modelAndView.addObject("typeMaps", SystemConstant.typeTable());

		return modelAndView;
	}

	/*@RequestMapping(value = "/admin/building-list-staffid-{id}", method = RequestMethod.GET)
	public ModelAndView buildingListPage(@PathVariable("id") Long staffId,@ModelAttribute("modelSearch") BuildingSearchRequestDTO buildingDTO) {
		ModelAndView modelAndView = new ModelAndView("admin/building/list");
		//List<BuildingSearchResponseDTO> buildingSearchOutputList = buildingService.findBuildingAsRequest(buildingDTO);
		List<BuildingSearchResponseDTO> buildingSearchOutputList = buildingService.findBuildingUsingBuilderPattern(staffId,buildingDTO);
		modelAndView.addObject("buildingSearch", buildingSearchOutputList);
		modelAndView.addObject("modelSearch", buildingDTO);
		modelAndView.addObject("buildings", buildingService.findAll());
		modelAndView.addObject("staffMaps", buildingService.getStaffMaps());
		modelAndView.addObject("districtMaps", SystemConstant.districtTable());
		modelAndView.addObject("typeMaps", SystemConstant.typeTable());

		return modelAndView;
	}*/

	@RequestMapping(value = "/admin/building-edit", method = RequestMethod.POST)
	public ModelAndView buildingCreatePage() {
		ModelAndView modelAndView = new ModelAndView("admin/building/edit");
		modelAndView.addObject("districtMaps", SystemConstant.districtTable());
		modelAndView.addObject("typeMaps", SystemConstant.typeTable());
		return modelAndView;
	}

	/*	@RequestMapping(value="/admin/building-edit", method = RequestMethod.GET)
		public ModelAndView buildingEditPage(@RequestParam(required = false, value = "id") Long id)
		{
			ModelAndView modelAndView = new ModelAndView("admin/building/edit");
			BuildingUpgradationRequestDTO buildingUpgradationRequestDTO = buildingService.findBuildingToUpdate(id);
			modelAndView.addObject("buildingEdit",buildingUpgradationRequestDTO);
			modelAndView.addObject("typeCheck", buildingUpgradationRequestDTO.getCheck());
			modelAndView.addObject("typeMaps", SystemConstant.typeTable());
			modelAndView.addObject("districtMaps", SystemConstant.districtTable());
			modelAndView.addObject("id",id);
			return modelAndView;0
		}*/

	@RequestMapping(value = "/admin/building-edit-{id}", method = RequestMethod.GET)
	public ModelAndView buildingEditPage(@PathVariable(value = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("admin/building/edit");
		BuildingUpgradationRequestDTO buildingUpgradationRequestDTO = buildingService.findBuildingToUpdate(id);
		modelAndView.addObject("buildingEdit", buildingUpgradationRequestDTO);
		modelAndView.addObject("typeCheck", buildingUpgradationRequestDTO.getCheck());
		modelAndView.addObject("typeMaps", SystemConstant.typeTable());
		modelAndView.addObject("districtMaps", SystemConstant.districtTable());
		modelAndView.addObject("id", id);
		return modelAndView;
	}

}
