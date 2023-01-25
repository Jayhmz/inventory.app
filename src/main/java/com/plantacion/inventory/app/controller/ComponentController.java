package com.plantacion.inventory.app.controller;

import com.plantacion.inventory.app.model.dto.AssetComponentDTO;
import com.plantacion.inventory.app.model.dto.AssetDTO;
import com.plantacion.inventory.app.service.ComponentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ComponentController {

    private final ComponentService service;

    public ComponentController(ComponentService service) {
        this.service = service;
    }

    @PostMapping("/add-component")
    public String createAssetPage(@Valid @ModelAttribute("component") AssetComponentDTO component, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error : errors){
                System.out.println(">>>>>>>> "+error);
            }
            return "redirect:/";
        }
        service.save(component);
        return "redirect:/";
    }
}
