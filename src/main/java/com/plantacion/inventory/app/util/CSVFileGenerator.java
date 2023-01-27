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
        String[] header = {"ASSET ID (OLD)", "ASSET NAME", "ASSET CATEGORY", "ASSET LOCATION", "ASSET SERIAL NO", "ASSET USER", "NEW ASSET ID",
        "ASSET STATUS", "ASSET MOVEMENT DETAIL", "ASSET AVAILABILITY", "COMPONENT ID", "COMPONENT NAME", "COMPONENT SERIAL NO",
        "COMPONENT NEW ID", "COMPONENT COMPONENT AVAILABLITY", "COMPONENT MOVEMENT DETAIL", "COMPONENT STATUS"};
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.EXCEL.withHeader(header));

        for (Asset asset : assets) {
//            System.out.println(">>>>>>>>>>>> Component id = "+asset.getComponent().getComponent_Id());
//            if(asset.getComponent() == null){
//                printer.printRecord(asset.getAsset_Id(), asset.getAsset_Name(), asset.getAsset_Category(),
//                        asset.getAsset_Location(), asset.getAsset_Serial_No(), asset.getAsset_User(), asset.getNew_AssetId(),
//                        asset.getStatus(), asset.getMovement_Details(), asset.getAvailability_Details());
//            }
            printer.printRecord(asset.getAsset_Id(), asset.getAsset_Name(), asset.getAsset_Category(),
                    asset.getAsset_Location(), asset.getAsset_Serial_No(), asset.getAsset_User(), asset.getNew_AssetId(),
                    asset.getStatus(), asset.getMovement_Details(), asset.getAvailability_Details(),
                    asset.getComponent().getComponent_Id(),asset.getComponent().getComponent_Name(), asset.getComponent().getComponent_Serial_No(),
                    asset.getComponent().getNew_ComponentId(), asset.getComponent().getAvailability_Details(), asset.getComponent().getMovement_Details(), asset.getComponent().getStatus()
            );
        }
    }
}
