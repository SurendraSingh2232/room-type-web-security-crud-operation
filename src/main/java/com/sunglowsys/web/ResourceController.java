package com.sunglowsys.web;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ResourceController {

    private final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    private final RoomTypeService roomTypeService;

    public ResourceController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping
    public ModelAndView home(){
        logger.debug("WEB request to create Home Page:");
        Page<RoomType> page = roomTypeService.findAll(PageRequest.of(0,20));
        return new ModelAndView("index","roomType", page.getContent());
    }
    @GetMapping("/room-types")
    public ModelAndView createRoomTypeForm(){
        logger.debug("request to create roomTypes:");
        return new ModelAndView("add-roomType","roomTypes",new RoomType());
    }
    @PostMapping("/room-types")
    public String createRoomType(@ModelAttribute RoomType roomType){
        logger.debug("request to create roomTypes: {} ",roomType);
        roomTypeService.saveRoomType(roomType);
        return "redirect:/";
    }
    @GetMapping("/room-type/update/{id}")
    public ModelAndView update(@PathVariable Long id){
        logger.debug("request to update roomTypes: {} ",id);
        return new ModelAndView("add-roomType","roomType",roomTypeService.findById(id).get());
    }
    @GetMapping("/room-type/delete/{id}")
    public String delete(@PathVariable Long id){
        roomTypeService.delete(id);
        return "redirect:/";
    }
}
