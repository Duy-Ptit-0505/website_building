package com.htdweb.controller.admin;

import com.htdweb.model.dto.AccountDTO;
import com.htdweb.model.dto.BuildingDTO;
import com.htdweb.service.BuildingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/admin/home")
    public ModelAndView homePage(){
        ModelAndView mav = new ModelAndView("/admin/index");
//        ModelAndView mav = new ModelAndView("/admin/test");
        return mav;
    }
    @GetMapping("/admin/add-building")
    public ModelAndView addBuilding(@ModelAttribute BuildingDTO buildingDTO){
        ModelAndView mav = new ModelAndView("/admin/add-building");
        mav.addObject("modelAdd", buildingDTO);
        return mav;
    }
    @GetMapping("/admin/hihi")
    public void addBuilding(@RequestBody(required = false) AccountDTO accountDTO){

        System.out.println("hihi");
    }

    @PostMapping("/admin/add-building")
    public String addOrUpdateBuilding(@ModelAttribute("modelAdd") BuildingDTO buildingDTO){
        buildingService.addOrUpdateBuilding(buildingDTO);
        return "admin/index";
    }
    @GetMapping("/admin/test")
    public ModelAndView test(){
        return new ModelAndView("/web/rent");
    }
    @GetMapping("/admin/check-order")
    public ModelAndView adminCheckOrder(){
        ModelAndView mav = new ModelAndView("/admin/check-order");

        return mav;
    }
}
