package com.plantacion.inventory.app.controller;

import com.plantacion.inventory.app.model.domain.Asset;
import com.plantacion.inventory.app.service.AssetService;
import com.plantacion.inventory.app.util.CSVFileGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class CSVFileGeneratorController {
    @Autowired
    private AssetService assetService;
    @Autowired
    private CSVFileGenerator csvFileGenerator;

    @GetMapping("/download-csv")
    public void exportToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=\"Asset-Verification-Updated-Register\".csv\"");
        csvFileGenerator.generateCSV(assetService.getAllAssets(), response.getWriter());
    }
    @GetMapping("/test")
    public void test(){
        List<Asset> allAssets = assetService.getAllAssets();
        for(Asset asset : allAssets){
            System.out.println(">>>>>>>>"+asset);
            System.out.println(asset.getComponent().getComponent_Id()+"<<<<<<<<<<");
        }

    }
}
