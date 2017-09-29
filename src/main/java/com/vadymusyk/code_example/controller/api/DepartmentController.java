package com.vadymusyk.code_example.controller.api;

import com.vadymusyk.code_example.dto.company.DepartmentDTO;
import com.vadymusyk.code_example.dto.filter.DepartmentFilterDTO;
import com.vadymusyk.code_example.facade.CompanyFacade;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by vadymusyk on 14.08.17.
 */
@RestController
@RequestMapping(path = "/api/department")
@Api("department")
public class DepartmentController {

    private CompanyFacade companyFacade;

    @Autowired
    public DepartmentController(CompanyFacade companyFacade) {
        this.companyFacade = companyFacade;
    }

//method, that makes filtering by properties in DepartmentFilterDTO

    @GetMapping
    public List<DepartmentDTO> getDepartmentsByFilter(@ModelAttribute DepartmentFilterDTO departmentFilterDTO) {
        return companyFacade.getDepartmentsByFilter(departmentFilterDTO);
    }

    //user add rate to deparmtnet, than total rating calculates by Wilsons score interval algorithm

    @PutMapping("/{departmentId}/vote")
    public DepartmentDTO voteForDepartment(@PathVariable("departmentId") long departmentId,
                                           @RequestParam(value = "rate") int rate) {
        return companyFacade.voteForDepartment(departmentId, rate);
    }


}
