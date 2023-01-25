package com.plantacion.inventory.app.util;

import com.plantacion.inventory.app.model.domain.Asset;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Component
public class CSVFileGenerator {

    public void generateCSV(List<Asset> assets, Writer writer) throws IOException {
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.EXCEL);
        for (Asset asset : assets) {
            printer.printRecord(asset.getAsset_Id(), asset.getAsset_Name(), asset.getAsset_Category(),
                    asset.getAsset_Location(), asset.getAsset_Serial_No(), asset.getAsset_User(), asset.getNew_AssetId(),
                    asset.getStatus(), asset.getMovement_Details(), asset.getAvailability_Details());
        }
    }
}
