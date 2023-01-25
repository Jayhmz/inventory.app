package com.plantacion.inventory.app.controller;

import com.plantacion.inventory.app.service.AssetService;
import com.plantacion.inventory.app.util.CSVFileGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class CSVFileGeneratorController {
    @Autowired
    private AssetService assetService;
    @Autowired
    private CSVFileGenerator csvFileGenerator;

    @GetMapping("/download-csv")
    public void exportToCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=\"Asset-Verification-Updated-Register.csv\"");
        csvFileGenerator.generateCSV(assetService.getAllAssets(), response.getWriter());
    }
}
