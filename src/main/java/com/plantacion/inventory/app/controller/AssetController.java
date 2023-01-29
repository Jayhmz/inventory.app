package com.plantacion.inventory.app.controller;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.model.dto.AssetComponentDTO;
import com.plantacion.inventory.app.model.dto.AssetDTO;
import com.plantacion.inventory.app.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewCreateAssetPage(@ModelAttribute("asset") AssetDTO asset, @ModelAttribute("component")AssetComponentDTO componentDTO){
        return "create-asset";
    }

    @PostMapping("/create-asset")
    public String createAssetPage(@Valid @ModelAttribute("asset") AssetDTO asset, BindingResult result, Model model){
        if (result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error : errors){
                System.out.println(">>>>>>>> "+error);
            }
            return "create-asset";
        }
        service.save(asset);
        model.addAttribute("success", "Asset created successfully");
        return "redirect:/";
    }

}
