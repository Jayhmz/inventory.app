package com.plantacion.inventory.app.controller;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewCreateAssetPage(@ModelAttribute("asset") Asset asset){
        return "create-asset";
    }

    @PostMapping("/create-asset")
    public String createAssetPage(@Valid @ModelAttribute("asset") Asset asset, BindingResult result){
        if (result.hasErrors()){
            System.out.println("result has errors");
        }

        service.save(asset);
        return "redirect:/";
    }

}
